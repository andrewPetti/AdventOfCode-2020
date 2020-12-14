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
        long result = partB(Inputs.DAY13_INPUT, 100000000000000L);
        System.out.println("PartA Ans: " + formatAnswer(result));

    }

    long partB(String filename, long startGuess) {
        ImmutableList<String> inputs = _fileHelper.fileToStringList(filename);
        String line = inputs.get(1);

        return processChineeseRemainderThereom(line);
    }

    // https://www.youtube.com/watch?v=zIFehsBHB8o
    //https://repl.it/@BrianMoore1/AdventOfCode2020#Days/Days08-14/Day13.java
    // still makes my head hurt some.
    long processChineeseRemainderThereom(String line) {
        String[] schedule = line.split(",");
        ArrayList<Integer> ni = new ArrayList<>();
        ArrayList<Integer> bi = new ArrayList<>();
        ArrayList<Long> Ni = new ArrayList<>();
        ArrayList<Integer> xi = new ArrayList<>();

        long N = 1;
        for (int i = 0; i < schedule.length; i++) {
            if (!schedule[i].equals("x")) {
                int bus = Integer.parseInt(schedule[i]);
                ni.add(bus);
                bi.add((-1 * i) % bus + bus);
                N *= bus;
            }
        }

        for (int j = 0; j < ni.size(); j++) {
            Ni.add(N / ni.get(j));
            xi.add(getInverse(Ni.get(j), ni.get(j)));
        }

        long sum = 0;
        for (int k = 0; k < ni.size(); k++) {
            sum += bi.get(k) * Ni.get(k) * xi.get(k);
        }

        return sum % N;
    }

    private Integer getInverse(Long Ni, Integer ni) {
        int xi = 1;
        while ((Ni * xi) % ni != 1) {
            xi++;
        }
        return xi;
    }

    long processBad(long startGuess, ImmutableList<Integer> valid, String line) {
        String[] schedule = line.split(",");
        final int first = Integer.parseInt(schedule[0]);
        final int last = Integer.parseInt(schedule[schedule.length - 1]);
        final int delta = schedule.length - 1;
        boolean cont = true;
        int jump = 0;//last * first;
        long startTime = (startGuess / (first * last)) * first * last;
        long count = 0;
        while (cont) {
            if (count % 100000000L == 0) {
                System.out.println(String.format("Testing startTime %d on iteration count %d", startTime, count));
            }
            if ((startTime + delta) % last == 0) {
                jump = first * last;
                boolean found = false;
                for (int i = 1; i < delta; i++) {
                    if (schedule[i].equals("x")) {
                        continue;
                    } else {
                        found = isBusValid((startTime + i), Integer.parseInt(schedule[i]));
                    }
 /*                   if (schedule[i].equals("x")) {
                        found = isAnyBusValid(startTime + 1, valid);
                    } else {
                        found = isBusValid(startTime + 1, Integer.parseInt(schedule[i]));
                    }
*/
                    if (!found) {
                        break;
                    }
                }
                if (found) {
                    return startTime;
                }
            }
            if (jump > 0) {
                startTime += jump;
            } else {
                startTime += first;
            }
            count++;

        }
        /* return startTime; */
        return -1;
    }

    private boolean isBusValid(long time, int bus) {
        if (time % bus == 0) {
            return true;
        }
        return false;
    }

    private boolean isAnyBusValid(long time, ImmutableList<Integer> valid) {

        //valid.stream().filter(v -> isBusValid(time, v)).mapToInt(i->1).sum();

        for (int i = 0; i < valid.size(); i++) {
            if (isBusValid(time, valid.get(i))) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected String getName() {
        return "Day 13";
    }
}
