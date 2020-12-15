package com.chemies.AoC2020.day;

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
        assertEquals(436
                , _subject.partA("0,3,6"));
    }

    @Test
    void partA_a() {
        assertEquals(1
                , _subject.partA("1,3,2"));
    }

    @Test
    void partA_b() {
        assertEquals(10
                , _subject.partA("2,1,3"));
    }

    @Test
    void partA_c() {
        assertEquals(27
                , _subject.partA("1,2,3"));
    }

    @Test
    void partA_d() {
        assertEquals(78
                , _subject.partA("2,3,1"));
    }

    @Test
    void partA_e() {
        assertEquals(438
                , _subject.partA("3,2,1"));
    }

    @Test
    void partA_f() {
        assertEquals(1836
                , _subject.partA("3,1,2"));
    }

    @Test
    void partB() {
        assertEquals(-1
                , _subject.partB("1,1,1", 1));
    }

    @Test
    void partB_a() {
        assertEquals(175594,
                _subject.partB("0,3,6", 30000000));
    }
}