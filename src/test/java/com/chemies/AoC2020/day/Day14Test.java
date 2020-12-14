package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {
    private Day14 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day14();
    }

    @Test
    void executePartA() {
        assertEquals(295
                , _subject.partA(Inputs.DAY14_SAMPLE));
    }

    @Test
    void executePartB() {
        assertEquals(295
                , _subject.partB(Inputs.DAY14_SAMPLE));
    }
}