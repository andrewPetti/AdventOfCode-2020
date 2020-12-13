package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {
    private Day04 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day04();
    }

    @Test
    public void partA_validPassports() {
        int expected = 2;

        assertEquals(expected, _subject.partA(Inputs.DAY04_SAMPLE));
    }

    @Test
    public void partB_BadSample() {
        int expected = 4;
        assertEquals(expected, _subject.partB(Inputs.DAY04_SAMPLE_B));
    }
}
