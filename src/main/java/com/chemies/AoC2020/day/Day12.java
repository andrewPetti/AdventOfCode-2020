package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay12;
import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

import static java.lang.Math.abs;

public class Day12 extends AbstractDay {
    @Override
    public void executePartA() {
        long result = partA(InputsDay12.INPUTS);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    long partA(String filename) {
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

    private long calcManhattanDist(Pair<Integer, Integer> pos) {
        long a = abs(pos.getValue0());
        long b = abs(pos.getValue1());

        return a + b;

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
        long result = partB(InputsDay12.INPUTS);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    long partB(String filename) {
        ImmutableList<String> list = _fileHelper.fileToStringList(filename);
        var currentHeading = new Object() {
            int val = 90;
            Pair<Integer, Integer> pos = new Pair<>(0, 0);
            Pair<Integer, Integer> way = Pair.with(10, 1);
        };

        list.forEach(line -> {
            Pair<Character, Integer> instruct = readInstruct(line);
            Integer delta = instruct.getValue1();
            switch (instruct.getValue0()) {
                case 'N':
                    currentHeading.way = moveNorth(delta, currentHeading.way);
                    break;
                case 'S':
                    currentHeading.way = moveSouth(delta, currentHeading.way);
                    break;
                case 'E':
                    currentHeading.way = moveEast(delta, currentHeading.way);
                    break;
                case 'W':
                    currentHeading.way = moveWest(delta, currentHeading.way);
                    break;
                case 'L':
                    currentHeading.way = turnLeft(delta, currentHeading.way);
                    break;
                case 'R':
                    currentHeading.way = turnRight(delta, currentHeading.way);
                    break;
                case 'F':
                    currentHeading.pos = moveForwardTowardsWay(delta, currentHeading.pos, currentHeading.way);
                    break;
            }
        });
        System.out.println(currentHeading.pos);
        return calcManhattanDist(currentHeading.pos);
    }


    private Pair<Integer, Integer> moveForwardTowardsWay(Integer delta, Pair<Integer, Integer> pos, Pair<Integer, Integer> way) {

        return Pair.with(pos.getValue0() + (delta * way.getValue0()), pos.getValue1() + (delta * way.getValue1()));
    }


    public Pair<Integer, Integer> turnLeft(int delta, Pair<Integer, Integer> pos) {

        return rotate(delta, pos);
    }

    public Pair<Integer, Integer> turnRight(int delta, Pair<Integer, Integer> pos) {
        return rotate(delta * -1, pos);
    }

    private Pair<Integer, Integer> rotate(int delta, Pair<Integer, Integer> pos) {
        int x = 0;
        int y = 0;
        int corrected = correctHeading(delta);
        if (corrected == 90) {
            x = pos.getValue1() * -1;
            y = pos.getValue0();
        }

        if (corrected == 180) {
            x = pos.getValue0() * -1;
            y = pos.getValue1() * -1;
        }

        if (corrected == 270) {
            x = pos.getValue1();
            y = pos.getValue0() * -1;
        }
        return Pair.with(x, y);
    }


    @Override
    protected String getName() {
        return "Day 12";
    }
}
