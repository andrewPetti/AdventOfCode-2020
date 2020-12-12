package com.chemies.AoC2020.day;

import com.chemies.AoC2020.data.InputsDay11;
import com.google.common.collect.ImmutableList;
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
        assertEquals(37
                , _subject.partA(InputsDay11.SAMPLE));
    }

    @Test
    void executePartB() {
        assertEquals(26
                , _subject.partB(InputsDay11.SAMPLE));
    }

    @Test
    void getAdjacetA() {
        ImmutableList<String> seating = ImmutableList.of(".......#.",
                "...#.....",
                ".#.......",
                ".........",
                "..#L....#",
                "....#....",
                ".........",
                "#........",
                "...#....."

        );
        assertEquals(8,
                _subject.getAdjacentOccupiedB(seating, 4, 3));
    }

    @Test
    void getAdjacetB() {
        ImmutableList<String> seating = ImmutableList.of(
                ".............",
                ".L.L.#.#.#.#.",
                "............."
        );
        assertEquals(0,
                _subject.getAdjacentOccupiedB(seating, 1, 1));
    }


    @Test
    void getAdjacetC() {
        ImmutableList<String> seating = ImmutableList.of(
                ".##.##.",
                "#.#.#.#",
                "##...##",
                "...L...",
                "##...##",
                "#.#.#.#",
                ".##.##."
        );
        assertEquals(0,
                _subject.getAdjacentOccupiedB(seating, 3, 3));
    }
}