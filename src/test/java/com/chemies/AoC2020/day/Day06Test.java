package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {

    private Day06 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day06();
    }

    @Test
    public void partA_sumOfAllYES() {
        assertEquals(11, _subject.partA(Inputs.DAY06_SAMPLE));
    }

    @Test
    public void partB_sumWherePArtyAllYES() {
        assertEquals(6L, _subject.partB(Inputs.DAY06_SAMPLE));
    }
}