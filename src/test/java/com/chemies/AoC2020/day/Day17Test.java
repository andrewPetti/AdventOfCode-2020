package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day17Test {
    private Day17 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day17();
    }

    @Test
    void partA() {
        assertEquals(71
                , _subject.partA(Inputs.DAY17_SAMPLE));
    }

    @Test
    void partB() {
        assertEquals(71
                , _subject.partA(Inputs.DAY17_SAMPLE));
    }
}