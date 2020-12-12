package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay12;
import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {
    private Day12 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day12();
    }

    @Test
    void executePartA() {
        assertEquals(25L
                , _subject.partA(InputsDay12.SAMPLE));
    }

    @Test
    void executePartB() {
        assertEquals(286L
                , _subject.partB(InputsDay12.SAMPLE));
    }

    @Test
    void turnRight90() {
        Pair<Integer, Integer> actual = _subject.turnRight(90, Pair.with(10, 4));
        assertEquals(-10, actual.getValue1());
        assertEquals(4, actual.getValue0());
    }

    @Test
    void turnRight180() {
        Pair<Integer, Integer> actual = _subject.turnRight(180, Pair.with(10, 4));
        assertEquals(-10, actual.getValue1());
        assertEquals(4, actual.getValue0());
    }
}