package com.chemies.AoC2020.day;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day18Test {

    private Day18 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day18();
        _subject.solveA();
    }

    @Test
    void partA() {
        assertEquals(71
                , _subject.processLine("1 + 2 * 3 + 4 * 5 + 6"));
    }

    @Test
    void partA_b() {
        assertEquals(51
                , _subject.processLine("1 + (2 * 3) + (4 * (5 + 6))"));
    }

    @Test
    void partA_c() {
        assertEquals(26
                , _subject.processLine("2 * 3 + (4 * 5)"));
    }

    @Test
    void partA_d() {
        assertEquals(437
                , _subject.processLine("5 + (8 * 3 + 9 + 3 * 4 * 3)"));
    }

    @Test
    void partA_e() {
        assertEquals(12240
                , _subject.processLine("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"));
    }

    @Test
    void partA_f() {
        assertEquals(13632
                , _subject.processLine("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"));
    }


    @Test
    void partB() {
        _subject.solveB();
        assertEquals(231
                , _subject.processLine("1 + 2 * 3 + 4 * 5 + 6"));
    }

    @Test
    void partB_b() {
        _subject.solveB();

        assertEquals(51
                , _subject.processLine("1 + (2 * 3) + (4 * (5 + 6))"));
    }

    @Test
    void partB_c() {
        _subject.solveB();
        assertEquals(46
                , _subject.processLine("2 * 3 + (4 * 5)"));
    }

    @Test
    void partB_d() {
        _subject.solveB();
        assertEquals(1445
                , _subject.processLine("5 + (8 * 3 + 9 + 3 * 4 * 3)"));
    }

    @Test
    void partB_e() {
        _subject.solveB();
        assertEquals(669060
                , _subject.processLine("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))"));
    }

    @Test
    void partB_f() {
        _subject.solveB();
        assertEquals(23340
                , _subject.processLine("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"));
    }
}