package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay10;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class day11Test {
    private Day11 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day11();
    }

    @Test
    void executePartA() {
        assertEquals(1
                , _subject.partA(InputsDay10.SAMPLE));
    }

    @Test
    void executePartB() {
        assertEquals(1
                , _subject.partB(InputsDay10.SAMPLE));
    }

    static class Day10Test {
        private Day10 _subject;

        @BeforeEach
        void setup() {
            _subject = new Day10();
        }

        @Test
        void executePartA() {
            assertEquals(7 * 5
                    , _subject.partA(InputsDay10.SAMPLE));
        }

        @Test
        void executePartA_sampleB() {
            assertEquals(22 * 10
                    , _subject.partA(InputsDay10.SAMPLEB));
        }

        @Test
        void executePartB() {
            assertEquals(8
                    , _subject.partB(InputsDay10.SAMPLE));
        }

        @Test
        void executePartB_sampleB() {
            assertEquals(19208
                    , _subject.partB(InputsDay10.SAMPLEB));
        }
    }
}