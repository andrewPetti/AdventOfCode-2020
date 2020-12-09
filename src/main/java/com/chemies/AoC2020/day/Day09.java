package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay09;
import com.google.common.collect.ImmutableList;

public class Day09 extends AbstractDay {
    private final String _filename = InputsDay09.INPUTS;

    @Override
    public void executePartA() {
        Long result = partA(_filename, 25);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    Long partA(String filename, Integer preambleLength) {
        ImmutableList<Long> numbers = _fileHelper.fileToLongList(filename);

        for (int i = preambleLength; i < numbers.size(); i++) {
            Long current = numbers.get(i);
            boolean valid = false;
            ImmutableList<Long> previousNumbers = numbers.subList(i - preambleLength, i);
            for (int j = 0; j < preambleLength - 1; j++) {
                Long a = previousNumbers.get(j);
                for (int k = j + 1; k < preambleLength; k++) {
                    Long b = previousNumbers.get(k);
                    if (a + b == current) {
                        valid = true;
                    }

                }
            }
            if (!valid) {
                return current;
            }
        }
        return 0L;
    }

    @Override
    public void executePartB() {
        int result = partB(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partB(String filename) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Day0 09";
    }
}
