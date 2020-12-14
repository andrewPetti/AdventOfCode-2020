package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.Inputs;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {

    private Day13 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day13();
    }

    @Test
    void executePartA() {
        assertEquals(295
                , _subject.partA(Inputs.DAY13_SAMPLE));
    }


  /*  @Test
    void executePartB() {
        assertEquals(25
                , _subject.partB(Inputs.DAY13_SAMPLE, 10L));
    }*/

    @Test
    void executePartB_SampleB() {
        String schedule = "7,13,x,x,59,x,31,19";
        ImmutableList<Integer> valid = ImmutableList.of(7, 13, 59, 31, 19);
        assertEquals(1068781L, _subject.processChineeseRemainderThereom(schedule));
    }

    @Test
    void executePartB_Sample_B() {
        String schedule = "17,x,13,19";
        ImmutableList<Integer> valid = ImmutableList.of(17, 13, 19);
        assertEquals(3417L, _subject.processChineeseRemainderThereom(schedule));
    }

    @Test
    void executePartB_SampleC() {
        String schedule = "67,7,59,61";
        ImmutableList<Integer> valid = ImmutableList.of(67, 7, 59, 61);
        assertEquals(754018L, _subject.processChineeseRemainderThereom(schedule));
    }

    @Test
    void executePartB_SampleD() {
        String schedule = "67,7,x,59,61";
        ImmutableList<Integer> valid = ImmutableList.of(67, 7, 59, 61);
        assertEquals(1261476L, _subject.processChineeseRemainderThereom(schedule));
    }

    @Test
    void executePartB_SampleE() {
        String schedule = "1789,37,47,1889";
        ImmutableList<Integer> valid = ImmutableList.of(67, 7, 59, 61);
        assertEquals(1202161486L, _subject.processChineeseRemainderThereom(schedule));
    }
}