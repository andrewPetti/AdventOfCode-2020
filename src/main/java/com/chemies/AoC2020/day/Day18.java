package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

import java.util.Optional;

public class Day18 extends AbstractDay {

    interface Solver {
        Long solve(String line);
    }

    Solver _solver;

    void solveA() {
        _solver = this::solve;
    }

    void solveB() {
        _solver = this::solveB;
    }

    @Override
    public void executePartA() {
        long result = partA(Inputs.DAY18_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    long partA(String filename) {
        ImmutableList<String> strings = _fileHelper.fileToStringList(filename);
        _solver = this::solve;
        long sum = strings.stream().mapToLong(this::processLine).sum();
        return sum;
    }

    long processLine(String line) {
        Optional<Pair<Integer, Integer>> solvableBracket = findSolvableBracket(line);
        String orig = line;
        while (solvableBracket.isPresent()) {

            long val = _solver.solve(line.substring(solvableBracket.get().getValue0() + 1,
                    solvableBracket.get().getValue1()));
            StringBuilder builder = new StringBuilder();
            builder.append(line.substring(0, solvableBracket.get().getValue0()));
            builder.append(Long.toString(val));
            if (solvableBracket.get().getValue1() < line.length() - 1) {
                builder.append(line.substring(solvableBracket.get().getValue1() + 1));
            }

            line = builder.toString();
            solvableBracket = findSolvableBracket(line);
        }
        long ans = _solver.solve(line);
        return ans;
    }

    Optional<Pair<Integer, Integer>> findSolvableBracket(String line) {
        int start = 0;

        for (int i = 0; i < line.length(); i++) {
            char pos = line.charAt(i);
            if (pos == '(') {
                start = i;
            } else if (pos == ')') {
                return Optional.of(Pair.with(start, i));
            }
        }
        return Optional.empty();
    }

    private Long solve(String line) {
        String[] parts = line.split(" ");
        int pos = 1;
        long ans = Long.parseLong(parts[0]);
        while (pos < parts.length) {
            Long val = Long.parseLong(parts[pos + 1]);
            if (parts[pos].equals("+")) {
                ans += val;
            } else {
                ans *= val;
            }
            pos += 2;
        }
        return ans;
    }

    private Long solveB(String line) {
        return 0L;
    }

    
    private boolean isNumber(char value) {
        return CharMatcher.inRange('0', '9').matches(value);
    }

    private boolean isOpenBracket(char value) {
        return CharMatcher.is('(').matches(value);
    }

    private boolean isCloseBracket(char value) {
        return CharMatcher.is(')').matches(value);
    }

    private boolean isAdd(char value) {
        return CharMatcher.is('+').matches(value);
    }

    private boolean isMultiply(char value) {
        return CharMatcher.is('*').matches(value);
    }

    @Override
    public void executePartB() {
        Long result = partB(Inputs.DAY18_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    Long partB(String filename) {
        ImmutableList<String> strings = _fileHelper.fileToStringList(filename);
        _solver = this::solveB;
        long sum = strings.stream().mapToLong(this::processLine).sum();
        return sum;
    }

    @Override
    protected String getName() {
        return "Day 18";

    }
}
