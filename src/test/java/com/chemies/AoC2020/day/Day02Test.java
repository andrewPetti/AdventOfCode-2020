package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    private Day02 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day02();
    }

    @Test
    void partA_expectCorrectProduct() {
        int expected = 2;

        assertEquals(expected, _subject.partA(Inputs.DAY02_SAMPLE));
    }

    @Test
    void partB_expectCorrectProduct() {
        int expected = 1;

        assertEquals(expected, _subject.partB(Inputs.DAY02_SAMPLE));
    }
}
