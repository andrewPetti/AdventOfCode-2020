package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay08;
import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.Set;

public class Day08 extends AbstractDay {
    private final String _filename = InputsDay08.INPUTS;

    @Override
    public void executePartA() {
        int result = partA(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    @Override
    public void executePartB() {
        int result = partB(_filename);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    @Override
    protected String getName() {
        return "Day 08";
    }


    public int partA(String filename) {

        ImmutableList<String> instructions = _fileHelper.fileToStringList(filename);
        Set<Integer> executed = new HashSet<>();

        boolean cont = true;
        int pos = 0;
        int accumulator = 0;
        while (cont) {
            if (!executed.contains(pos)) {
                executed.add(pos);
                String currentInstruction = instructions.get(pos);
                String[] parts = currentInstruction.split(" ");
                String op = parts[0].trim();
                int arg = Integer.parseInt(parts[1].trim());
                switch (op) {
                    case "nop":
                        pos++;
                        break;
                    case "acc":
                        pos++;
                        accumulator += arg;
                        break;
                    case "jmp":
                        pos += arg;
                        break;
                }
            } else {
                cont = false;
            }
        }
        return accumulator;
    }

    public int partB(String filename) {
        ImmutableList<String> instructions = _fileHelper.fileToStringList(filename);

        int num = (int) instructions.stream().filter(s -> s.contains("nop") || s.contains("jmp")).count();
        boolean cont = true;
        int accumulator = 0;
        int adjust = 0;
        while (cont) {

            int pos = 0;
            accumulator = 0;
            boolean contInner = true;
            boolean completed = false;
            Set<Integer> executed = new HashSet<>();
            int adjustedAttempts = 0;
            while (contInner) {
                if (pos == instructions.size()) {
                    completed = true;
                    contInner = false;
                } else if (executed.contains(pos)) {
                    contInner = false;
                } else {
                    executed.add(pos);
                    String currentInstruction = instructions.get(pos);
                    String[] parts = currentInstruction.split(" ");
                    String op = parts[0].trim();
                    int arg = Integer.parseInt(parts[1].trim());
                    switch (op) {
                        case "nop":
                            if (adjustedAttempts == adjust) {
                                pos += arg;
                            } else {
                                pos++;
                            }
                            adjustedAttempts++;
                            break;
                        case "acc":
                            pos++;
                            accumulator += arg;
                            break;
                        case "jmp":
                            if (adjustedAttempts == adjust) {
                                pos++;
                            } else {
                                pos += arg;
                            }
                            adjustedAttempts++;
                            break;
                    }
                }
            }
            if (completed) {
                cont = false;
            }
            adjust++;
        }
        return accumulator;
    }
}
