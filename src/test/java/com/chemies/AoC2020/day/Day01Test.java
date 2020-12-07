package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    private Day01 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day01();
    }

    @Test
    void partA_expectCorrectProduct() {
        Integer expected = 514579;
        assertEquals(expected, _subject.partA(InputDay01.sample));
    }

    @Test
    void partB_expectCorrectProduct() {
        Integer expected = 241861950;
        assertEquals(expected, _subject.partB(InputDay01.sample));
    }

}