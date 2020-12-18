package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

public class Day17 extends AbstractDay {
    //private Object ArrayList;

    @Override
    public void executePartA() {
        ImmutableList<char[]> input = ImmutableList.of(new char[1]);
        int result = partA(input);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(ImmutableList<char[]> input) {

        ImmutableList<ImmutableList<char[]>> grid = ImmutableList.of(input);
        ImmutableList<ImmutableList<char[]>> newGrid = processGrid(grid);

        newGrid.forEach(layer -> {
            layer.forEach(row -> {
                System.out.println(row);
            });
            System.out.println();
        });
        return 0;
    }

    private ImmutableList<ImmutableList<char[]>> processGrid(ImmutableList<ImmutableList<char[]>> grid) {
        ArrayList<ImmutableList<char[]>> newGrid = new ArrayList<>();
        for (int z = 0; z < grid.size(); z++) {
            ArrayList<char[]> newLayer = new ArrayList<>();
            ImmutableList<char[]> layer = grid.get(z);
            for (int y = 0; y < layer.size(); y++) {
                char[] newRow = new char[layer.get(y).length];
                for (int x = 0; x < layer.get(y).length; x++) {
                    int count = getActiveNeighbors(grid, x, y, z);
                    boolean active = isActive(grid.get(z).get(y), x) == 1 ? true : false;
                    if (active) {
                        count--;
                        if (count == 2 || count == 3) {
                            newRow[x] = '#';
                        } else {
                            newRow[x] = '.';
                        }
                    } else {
                        if (count == 3) {
                            newRow[x] = '#';
                        } else {
                            newRow[x] = '.';
                        }
                    }
                }
                newLayer.add(newRow);
            }
            newGrid.add(ImmutableList.copyOf(newLayer));
        }
        return ImmutableList.copyOf(newGrid);
    }

    @Override
    public void executePartB() {
        int result = partB(Inputs.DAY17_INPUT);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partB(String filename) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Day 17";
    }


    private int getActiveNeighbors(ImmutableList<ImmutableList<char[]>> grid, int x, int y, int z) {

        int sum = 0;
        sum += countActiveInLayer(grid.get(z), x, y);
        if (z != 0) {
            sum += countActiveInLayer(grid.get(z - 1), x, y);
        }
        if (z != grid.size() - 1) {
            sum += countActiveInLayer(grid.get(z + 1), x, y);
        }
        return sum;
    }

    private int countActiveInLayer(ImmutableList<char[]> layer, int x, int y) {

        int sum = 0;
        for (int j = -1; j < 2; j++) {
            if (y + j < 0 || y + j > layer.size() - 1) continue;

            for (int i = -1; i < 2; i++) {
                if (x + i < 0 || x + i > layer.get(y).length - 1) continue;
                sum += isActive(layer.get(y + j), x + i);
            }
        }

        return sum;
    }

    private int isActive(char[] chars, int x) {
        if (chars[x] == '#') {
            return 1;
        }
        return 0;
    }
}
