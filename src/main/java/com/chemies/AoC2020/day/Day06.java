package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay06;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;

public class Day06 extends AbstractDay {

    private final String _filename = InputsDay06.INPUTS;

    @Override
    public void executePartA() {
        long result = partA(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    public long partA(String filename) {
        ImmutableList<String> answers = _fileHelper.fileToStringList(filename);

        //ArrayList<String> combinedList = new ArrayList<>();
        long sum = 0;
        StringBuilder combined = new StringBuilder();
        for (int i = 0; i < answers.size(); i++) {
            String line = answers.get(i);
            if (line.isEmpty()) {

                sum += combined
                        .chars()
                        .distinct()
                        .count();
                combined = new StringBuilder();
            } else {
                combined.append(line);
            }
        }
        sum += combined.chars().distinct().count();
        return sum;
    }

    @Override
    public void executePartB() {
        long result = partB(_filename);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    public long partB(String filename) {
        ImmutableList<String> answers = _fileHelper.fileToStringList(filename);
        long sum = 0;
        StringBuilder combined = new StringBuilder();
        int partySize = 0;
        for (int i = 0; i < answers.size(); i++) {
            String line = answers.get(i);
            if (line.isEmpty()) {
                sum += countPartyHasSameAnswer(combined.toString(), partySize);
                combined = new StringBuilder();
                partySize = 0;
            } else {
                combined.append(line);
                partySize++;
            }
        }
        sum += countPartyHasSameAnswer(combined.toString(), partySize);
        return sum;
    }

    private long countPartyHasSameAnswer(String line, int partySize) {
        var comb = new Object() {
            String combined;
            int partySize;
            long sum;
        };
        comb.partySize = partySize;
        comb.combined = line;
        @SuppressWarnings("SpellCheckingInspection") String _letters = "abcdefghijklmnopqrstuvwxyz";
        _letters.chars()
                .mapToObj(j -> (char) j)
                .mapToLong(k -> CharMatcher.is(k)
                        .countIn(comb.combined))
                .filter(count -> count == comb.partySize)
                .forEach(count -> comb.sum++);
        return comb.sum;
    }

    @Override
    protected String getName() {
        return "Day 06";
    }
}
