package com.chemies.AoC2020.day;


import com.chemies.AoC2020.data.InputsDay05;
import days.Day05;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day05Test {
  private Day05 _subject;

  @BeforeEach
  void setup() {
    _subject = new Day05();
  }

  @Test
  public void partA_FindSeat() {
    int expected = 820;

    assertEquals(expected, _subject.partA(InputsDay05.sample));
  }

  @Test
  public void calcRowTest() {
    int expected = 70;
    String in = "BFFFBBFRRR";
    assertEquals(expected, _subject.calcRow(in));
    int expectedCol = 7;
    assertEquals(expectedCol, _subject.calcColumn(in));
    int expectedSeat = 567;
    assertEquals(expectedSeat, _subject.calcSeat(in));
  }

  @Test
  public void calcRowTest2() {
    int expected = 44;
    String in = "FBFBBFFRLR";

    assertEquals(expected, _subject.calcRow(in));
    int expectedCol = 5;
    assertEquals(expectedCol, _subject.calcColumn(in));
    int expectedSeat = 357;
    assertEquals(expectedSeat, _subject.calcSeat(in));
  }

  @Test
  public void calcRowTest3() {
    int expected = 14;
    String in = "FFFBBBFRRR";

    assertEquals(expected, _subject.calcRow(in));
    int expectedCol = 7;
    assertEquals(expectedCol, _subject.calcColumn(in));
    int expectedSeat = 119;
    assertEquals(expectedSeat, _subject.calcSeat(in));
  }

  @Test
  public void calcRowTest4() {
    int expected = 102;
    String in = "BBFFBBFRLL";

    assertEquals(expected, _subject.calcRow(in));
    int expectedCol = 4;
    assertEquals(expectedCol, _subject.calcColumn(in));
    int expectedSeat = 820;
    assertEquals(expectedSeat, _subject.calcSeat(in));
  }
}
