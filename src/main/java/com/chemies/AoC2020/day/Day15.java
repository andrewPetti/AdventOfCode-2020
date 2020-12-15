package com.chemies.AoC2020.day;

import java.util.*;

public class Day15 extends AbstractDay {
    @Override
    public void executePartA() {
        long result = partA("17,1,3,16,19,0");
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String startingNumbers) {
        return findNumberAtIthIteration(startingNumbers, 2020);
    }

    private int findNumberAtIthIteration(String startingNumbers, int stopAt) {
        String[] numbers = startingNumbers.split(",");

        int lastNumber = Integer.parseInt(numbers[numbers.length - 1]);

        ArrayList<Integer> spoken = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> spokenMap = new HashMap<>();//initializeMap(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int key = Integer.parseInt(numbers[i]);
            int pos = i + 1;

            ArrayList<Integer> list = new ArrayList<>();
            list.add(pos);
            spokenMap.put(key, list);
            spoken.add(key);
        }
        int pos = spokenMap.size() + 1;
        boolean lastWasNew = true;
        while (pos <= stopAt) {
            if (lastWasNew) {
                lastNumber = 0;
            } else {
                ArrayList<Integer> ids = spokenMap.get(lastNumber);
                lastNumber = ids.get(ids.size() - 1) - ids.get(ids.size() - 2);
            }
            lastWasNew = !spokenMap.containsKey(lastNumber);

            if (spokenMap.containsKey(lastNumber)) {
                spokenMap.get(lastNumber).add(pos);
            } else {
                spokenMap.put(lastNumber, new ArrayList<>(Collections.singletonList(pos)));
            }
            //addToMap(spokenMap, lastNumber, pos);
            spoken.add(lastNumber);
            pos++;
        }
        System.out.println(Arrays.toString(spoken.toArray()));
        return lastNumber;
    }

    private Map<Integer, ArrayList<Integer>> initializeMap(String[] numbers) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int key = Integer.parseInt(numbers[i]);
            int pos = i + 1;
            if (map.containsKey(key)) {
                map.get(key).add(pos);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pos);
                map.put(key, list);
            }
        }
        return Map.copyOf(map);
    }

    private void addToMap(Map<Integer, ArrayList<Integer>> spokenMap, int key, int pos) {
        if (spokenMap.containsKey(key)) {
            spokenMap.get(key).add(pos);
        } else {
            spokenMap.put(key, new ArrayList<>(Collections.singletonList(pos)));
        }
    }

    @Override
    public void executePartB() {
        long result = partB("17,1,3,16,19,0", 30000000);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    int partB(String numbers, int stopAt) {
        return findNumberAtIthIteration(numbers, stopAt);
    }

    @Override
    protected String getName() {
        return "Day 15";
    }
}
