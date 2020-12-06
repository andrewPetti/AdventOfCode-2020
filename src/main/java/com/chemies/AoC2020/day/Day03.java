package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputDay03;
import com.google.common.collect.ImmutableList;
import org.javatuples.Pair;

public class Day03 extends AbstractDay {

  private final char TREE = '#';

  @Override
  public void executePartA() {
    String filename = InputDay03.inputs;
    int valid = partA(filename, 3, 1);
    System.out.println(String.format("Count of valid passwords is: " + formatAnswer(valid)));
  }

  public int partA(String filename, int right, int down) {
    ImmutableList<String> map = _fileHelper.fileToStringList(filename);
    int treeCount = 0;
    int curRow = 0;
    int totalRows = map.size();
    int curPos = 0;
    int repeatLength = map.get(0).trim().length();

    while (curRow < totalRows - 1) {
      curRow += down;
      curPos += right;
      if (curPos >= repeatLength) {
        curPos = curPos - repeatLength;
      }
      String line = map.get(curRow).trim();
      if (line.charAt(curPos) == TREE) {
        treeCount++;
      }
    }

    return treeCount;
  }

  @Override
  public void executePartB() {
    String filename = InputDay03.inputs;
    int product = partB(filename);
    System.out.println(
        String.format("Product of the number of trees encountered is: " + formatAnswer(product)));
  }

  public int partB(String filename) {
    ImmutableList<Pair<Integer, Integer>> slopes =
        ImmutableList.of(
            Pair.with(1, 1), Pair.with(3, 1), Pair.with(5, 1), Pair.with(7, 1), Pair.with(1, 2));

    Pair<Integer, Integer> slope = slopes.get(0);
    int product = partA(filename, slope.getValue0(), slope.getValue1());
    for (int i = 1; i < slopes.size(); i++) {
      slope = slopes.get(i);
      product = product * partA(filename, slope.getValue0(), slope.getValue1());
    }
    return product;
  }

  @Override
  protected String getName() {
    return "Day 03";
  }
}
