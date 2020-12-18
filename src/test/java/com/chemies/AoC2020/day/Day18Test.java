package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day18Test {

    private Day18 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day18();
    }

    @Test
    void partA() {
        assertEquals(112
                , _subject.partA(Inputs.DAY18_SAMPLE));
    }

    @Test
    void partB() {
        assertEquals(112
                , _subject.partA(Inputs.DAY18_SAMPLE));
    }
}