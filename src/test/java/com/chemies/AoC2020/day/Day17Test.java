package com.chemies.AoC2020.day;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day17Test {
    private Day17 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day17();
    }

    @Test
    void partA() {
        ImmutableList<char[]> inputs = ImmutableList.of(".#.".toCharArray(),
                "..#".toCharArray(),
                "###".toCharArray());
        assertEquals(112
                , _subject.partA(inputs));
    }

    @Test
    void partB() {
        assertEquals(71
                , _subject.partA(ImmutableList.of("".toCharArray())));
    }
}