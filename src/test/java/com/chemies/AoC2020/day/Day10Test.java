package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay09;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    private Day10 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day10();
    }

    @Test
    void executePartA() {
        assertEquals(62
                , _subject.partA(InputsDay09.SAMPLE));
    }

    @Test
    void executePartB() {
        assertEquals(62
                , _subject.partB(InputsDay09.SAMPLE));
    }
}