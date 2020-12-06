package com.chemies.AoC2020.util;


import com.google.common.collect.ImmutableList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class FileHelper {

    public ImmutableList<String> fileToStringList(String filename) {
        ArrayList<String> list = new ArrayList<>();

        try{ BufferedReader reader = getReader(filename);
           String line = reader.readLine().trim();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImmutableList.copyOf(list);
    }


    public ImmutableList<Integer> fileToIntegerList(String filename){
        ArrayList<Integer> list = new ArrayList<>();
        try{ BufferedReader reader = getReader(filename);
            String line = reader.readLine().trim();
            while (line != null) {
                list.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ImmutableList.copyOf(list);
    }

    private BufferedReader getReader(String filename) throws FileNotFoundException {
        BufferedReader reader = null;
        try {
            reader =
                    new BufferedReader(new FileReader("D:\\Git\\AdventOfCode-2020\\src\\main\\java\\com\\chemies\\AoC2020\\data\\inputs\\" + filename));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException(e.getMessage());
        }

        return reader;
    }
}

