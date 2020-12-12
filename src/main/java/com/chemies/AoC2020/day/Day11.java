package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay11;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

public class Day11 extends AbstractDay {

    @Override
    public void executePartA() {
        int result = partA(InputsDay11.INPUTS);
        System.out.println("PartA Ans: " + formatAnswer(result));
    }

    int partA(String filename) {
        ImmutableList<String> seating = _fileHelper.fileToStringList(filename);
        boolean cont = true;
        while (cont) {
            ImmutableList<String> nextRevsion = getNextRevsionPartA(seating);
            if (compare(seating, nextRevsion)) {
                cont = false;
            } else {
                seating = ImmutableList.copyOf(nextRevsion);
            }
        }

        seating.forEach(System.out::println);
        return countOccupied(seating);
    }

    private int countOccupied(ImmutableList<String> seating) {
        var sum = new Object() {
            int val = 0;
        };

        seating.forEach(str -> sum.val += CharMatcher.is('#').countIn(str));
        return sum.val;
    }

    private boolean compare(ImmutableList<String> seating, ImmutableList<String> nextRevsion) {
        for (int i = 0; i < seating.size(); i++) {
            if (!seating.get(i).equals(nextRevsion.get(i))) {
                return false;
            }
        }
        return true;
    }

    private ImmutableList<String> getNextRevsionPartA(ImmutableList<String> current) {
        ArrayList<String> next = new ArrayList<>();
        int size = current.size();
        for (int row = 0; row < size; row++) {

            char[] seats = current.get(row).toCharArray();
            String newSeats = String.valueOf(seats);
            for (int col = 0; col < seats.length; col++) {
                if (seats[col] != '.') {
                    int ajacentOccupied = getAdjacentOccupied(current, row, col);
                    StringBuilder stringBuilder = new StringBuilder(newSeats);
                    if (seats[col] == 'L' && ajacentOccupied == 0) {
                        stringBuilder.setCharAt(col, '#');
                    } else if (seats[col] == '#' && ajacentOccupied >= 4) {
                        stringBuilder.setCharAt(col, 'L');
                    }
                    newSeats = stringBuilder.toString();

                }

            }

            next.add(newSeats);
        }
        return ImmutableList.copyOf(next);
    }

    private ImmutableList<String> getNextRevsionPartB(ImmutableList<String> current) {
        ArrayList<String> next = new ArrayList<>();
        int size = current.size();
        for (int row = 0; row < size; row++) {

            char[] seats = current.get(row).toCharArray();
            String newSeats = String.valueOf(seats);
            for (int col = 0; col < seats.length; col++) {
                if (seats[col] != '.') {
                    int ajacentOccupied = getAdjacentOccupiedB(current, row, col);
                    StringBuilder stringBuilder = new StringBuilder(newSeats);
                    if (seats[col] == 'L' && ajacentOccupied == 0) {
                        stringBuilder.setCharAt(col, '#');
                    } else if (seats[col] == '#' && ajacentOccupied >= 5) {
                        stringBuilder.setCharAt(col, 'L');
                    }
                    newSeats = stringBuilder.toString();

                }

            }

            next.add(newSeats);
        }
        return ImmutableList.copyOf(next);
    }

    private int getAdjacentOccupied(ImmutableList<String> current, int row, int col) {
        int sum = 0;
        sum += getDiagonal(current, row, col);
        sum += getUpDown(current, row, col);
        sum += getLeftRight(current, row, col);
        return sum;
    }

    private boolean isSeatOccupied(char seat) {
        return seat != 'L' && seat != '.';
    }

    private int getLeftRight(ImmutableList<String> current, int row, int col) {
        int sum = 0;
        char[] line = current.get(row).toCharArray();
        if ((col != 0) && isSeatOccupied(line[col - 1])) {
            sum++;
        }

        if (line.length - 1 != col && isSeatOccupied(line[col + 1])) {
            sum++;
        }
        return sum;
    }

    private int getUpDown(ImmutableList<String> current, int row, int col) {
        int sum = 0;
        if (row != 0) {
            char[] line = current.get(row - 1).toCharArray();
            if (isSeatOccupied(line[col])) {
                sum++;
            }
        }

        if (row != current.size() - 1) {
            char[] line = current.get(row + 1).toCharArray();
            if (isSeatOccupied(line[col])) {
                sum++;
            }
        }
        return sum;
    }

