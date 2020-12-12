package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay12;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {
    private Day12 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day12();
    }

    @Test
    void executePartA() {
        assertEquals(25
                , _subject.partA(InputsDay12.SAMPLE));
    }

    @Test
    void executePartB() {
        assertEquals(7 * 5
                , _subject.partB(InputsDay12.SAMPLE));
    }
}