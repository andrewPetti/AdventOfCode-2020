package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

public class Day16 extends AbstractDay {
    @Override
    public void executePartA() {
        int result = partA(Inputs.DAY16_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String filename) {
        ImmutableList<ImmutableList<String>> sections = _fileHelper.fileToGroupedList(filename);
        ImmutableList<String> rules = sections.get(0);

        ArrayList<ArrayList<Integer>> validRanges = getRules(rules);

        //
        ArrayList<ArrayList<Integer>> nearbyTickets = getNearbyTickets(sections.get(2));

        int sum = 0;
        for (int i = 0; i < nearbyTickets.size(); i++) {
            for (Integer value : nearbyTickets.get(i)) {
                if (!isValueValid(value, validRanges)) {
                    sum += value;
                }
            }
        }
        return sum;
    }

    private boolean isValueValid(Integer value, ArrayList<ArrayList<Integer>> validRanges) {
        for (ArrayList<Integer> ranges : validRanges) {
            if ((value >= ranges.get(0) && value <= ranges.get(1)) ||
                    value >= ranges.get(2) && value <= ranges.get(3)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<ArrayList<Integer>> getNearbyTickets(ImmutableList<String> section) {
        ArrayList<ArrayList<Integer>> tickets = new ArrayList<>();
        for (int i = 1; i < section.size(); i++) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] values = section.get(i).split(",");
            for (int j = 0; j < values.length; j++) {
                list.add(Integer.parseInt(values[j]));
            }
            tickets.add(list);
        }
        return tickets;
    }

    private ArrayList<ArrayList<Integer>> getRules(ImmutableList<String> rules) {
        ArrayList<ArrayList<Integer>> ranges = new ArrayList<>();
        rules.forEach(rule -> {
            ArrayList<Integer> range = new ArrayList<>();
            String[] ruleParts = rule.split(":");
            String[] ruleValues = ruleParts[1].split(" or ");
            for (int i = 0; i < 2; i++) {
                String[] numbers = ruleValues[i].trim().split("-");
                range.add(Integer.parseInt(numbers[0]));
                range.add(Integer.parseInt(numbers[1]));
            }
            ranges.add(range);
        });
        return ranges;
    }

    @Override
    public void executePartB() {

    }

    @Override
    protected String getName() {
        return "Day 16";
    }
}
