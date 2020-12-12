package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay12;
import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

import static java.lang.Math.abs;

public class Day12 extends AbstractDay {
    @Override
    public void executePartA() {
        int result = partA(InputsDay12.INPUTS);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String filename) {
        ImmutableList<String> list = _fileHelper.fileToStringList(filename);
        var currentHeading = new Object() {
            int val = 90;
            Pair<Integer, Integer> pos = new Pair<>(0, 0);

        };

        list.forEach(line -> {
            Pair<Character, Integer> instruct = readInstruct(line);
            Integer delta = instruct.getValue1();
            switch (instruct.getValue0()) {
                case 'N':
                    currentHeading.pos = moveNorth(delta, currentHeading.pos);
                    break;
                case 'S':
                    currentHeading.pos = moveSouth(delta, currentHeading.pos);
                    break;
                case 'E':
                    currentHeading.pos = moveEast(delta, currentHeading.pos);
                    break;
                case 'W':
                    currentHeading.pos = moveWest(delta, currentHeading.pos);
                    break;
                case 'L':
                    currentHeading.val = turnLeft(delta, currentHeading.val);
                    break;
                case 'R':
                    currentHeading.val = turnRight(delta, currentHeading.val);
                    break;
                case 'F':
                    currentHeading.pos = moveForward(delta, currentHeading.pos, currentHeading.val);
                    break;
            }
        });
        System.out.println(currentHeading.pos);
        return calcManhattanDist(currentHeading.pos);
    }

    private int calcManhattanDist(Pair<Integer, Integer> pos) {
        return abs(pos.getValue0()) + abs(pos.getValue1());

    }

    private Pair<Integer, Integer> moveForward(Integer delta, Pair<Integer, Integer> pos, int currentHeading) {
        switch (currentHeading) {
            case 0:
                return moveNorth(delta, pos);
            case 90:
                return moveEast(delta, pos);
            case 180:
                return moveSouth(delta, pos);
            case 270:
                return moveWest(delta, pos);
        }
        return Pair.with(0, 0);
    }

    private Pair<Integer, Integer> moveNorth(int delta, Pair<Integer, Integer> pos) {
        return Pair.with(pos.getValue0(), pos.getValue1() + delta);
    }

    private Pair<Integer, Integer> moveSouth(int delta, Pair<Integer, Integer> pos) {
        return Pair.with(pos.getValue0(), pos.getValue1() - delta);
    }

    private Pair<Integer, Integer> moveEast(int delta, Pair<Integer, Integer> pos) {
        return Pair.with(pos.getValue0() + delta, pos.getValue1());
    }

    private Pair<Integer, Integer> moveWest(int delta, Pair<Integer, Integer> pos) {
        return Pair.with(pos.getValue0() - delta, pos.getValue1());
    }

    private int turnLeft(int delta, int currentHeading) {
        int heading = currentHeading - delta;

        return correctHeading(heading);
    }

    private int turnRight(int delta, int currentHeading) {
        int heading = currentHeading + delta;

        return correctHeading(heading);
    }

    private int correctHeading(int heading) {
        if (heading < 0) {
            return heading + 360;
        }

        if (heading >= 360) {
            return heading - 360;
        }

        return heading;
    }

    private Pair<Character, Integer> readInstruct(String instruct) {
        return Pair.with(instruct.charAt(0),
                Integer.parseInt(instruct.substring(1)));
    }


    @Override
    public void executePartB() {
        int result = partB(InputsDay12.INPUTS);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    int partB(String filename) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Day 12";
    }
}
