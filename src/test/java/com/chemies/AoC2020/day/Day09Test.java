package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay09;
import com.google.common.collect.ImmutableList;
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
        assertEquals(62
                , _subject.partB(InputsDay09.SAMPLE, 5));
    }

    @Test
    public void sumSmallestAndLargest_returnsCorrectValue() {
        ImmutableList<Long> list = ImmutableList.of(1L,
                2L,
                3L,
                1L);
        assertEquals(4, _subject.sumOfSmallestAndLargest(list));
    }
}