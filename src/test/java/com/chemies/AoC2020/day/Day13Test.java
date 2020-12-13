package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {

    private Day13 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day13();
    }

    @Test
    void executePartA() {
        assertEquals(295
                , _subject.partA(Inputs.DAY13_SAMPLE));
    }


    @Test
    void executePartB() {
        assertEquals(25
                , _subject.partB(Inputs.DAY13_SAMPLE));
    }
}