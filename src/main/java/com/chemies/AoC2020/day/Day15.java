package com.chemies.AoC2020.day;

import java.util.HashMap;
import java.util.Map;

public class Day15 extends AbstractDay {
    @Override
    public void executePartA() {
        long result = partA("17,1,3,16,19,0");
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    Long partA(String startingNumbers) {
        return findNumberAtIthIteration(startingNumbers, 2020L);
    }

    private Long findNumberAtIthIteration(String startingNumbers, Long stopAt) {
        String[] numbers = startingNumbers.split(",");

        Long lastNumber = Long.parseLong(numbers[numbers.length - 1]);

//        Map<Long, Pair<Long, Long>> spokenMap = new HashMap<>();
        Map<Long, Long[]> spokenMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Long key = Long.parseLong(numbers[i]);
            Long pos = Long.valueOf(i + 1);
            Long[] pair = new Long[2];
            pair[0] = -1L;
            pair[1] = pos;
//            spokenMap.put(key, Pair.with(-1L, pos));
            spokenMap.put(key, pair);
        }
        Long pos = Long.valueOf(spokenMap.size() + 1);
        boolean lastWasNew = true;
        Long currentNumber = -1L;
        while (pos <= stopAt) {
            //Pair<Long, Long> lastNumberInfo = spokenMap.get(lastNumber);
            Long[] longs = spokenMap.get(lastNumber);
//            if (lastNumberInfo.getValue0() == -1L) {
            if (longs[0] == -1L) {
                currentNumber = 0L;
            } else {
                //currentNumber = lastNumberInfo.getValue1() - lastNumberInfo.getValue0();
                currentNumber = longs[1] - longs[0];
            }

            if (spokenMap.containsKey(currentNumber)) {
//                Pair<Long, Long> currentNumberInfo = spokenMap.get(currentNumber);
                //Long[] longs1 = spokenMap.get(currentNumber);
                //currentNumberInfo.setAt0(currentNumberInfo.getValue1());
                // currentNumberInfo.setAt1(pos);
                //spokenMap.replace(currentNumber, Pair.with(currentNumberInfo.getValue1(), pos));
                //longs[0] = longs[1];
                //longs[1] = pos;
                //spokenMap.get(currentNumber).setAt0(currentNumberInfo.getValue1());
                //spokenMap.get(currentNumber).setAt1(pos);
                spokenMap.get(currentNumber)[0] = spokenMap.get(currentNumber)[1];
                spokenMap.get(currentNumber)[1] = pos;
            } else {
                Long[] pair = new Long[2];
                pair[0] = -1L;
                pair[1] = pos;
                spokenMap.put(currentNumber, pair);
                //spokenMap.put(currentNumber, Pair.with(-1L, pos));
            }

            lastNumber = currentNumber;
            pos++;
        }
        return lastNumber;
    }

/*    private Map<Integer, ArrayList<Integer>> initializeMap(String[] numbers) {
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
    }*/
/*
    private void addToMap(Map<Integer, ArrayList<Integer>> spokenMap, int key, int pos) {
        if (spokenMap.containsKey(key)) {
            spokenMap.get(key).add(pos);
        } else {

        }
        spokenMap.put(key, new ArrayList<>(Collections.singletonList(pos)));
    }*/


    @Override
    public void executePartB() {
        long result = partB("17,1,3,16,19,0", 30000000L);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    long partB(String numbers, long stopAt) {
        return findNumberAtIthIteration(numbers, stopAt);
    }

    @Override
    protected String getName() {
        return "Day 15";
    }
}
