package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;

public class Day06 extends AbstractDay {

    private final String _filename = Inputs.DAY06_INPUT;

    @Override
    public void executePartA() {
        long result = partA(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    public long partA(String filename) {
        ImmutableList<ImmutableList<String>> answers = _fileHelper.fileToGroupedList(filename);

        long sum = 0;
        for (int i = 0; i < answers.size(); i++) {
            ImmutableList<String> grouped = answers.get(i);
            StringBuilder combined = new StringBuilder();
            grouped.forEach(combined::append);
            sum += combined.toString().chars().distinct().count();
        }
        return sum;
    }

    @Override
    public void executePartB() {
        long result = partB(_filename);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    public long partB(String filename) {
        ImmutableList<ImmutableList<String>> answers = _fileHelper.fileToGroupedList(filename);
        long sum = 0;
        for (int i = 0; i < answers.size(); i++) {
            ImmutableList<String> group = answers.get(i);
            int partySize = group.size();
            StringBuilder combined = new StringBuilder();
            group.forEach(combined::append);
            sum += countPartyHasSameAnswer(combined.toString(), partySize);
        }
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
        String letters = "abcdefghijklmnopqrstuvwxyz";
        letters.chars()
                .mapToLong(k -> CharMatcher.is((char) k)
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
