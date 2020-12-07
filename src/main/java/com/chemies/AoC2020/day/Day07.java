package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay07;

public class Day07 extends AbstractDay {
    private final String _filename = InputsDay07.INPUTS;

    @Override
    public void executePartA() {
        int result = partA(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    protected int partA(String filename) {
        return 0;
    }

    @Override
    public void executePartB() {
        int result = partB(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    protected int partB(String filename) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Day 07";
    }
}
