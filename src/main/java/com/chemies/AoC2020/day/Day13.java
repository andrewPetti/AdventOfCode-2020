package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

import java.util.ArrayList;

public class Day13 extends AbstractDay {
    @Override
    public void executePartA() {
        int result = partA(Inputs.DAY13_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String filename) {
        ImmutableList<String> inputs = _fileHelper.fileToStringList(filename);

        int earilestDepart = Integer.parseInt(inputs.get(0));
        String line = inputs.get(1);
        ImmutableList<Integer> validBuses = getActiveBuses(line);

        ArrayList<Pair<Integer, Integer>> departs = new ArrayList<>();
        validBuses.forEach(bus -> {
            int time = (earilestDepart / bus) * bus;
            departs.add(Pair.with(time, bus));
        });

        var depart = new Object() {
            Pair<Integer, Integer> info = Pair.with(-1, -1);
        };
        departs.forEach(info -> {
            int time = info.getValue0() + info.getValue1();
            if (time < depart.info.getValue0() || depart.info.getValue0() == -1) {
                depart.info = Pair.with(time, info.getValue1());
            }
        });


        return (depart.info.getValue0() - earilestDepart) * depart.info.getValue1();
    }

    private ImmutableList<Integer> getActiveBuses(String line) {
        String[] parts = line.split(",");
        ArrayList<Integer> valid = new ArrayList<>();
        for (String str : parts) {
            if (!str.equals("x")) {
                valid.add(Integer.parseInt(str));
            }
        }

        return ImmutableList.copyOf(valid);
    }

    @Override
    public void executePartB() {
        int result = partB(Inputs.DAY13_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));

    }

    int partB(String filename) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Day 13";
    }
}
