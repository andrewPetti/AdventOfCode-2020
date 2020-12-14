package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {
    private Day14 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day14();
    }

    @Test
    void executePartA() {
        assertEquals(165
                , _subject.partA(Inputs.DAY14_SAMPLE));
    }

    @Test
    void partA_calcValueWithMask_11() {
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
        assertEquals(73, _subject.calcMask(mask, 11));
    }

    @Test
    void partA_calcValueWithMask_101() {
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
        assertEquals(101, _subject.calcMask(mask, 101));
    }

    @Test
    void partA_calcValueWithMask_0() {
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
        assertEquals(64, _subject.calcMask(mask, 0));
    }

    @Test
    void partB_maskMemLocation_0() {
        String mask = "000000000000000000000000000000X1001X";
        ImmutableList<Long> expected = ImmutableList.of(26L, 27L, 58L, 59L);
        ImmutableList<Long> actual = _subject.maskMemory(mask, 42);
        assertThat(actual, containsInAnyOrder(26L, 27L, 58L, 59L));
    }

    @Test
    void partB_maskMemLocation_1() {
        String mask = "00000000000000000000000000000000X0XX";
        ImmutableList<Long> actual = _subject.maskMemory(mask, 26);
        assertThat(actual, containsInAnyOrder(16L, 17L, 18L, 19L, 24L, 25L, 26L, 27L));
    }


    @Test
    void executePartB() {
        assertEquals(208
                , _subject.partB(Inputs.DAY14_SAMPLE_B));
    }
/*
    @Test
    void partB_maskMemLocation_2() {
        String mask = "X0101000X00X011X010001X01XX110100100";
        ImmutableList<Long> actual = _subject.maskMemory(mask, 55733);
        assertThat(actual, containsInAnyOrder(1L, 2L, 3L));
    }*/
}