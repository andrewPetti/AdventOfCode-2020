package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay06;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day06Test {

    private Day06 _subject;

    @BeforeEach
    void setup() {
        _subject = new Day06();
    }

    @Test
    public void partA(){
        assertEquals(1, _subject.partA(InputsDay06.INPUTS));
    }

}