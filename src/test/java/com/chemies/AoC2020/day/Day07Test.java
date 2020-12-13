package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {

    private Day07 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day07();
    }

    @Test
    public void partA() {
        assertEquals(4, _subject.partA(Inputs.DAY07_SAMPLE));
    }

    @Test
    public void partB_sampelB() {
        assertEquals(126, _subject.partB(Inputs.DAY07_SAMPLE_B));
    }

    @Test
    public void partB_sampleA() {
        assertEquals(32, _subject.partB(Inputs.DAY07_SAMPLE));
    }

}