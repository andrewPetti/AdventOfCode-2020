package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay07;
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
    public void partA_sumOfAllYES() {
        assertEquals(-1, _subject.partA(InputsDay07.SAMPLE));
    }

    @Test
    public void partB() {
        assertEquals(-1, _subject.partB(InputsDay07.SAMPLE));
    }

}