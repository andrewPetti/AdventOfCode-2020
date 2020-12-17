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
        for (ArrayList<Integer> nearbyTicket : nearbyTickets) {
            for (Integer value : nearbyTicket) {
                if (!isValueValid(value, validRanges)) {
                    sum += value;
                }
            }
        }
        return sum;
    }

    private boolean isValueValid(Integer value, ArrayList<ArrayList<Integer>> validRanges) {
        for (ArrayList<Integer> ranges : validRanges) {
            if (isValidForRange(value, ranges)) return true;
        }
        return false;
    }

    private boolean isValidForRange(Integer value, ArrayList<Integer> range) {
        return (value >= range.get(0) && value <= range.get(1)) ||
                value >= range.get(2) && value <= range.get(3);
    }

    private ArrayList<ArrayList<Integer>> getNearbyTickets(ImmutableList<String> section) {
        ArrayList<ArrayList<Integer>> tickets = new ArrayList<>();
        for (int i = 1; i < section.size(); i++) {
            ArrayList<Integer> list = new ArrayList<>();
            String[] values = section.get(i).split(",");
            for (String value : values) {
                list.add(Integer.parseInt(value));
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
        int result = partB(Inputs.DAY16_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    private int partB(String filename) {
        ImmutableList<ImmutableList<String>> sections = _fileHelper.fileToGroupedList(filename);
        ImmutableList<String> rules = sections.get(0);

        ArrayList<ArrayList<Integer>> validRanges = getRules(rules);
        ImmutableList<String> fields = getFields(rules);
        int numFields = fields.size();

        //
        ArrayList<ArrayList<Integer>> nearbyTickets = getNearbyTickets(sections.get(2));

        int sum = 0;
        ArrayList<ArrayList<Integer>> validTickets = new ArrayList<>();
        for (ArrayList<Integer> nearbyTicket : nearbyTickets) {
            boolean valid = true;
            for (Integer value : nearbyTicket) {
                if (!isValueValid(value, validRanges)) {
                    valid = false;
                }
            }
            if (valid) {
                validTickets.add(nearbyTicket);
            }
        }

        ArrayList<ArrayList<Integer>> columns = new ArrayList<>();
        for (int k = 0; k < validTickets.get(0).size(); k++) {
            ArrayList<Integer> column = new ArrayList<>();
            columns.add(column);
        }

        for (ArrayList<Integer> ticket : validTickets) {
            for (int i = 0; i < ticket.size(); i++) {
                columns.get(i).add(ticket.get(i));
            }
        }

        int[][] match = new int[validTickets.size()][numFields];

        for (ArrayList<Integer> col : columns) {
            for (int n = 0; n < col.size(); n++) {
                Integer val = col.get(n);
                for (int m = 0; m < validRanges.size(); m++) {

                    if (!isValidForRange(val, validRanges.get(m))) {
                        match[n][m] = -1;
                    }
                }
            }
        }

        //find colum with just one field is valid and back track


        return sum;
    }

    private ImmutableList<String> getFields(ImmutableList<String> rules) {
        ArrayList<String> fields = new ArrayList<>();
        rules.forEach(rule -> {
            ArrayList<Integer> range = new ArrayList<>();
            String[] ruleParts = rule.split(":");
            fields.add(ruleParts[0]);
        });
        return ImmutableList.copyOf(fields);
    }

    @Override
    protected String getName() {
        return "Day 16";
    }
}
