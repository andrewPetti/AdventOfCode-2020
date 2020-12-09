package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay08;
import com.chemies.AoC2020.data.InputsDay09;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {
    private Day09 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day09();
    }

    @Test
    public void partA() {
        assertEquals(127, _subject.partA(InputsDay09.SAMPLE, 5));
    }

    @Test
    public void partB_sampelB() {
        assertEquals(8
                , _subject.partB(InputsDay08.SAMPLE));
    }
}