package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day15Test {
    private Day15 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day15();
    }

    @Test
    void partA() {
        assertEquals(-1
                , _subject.partA(Inputs.DAY15_SAMPLE));
    }

    @Test
    void partB() {
        assertEquals(-1
                , _subject.partB(Inputs.DAY15_SAMPLE));
    }
}