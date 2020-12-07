package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;

public class Day05 extends AbstractDay {

    @Override
    public void executePartA() {
        String filename = InputsDay05.inputs;
        int result = partA(filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    public int partA(String filename) {
        var max =
                new Object() {
                    int value = -1;
                };
        ImmutableList<String> list = _fileHelper.fileToStringList(filename);

        list.forEach(
                pass -> {
                    int seat = calcSeat(pass);
                    if (seat > max.value) {
                        max.value = seat;
                    }
                });
        return max.value;
    }

    @Override
    public void executePartB() {
        String filename = InputsDay05.inputs;
        int result = partB(filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    private int partB(String filename) {
        var seatList =
                new Object() {
                    ArrayList<Integer> list = new ArrayList<>();
                };
        ImmutableList<String> list = _fileHelper.fileToStringList(filename);

        list.forEach(
                pass -> seatList.list.add(calcSeat(pass)));

        ImmutableSet<Integer> seatSet = ImmutableSet.copyOf(seatList.list);
        for (int i = 2; i <= 858; i++) {
            if (!seatSet.contains(i)) {
                if (seatSet.containsAll(ImmutableSet.of(i - 1, i + 1))) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int calcSeat(String pass) {
        int row = calcRow(pass);
        int col = calcColumn(pass);
        return (row * 8) + col;
    }

    public int calcColumn(String pass) {
        int low = 0;
        int high = 7;

        return calcPos(pass.substring(7, 10), low, high, 'L');
    }

    public int calcRow(String pass) {
        int low = 0;
        int high = 127;

        return calcPos(pass.substring(0, 7), low, high, 'F');
    }

    public int calcPos(String pass, int low, int high, char lookup) {

        for (int i = 0; i < pass.length() - 1; i++) {
            int delta = (high - low) / 2;
            if (pass.charAt(i) == lookup) {
                high = low + delta;
            } else {
                low = low + delta + 1;
            }
        }
        int row = high;
        if (pass.charAt(pass.length() - 1) == lookup) {
            row = low;
        }

        return row;
    }

    @Override
    protected String getName() {
        return "Day 05";
    }
}
