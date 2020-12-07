package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.*;

import java.util.List;

public class Day01 extends AbstractDay {

    @Override
    public void executePartA() {
        System.out.println("Day 01 Part Find two entries taht add to 2020 and multiply them");

        List<Integer> inputs = _fileHelper.fileToIntegerList(InputDay01.input);//InputDay01.rawInput; // InputDay01.sample;

        Integer product = partA(inputs);
        System.out.println(
                "The product of the two numbers that add to 2020 is:  " + formatAnswer(product));
    }

    public Integer partA(List<Integer> inputs) {
        for (int i = 0; i < inputs.size() - 1; i++) {
            Integer first = inputs.get(i);
            for (int j = i + 1; j < inputs.size(); j++) {
                Integer second = inputs.get(j);

                if (first + second == 2020) {
                    return first * second;
                }
            }
        }
        return null;
    }

    @Override
    public void executePartB() {
        System.out.println("Day 01 Part Find three entries taht add to 2020 and multiply them");

        List<Integer> inputs = InputDay01.rawInput; // InputDay01.sample;
        Integer product = partB(inputs);
        System.out.println("The product of the three numbers that add to 2020 is: "
                + formatAnswer(product));
    }

    public Integer partB(List<Integer> inputs) {
        for (int i = 0; i < inputs.size() - 2; i++) {
            Integer first = inputs.get(i);
            for (int j = i + 1; j < inputs.size() - 1; j++) {
                Integer second = inputs.get(j);
                for (int k = j + 1; k < inputs.size(); k++) {
                    Integer third = inputs.get(k);

                    if (first + second + third == 2020) {
                        return first * second * third;
                    }
                }
            }
        }
        return null;
    }

    @Override
    protected String getName() {
        return "Day 01";
    }
}
