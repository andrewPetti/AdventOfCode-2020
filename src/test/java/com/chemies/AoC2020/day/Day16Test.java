package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day16Test {

    private Day16 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day16();
    }

    @Test
    void partA() {
        assertEquals(71
                , _subject.partA(Inputs.DAY16_SAMPLE));
    }
}