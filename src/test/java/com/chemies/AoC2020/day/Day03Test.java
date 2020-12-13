package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class

Day03Test {

    private Day03 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day03();
    }

    @Test
    public void partA_expectSuccess() {
        int expected = 7;

        assertEquals(expected, _subject.partA(Inputs.DAY03_SAMPLE, 3, 1));
    }

    @Test
    public void partAa() {
        int expected = 2;
        assertEquals(expected, _subject.partA(Inputs.DAY03_SAMPLE, 1, 1));
    }

    @Test
    public void partAb() {
        int expected = 3;
        assertEquals(expected, _subject.partA(Inputs.DAY03_SAMPLE, 5, 1));
    }

    @Test
    public void partAc() {
        int expected = 4;
        assertEquals(expected, _subject.partA(Inputs.DAY03_SAMPLE, 7, 1));
    }

    @Test
    public void partAd() {
        int expected = 2;
        assertEquals(expected, _subject.partA(Inputs.DAY03_SAMPLE, 1, 2));
    }

    @Test
    void partB_expectCorrectProduct() {
        int expected = 336;

        assertEquals(expected, _subject.partB(Inputs.DAY03_SAMPLE));
    }
}
