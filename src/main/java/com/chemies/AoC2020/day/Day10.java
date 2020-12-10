package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay10;

public class Day10 extends AbstractDay {
    @Override
    public void executePartA() {
        int result = partA(InputsDay10.INPUTS);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String filename) {
        return -1;
    }

    @Override
    public void executePartB() {
        int result = partB(InputsDay10.INPUTS);

        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    int partB(String filename) {
        return 1;
    }

    @Override
    protected String getName() {
        return "Day 10";
    }
}
