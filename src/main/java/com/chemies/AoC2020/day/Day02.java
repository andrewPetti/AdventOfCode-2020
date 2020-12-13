package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.base.CharMatcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day02 extends AbstractDay {

    @Override
    public void executePartA() {
        String filename = Inputs.DAY02_INPUT;
        int valid = partA(filename);
        System.out.println("Count of valid passwords is: " + formatAnswer(valid));
    }

    public int partA(String filename) {
        BufferedReader reader;
        int valid = 0;
        try {
            reader =
                    new BufferedReader(new FileReader("d:\\Git\\AdventOfCode2020\\src\\inputs\\" + filename));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" ");

                String[] counts = parts[0].split("-");
                int lower = Integer.parseInt(counts[0]);
                int upper = Integer.parseInt(counts[1]);

                int count = CharMatcher.is(parts[1].charAt(0)).countIn(parts[2]);
                if (count >= lower && count <= upper) {
                    valid++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public void executePartB() {
        String filename = Inputs.DAY02_INPUT;
        int valid = partB(filename);
        System.out.println("Count of valid passwords for part B is: " + formatAnswer(valid));
    }

    public int partB(String filename) {
        BufferedReader reader;
        int valid = 0;
        try {
            reader =
                    new BufferedReader(new FileReader("d:\\Git\\AdventOfCode2020\\src\\inputs\\" + filename));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" ");

                String[] counts = parts[0].split("-");
                int lower = Integer.parseInt(counts[0]) - 1;
                int upper = Integer.parseInt(counts[1]) - 1;

                char match = parts[1].charAt(0);
                if (parts[2].charAt(lower) != parts[2].charAt(upper)
                        && (parts[2].charAt(lower) == match || parts[2].charAt(upper) == match)) {
                    valid++;
                }

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    protected String getName() {
        return "Day-02";
    }
}
