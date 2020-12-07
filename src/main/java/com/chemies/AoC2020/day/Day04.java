package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day04 extends AbstractDay {

    @Override
    public void executePartA() {
        String filename = InputDay04.inputs;
        int result = partA(filename);
        System.out.println(String.format("PartA Ans: " + formatAnswer(result)));
    }

    public int partA(String filename) {
        ImmutableList<Map<String, String>> list = buildList(filename);
        var valid =
                new Object() {
                    int value;
                };
        valid.value = 0;
        list.forEach(
                map -> {
                    if (map.size() == 8 || (map.size() == 7 && !map.containsKey("cid"))) {
                        if (validMap(map)) {
                            valid.value++;
                        }
                    }
                });
        return valid.value;
    }

    public boolean validMap(Map<String, String> map) {
        for (Map.Entry<String, String> m : map.entrySet()) {
            String val = m.getValue().toString();
            String key = m.getKey().toString();
            if (key.equals("byr")) {
                if (val.length() < 4) {
                    return false;
                }

                try {
                    int i = Integer.parseInt(val);
                    if (i < 1920 || i > 2002) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

            if (key.equals("iyr")) {
                if (val.length() < 4) {
                    return false;
                }

                try {
                    int i = Integer.parseInt(val);
                    if (i < 2010 || i > 2020) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

            if (key.equals("eyr")) {
                if (val.length() < 4) {
                    return false;
                }

                try {
                    int i = Integer.parseInt(val);
                    if (i < 2020 || i > 2030) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

            if (key.equals("hgt")) {
                String num = val.substring(0, val.length() - 2);
                String unit = val.substring(val.length() - 2);

                try {
                    int i = Integer.parseInt(num);
                    if (unit.equals("cm")) {
                        if (i < 150 || i > 193) {
                            return false;
                        }
                    } else if (unit.equals("in")) {
                        if (i < 59 || i > 76) {
                            return false;
                        }
                    } else {
                        return false;
                    }

                } catch (Exception e) {
                    return false;
                }
            }

            if (key.equals("hcl")) {
                if (val.length() != 7) {
                    return false;
                }
                for (int j = 0; j < val.length(); j++) {
                    char pos = val.charAt(j);
                    if (j == 0 && pos != '#') {
                        return false;
                    } else if (j > 0) {
                        if (pos != '0'
                                && pos != '1'
                                && pos != '2'
                                && pos != '3'
                                && pos != '4'
                                && pos != '5'
                                && pos != '6'
                                && pos != '7'
                                && pos != '8'
                                && pos != '9'
                                && pos != 'a'
                                && pos != 'b'
                                && pos != 'c'
                                && pos != 'd'
                                && pos != 'e'
                                && pos != 'f') {
                            return false;
                        }
                    }
                }
            }

            ImmutableSet<String> eyeColor =
                    ImmutableSet.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
            if (key.equals("ecl")) {

                if (!eyeColor.contains(val)) {
                    return false;
                }
            }

            if (key.equals("pid")) {
                if (val.length() != 9) {
                    return false;
                } else {
                    for (int j = 0; j < val.length(); j++) {
                        char pos = val.charAt(j);
                        if (pos != '0'
                                && pos != '1'
                                && pos != '2'
                                && pos != '3'
                                && pos != '4'
                                && pos != '5'
                                && pos != '6'
                                && pos != '7'
                                && pos != '8'
                                && pos != '9') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void executePartB() {
        String filename = InputDay04.inputs;
        int result = partB(filename);
        System.out.println(String.format("PartB Ans: " + formatAnswer(result)));
    }

    public int partB(String filename) {
        ImmutableList<Map<String, String>> list = buildList(filename);
        var valid =
                new Object() {
                    int value;
                };
        valid.value = 0;
        list.forEach(
                map -> {
                    if (map.size() == 8 || (map.size() == 7 && !map.containsKey("cid"))) {
                        if (validMap(map)) {
                            valid.value++;
                        }
                    }
                });
        return valid.value;
    }

    @Override
    protected String getName() {
        return "Day 04";
    }

    public ImmutableList<Map<String, String>> buildList(String filename) {

        BufferedReader reader;
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        try {
            reader =
                    new BufferedReader(new FileReader("d:\\Git\\AdventOfCode2020\\src\\inputs\\" + filename));
            String rawLine = reader.readLine();
            String combined = "";
            boolean eof = false;
            while (eof == false) {
                if (rawLine == null || rawLine.isEmpty()) {
                    String[] parts = combined.trim().split(" ");
                    Map<String, String> map = new HashMap<String, String>();
                    for (int i = 0; i < parts.length; i++) {
                        String[] field = parts[i].split(":");
                        map.put(field[0], field[1]);
                    }
                    combined = "";
                    list.add(map);
                } else {
                    combined += " " + rawLine;
                }

                if (rawLine != null) {
                    rawLine = reader.readLine();
                } else {
                    eof = true;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImmutableList.copyOf(list);
    }
}