    private int getDiagonal(ImmutableList<String> current, int row, int col) {
        int sum = 0;
        try {
            if (row != 0) {
                char[] line = current.get(row - 1).toCharArray();
                if (col != 0 && isSeatOccupied(line[col - 1])) {
                    sum++;
                }
                if (col != line.length - 1 && isSeatOccupied(line[col + 1])) {
                    sum++;
                }
            }
            if (row != current.size() - 1) {
                char[] line = current.get(row + 1).toCharArray();
                if (col != 0 && isSeatOccupied(line[col - 1])) {
                    sum++;
                }
                if (col != line.length - 1 && isSeatOccupied(line[col + 1])) {
                    sum++;
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return sum;
    }

    @Override
    public void executePartB() {
        int result = partB(InputsDay11.INPUTS);
        System.out.println("PartB Ans: " + formatAnswer(result));
    }

    int partB(String filename) {
        ImmutableList<String> seating = _fileHelper.fileToStringList(filename);
        seating.forEach(System.out::println);
        boolean cont = true;
        while (cont) {
            ImmutableList<String> nextRevsion = getNextRevsionPartB(seating);
            if (compare(seating, nextRevsion)) {
                cont = false;
            } else {
                seating = ImmutableList.copyOf(nextRevsion);
                seating.forEach(System.out::println);
                System.out.println();
            }
        }

        return countOccupied(seating);
    }

    int getAdjacentOccupiedB(ImmutableList<String> current, int row, int col) {
        int sum = 0;
        sum += getUpperLeftDiagonal(current, row, col);
        sum += getUpperRightDiagonal(current, row, col);
        sum += getUp(current, row, col);
        sum += getDown(current, row, col);
        sum += getLeft(current, row, col);
        sum += getRight(current, row, col);
        sum += getLowerLeftDiagonal(current, row, col);
        sum += getLowerRightDiagonal(current, row, col);
        return sum;
    }

    private int getLeft(ImmutableList<String> current, int row, int col) {

        int colPos = col - 1;
        char[] line = current.get(row).toCharArray();

        while (colPos >= 0) {
            if (isSeat(line[colPos])) {
                if (isSeatOccupied(line[colPos])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            colPos--;
        }
        return 0;
    }

    private int getRight(ImmutableList<String> current, int row, int col) {

        int colPos = col + 1;
        char[] line = current.get(row).toCharArray();

        while (colPos < line.length) {
            if (isSeat(line[colPos])) {
                if (isSeatOccupied(line[colPos])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            colPos++;
        }
        return 0;
    }

    private boolean isSeat(char seat) {
        return seat != '.';
    }

    private int getUp(ImmutableList<String> current, int row, int col) {

        int rowPos = row - 1;

        while (rowPos >= 0) {
            char[] line = current.get(rowPos).toCharArray();
            if (isSeat(line[col])) {
                if (isSeatOccupied(line[col])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            rowPos--;
        }
        return 0;
    }

    private int getDown(ImmutableList<String> current, int row, int col) {

        int rowPos = row + 1;
        int height = current.size();
        while (rowPos < height) {
            char[] line = current.get(rowPos).toCharArray();
            if (isSeat(line[col])) {
                if (isSeatOccupied(line[col])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            rowPos++;
        }
        return 0;
    }

    private int getUpperLeftDiagonal(ImmutableList<String> current, int row, int col) {

        int colPos = col - 1;
        int rowPos = row - 1;

        while (colPos >= 0 && rowPos >= 0) {
            char[] line = current.get(rowPos).toCharArray();
            if (isSeat(line[colPos])) {
                if (isSeatOccupied(line[colPos])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            rowPos--;
            colPos--;
        }
        return 0;
    }

    private int getLowerLeftDiagonal(ImmutableList<String> current, int row, int col) {

        int colPos = col - 1;
        int rowPos = row + 1;
        int height = current.size();
        while (colPos >= 0 && rowPos < height) {
            char[] line = current.get(rowPos).toCharArray();
            if (isSeat(line[colPos])) {
                if (isSeatOccupied(line[colPos])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            rowPos++;
            colPos--;
        }
        return 0;
    }

    private int getUpperRightDiagonal(ImmutableList<String> current, int row, int col) {

        int colPos = col + 1;
        int rowPos = row - 1;
        int width = current.get(0).length();
        while (colPos < width && rowPos >= 0) {
            char[] line = current.get(rowPos).toCharArray();
            if (isSeat(line[colPos])) {
                if (isSeatOccupied(line[colPos])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            rowPos--;
            colPos++;
        }
        return 0;
    }

    private int getLowerRightDiagonal(ImmutableList<String> current, int row, int col) {

        int colPos = col + 1;
        int rowPos = row + 1;
        int width = current.get(0).length();
        int height = current.size();
        while (colPos < width && rowPos < height) {
            char[] line = current.get(rowPos).toCharArray();
            if (isSeat(line[colPos])) {
                if (isSeatOccupied(line[colPos])) {
                    return 1;
                } else {
                    return 0;
                }
            }
            rowPos++;
            colPos++;
        }
        return 0;
    }

    @Override
    protected String getName() {
        return "Day 11";
    }
}
