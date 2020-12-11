package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay10;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

import java.util.ArrayList;

public class Day10 extends AbstractDay {
    @Override
    public void executePartA() {
        int result = partA(InputsDay10.INPUTS);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String filename) {
        ImmutableList<Integer> rawAdapters = _fileHelper.fileToIntegerList(filename);
        // int[] toSort = rawAdapters.stream().toArray();
        //Collections.sort(toSort, Ordering.natural().nullsLast());

        ArrayList<Integer> list = new ArrayList<>(rawAdapters);
        list.sort(Ordering.natural().nullsLast());

        //ImmutableList<Integer> sortedAdapters = rawAdapters.sortedCopyOf((l, r) -> Longs.compare(l, r));
        int delta1 = 0;
        int delta3 = 0;
        int current = 0;

        for (Integer adapter : list) {
            if (adapter - current == 1) {
                delta1++;
            }
            if (adapter - current == 3) {
                delta3++;
            }
            current = adapter;
        }
        delta3++;

        return delta1 * delta3;
    }

    @Override
    public void executePartB() {
        int result = partB(InputsDay10.INPUTS);

        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    int
    partB(String filename) {
        ImmutableList<Integer> rawAdapters = _fileHelper.fileToIntegerList(filename);
        // int[] toSort = rawAdapters.stream().toArray();
        //Collections.sort(toSort, Ordering.natural().nullsLast());

        ArrayList<Integer> list = new ArrayList<>(rawAdapters);
        list.sort(Ordering.natural().nullsLast());

        ImmutableList<ArrayList<Integer>> adjacentLists = builldAdjacentLists(list);
        int count = 1;


        //for (int i = 0; i < list.size(); i++) {

        int pos;
        int val;// list.get(pos);
        int found;

        for (int i = 0; i < list.size() - 1; ) {
            pos = i;
            val = list.get(i);
            found = 0;
            int lastfoundPos = 0;
            while (pos <= i + 3 && pos < list.size() - 1) {
                pos++;
                int next = list.get(pos);
                if (next - val <= 3) {
                    found++;
                    lastfoundPos = pos;
                }
            }
            if (found == 3) {
                found++;
                i = lastfoundPos;
            } else {
                i++;
            }
            count *= found;
        }
        return count;
    }

    private ImmutableList<ArrayList<Integer>> builldAdjacentLists(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> adj = new ArrayList<>();
            int current = list.get(i);
            for (int j = i + 1; j <= i + 3 && j < list.size(); j++) {
                int val = list.get(i + 1);
                if (val < i + 3) {
                    adj.add(j);
                }
            }
            adjacent.add(adj);
        }
        return ImmutableList.copyOf(adjacent);
    }

    @Override
    protected String getName() {
        return "Day 10";
    }
}
