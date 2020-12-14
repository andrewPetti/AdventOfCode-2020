package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day14 extends AbstractDay {
    @Override
    public void executePartA() {
        long result = partA(Inputs.DAY14_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    long partB(String filename) {
        ImmutableList<String> inputs = _fileHelper.fileToStringList(filename);

        String mask = null;
        Map<Long, Long> mem = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i);
            if (line.startsWith("mask")) {
                mask = getMask(line);
            } else {
                String[] split = line.split(" = ");
                String[] memAddress = split[0].split("]");
                String address = memAddress[0].substring(4);
                for (Long memPos : maskMemory(mask, Integer.parseInt(address))) {
                    Long value = Long.parseLong(split[1]);
                    mem.put(memPos, value);
                }
            }

        }
        var sum = new Object() {
            Long val = 0L;
        };
        mem.forEach((k, v) -> sum.val += v);
        return sum.val;
    }

    @Override
    public void executePartB() {
        long result = partB(Inputs.DAY14_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    Long partA(String filename) {
        ImmutableList<String> inputs = _fileHelper.fileToStringList(filename);

        String mask = null;
        Map<String, Long> mem = new HashMap<>();
        for (int i = 0; i < inputs.size(); i++) {
            String line = inputs.get(i);
            if (line.startsWith("mask")) {
                mask = getMask(line);
            } else {
                String[] split = line.split(" = ");
                assert mask != null;
                mem.put(split[0], calcMask(mask, Integer.parseInt(split[1])));
            }

        }
        var sum = new Object() {
            Long val = 0L;
        };
        mem.forEach((k, v) -> sum.val += v);
        return sum.val;
    }

    private String getMask(String s) {
        String[] split = s.split(" = ");
        return split[1];
    }

    @Override
    protected String getName() {
        return "Day 14";
    }

    public Long calcMask(String mask, int input) {
        StringBuilder binary = getBinary(input);

        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '1' || c == '0') {
                binary.setCharAt(i, c);
            }
        }
        return Long.parseLong(binary.toString(), 2);
    }

    private StringBuilder getBinary(int input) {
        String orig = String.format("%36s", Integer.toBinaryString(input)).replace(' ', '0');
        return new StringBuilder(orig);
    }

    public ImmutableList<Long> maskMemory(String mask, int mem) {
        ArrayList<Long> list = new ArrayList<>();
        StringBuilder binary = getBinary(mem);
        int flips = CharMatcher.is('X').countIn(mask);
        for (String str : flipMemory(mask, binary.toString())) {
            list.add(Long.parseLong(str, 2));
        }

        return ImmutableList.copyOf(list);
    }

    private ImmutableList<String> flipMemory(String mask, String binary) {
        int nextFloating = CharMatcher.is('X').indexIn(mask);
        StringBuilder base = new StringBuilder();
        int loopEnd = nextFloating > -1 ? nextFloating : mask.length();
        for (int i = 0; i < loopEnd; i++) {
            if (mask.charAt(i) == '1') {
                base.append("1");
            } else {
                base.append(binary.charAt(i));
            }
        }

        ArrayList<String> list = new ArrayList<>();
        if (nextFloating == mask.length() - 1) {
            list.add(base.toString() + "0");
            list.add(base.toString() + "1");
        } else if (nextFloating == -1) {
            list.add(base.toString());
            list.add(base.toString());
        } else {
            for (String str : flipMemory(mask.substring(nextFloating + 1), binary.substring(nextFloating + 1))) {
                list.add(base.toString() + "0" + str);
                list.add(base.toString() + "1" + str);
            }
        }
        return ImmutableList.copyOf(list);
    }
}
