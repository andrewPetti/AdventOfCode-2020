package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay09;
import com.google.common.collect.ImmutableList;

import java.util.Collections;

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
                        break;
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
        Long result = partB(_filename, 25);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    Long partB(String filename, int preambleLength) {
        ImmutableList<Long> numbers = _fileHelper.fileToLongList(filename);

        Long badValue = partA(filename, preambleLength);

        for (int i = 0; i < numbers.size(); i++) {
            int pos = i + 1;
            Long sum = numbers.get(i);
            boolean cont = true;
            while (cont) {
                sum += numbers.get(pos);
                if (sum > badValue) {
                    cont = false;
                } else if (sum < badValue) {
                    pos++;
                } else {
                    return sumOfSmallestAndLargest(numbers.subList(i, pos + 1));
                }
            }
        }
        return 0L;
    }

    Long sumOfSmallestAndLargest(ImmutableList<Long> subList) {
        return Collections.min(subList) + Collections.max(subList);
    }

    @Override
    protected String getName() {
        return "Day0 09";
    }
}
