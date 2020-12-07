package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay07;
import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Day07 extends AbstractDay {
    public static final String SHINY_GOLD = "shiny gold";
    private final String _filename = InputsDay07.INPUTS;
    private final String EMPTY_BAG = "no other bags.";
    private ImmutableList<String> _rules;

    @Override
    public void executePartA() {
        int result = partA(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    protected int partA(String filename) {
        _rules = _fileHelper.fileToStringList(filename);
        Map<String, Map<String, Integer>> contentMap = getContentsMap(_rules);

        return findCountContainingBag(contentMap, SHINY_GOLD);
    }

    private Map<String, Map<String, Integer>> getContentsMap(ImmutableList<String> rules) {
        Map<String, Map<String, Integer>> contentMap = new HashMap<>();
        rules.forEach(rule -> {
            String[] parts = rule.split("contain");
            String[] contents = parts[1].split(",");
            Map<String, Integer> subParts = new HashMap<>();
            if (!contents[0].trim().equalsIgnoreCase(EMPTY_BAG)) {
                for (String content : contents) {
                    String[] bagInfo = content.trim().split(" ");
                    int count = Integer.parseInt(bagInfo[0]);
                    String bag = bagInfo[1] + " " + bagInfo[2];
                    subParts.put(bag, count);
                }
            }
            contentMap.put(parts[0].trim().substring(0, parts[0].trim().length() - 5), subParts);
        });
        return contentMap;
    }

    private int findCountContainingBag(Map<String, Map<String, Integer>> contentsMap, String bag) {
        int sum;
        ArrayList<String> parentBags = getParentBags(contentsMap, bag);
        Set<String> total = new HashSet<>(parentBags);
        ArrayList<String> all = getParentBagsForList(contentsMap, parentBags);

        total.addAll(all);

        return total.size();
    }

    private ArrayList<String> getParentBagsForList(Map<String, Map<String, Integer>> contentsMap, ArrayList<String> bags) {

        ArrayList<String> totalParents = new ArrayList<>();
        int pos = 0;
        while (pos < bags.size()) {
            ArrayList<String> parents = getParentBags(contentsMap, bags.get(pos));
            totalParents.addAll(parents);
            totalParents.addAll(getParentBagsForList(contentsMap, parents));
            pos++;
        }

        return totalParents;
    }

    private ArrayList<String> getParentBags(Map<String, Map<String, Integer>> contentsMap, String bag) {
        ArrayList<String> bags = new ArrayList<>();

        for (Map.Entry<String, Map<String, Integer>> m : contentsMap.entrySet()) {
            Map<String, Integer> subBagMap = m.getValue();
            String parentBag = m.getKey();
            if (subBagMap.containsKey(bag)) {
                bags.add(parentBag);
            }
        }
        return bags;
    }

    @Override
    public void executePartB() {
        int result = partB(_filename);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    protected int partB(String filename) {
        _rules = _fileHelper.fileToStringList(filename);
        Map<String, Map<String, Integer>> contentMap = getContentsMap(_rules);

        return getNumberOfSubBags(contentMap, SHINY_GOLD) - 1;//don't want shiny_gold just contents
    }

    private int getNumberOfSubBags(Map<String, Map<String, Integer>> contentMap, String bag) {
        Map<String, Integer> subBagMap = contentMap.get(bag);
        AtomicInteger sum = new AtomicInteger();
        subBagMap.forEach((k, v) -> {
            int subCount = getNumberOfSubBags(contentMap, k);
            if (subCount > 0) {
                sum.addAndGet((v * subCount));

            }
        });
        //sum.getAndAdd(1);
        return sum.addAndGet(1);
    }

    @Override
    protected String getName() {
        return "Day 07";
    }
}
