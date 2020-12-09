package com.chemies.AoC2020;

import com.chemies.AoC2020.day.*;

import java.util.Scanner;

public class AdventOfCode2020Processor {
    private static final Scanner _scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Andrew's Advent of Code 2020 Solutions\n");

        boolean stop = false;
        AbstractDay day = null;
        int choice;
        while (!stop) {
            try {
                System.out.println("Please enter Day to execute or 99 to exit: ");
                choice = _scanner.nextInt();
                stop = true;

                switch (choice) {
                    case 99:
                        System.out.println("Advent of Code 2020 is exting.");
                        break;
                    case 1:
                        day = new Day01();
                        break;
                    case 2:
                        day = new Day02();
                        break;
                    case 3:
                        day = new Day03();
                        break;
                    case 4:
                        day = new Day04();
                        break;
                    case 5:
                        day = new Day05();
                        break;
                    case 6:
                        day = new Day06();
                        break;
                    case 7:
                        day = new Day07();
                        break;
                    case 8:
                        day = new Day08();
                        break;
                    case 9:
                        day = new Day09();
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    default:
                        System.out.printf("Day %d is currently not implemented. Please choose again.%n", choice);
                        stop = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input was entered. Please try again.");
                stop = false;
            }
        }
        if (day != null) {
            System.out.printf("%s selected%n", day.getFormattedName());
            day.executeDay();
        }
    }
}


//}
