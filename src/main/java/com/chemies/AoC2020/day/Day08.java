package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay08;

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
        return 0;
    }

    public int partB(String filename) {
        return 0;
    }
}
