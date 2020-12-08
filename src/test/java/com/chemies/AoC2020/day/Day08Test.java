package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay08;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {

    private Day08 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day08();
    }

    @Test
    public void partA() {
        assertEquals(5, _subject.partA(InputsDay08.SAMPLE));
    }

    @Test
    public void partB_sampelB() {
        assertEquals(8
                , _subject.partB(InputsDay08.SAMPLE));
    }

}