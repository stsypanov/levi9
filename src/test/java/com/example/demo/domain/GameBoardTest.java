package com.example.demo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameBoardTest {
  private GameBoard board;

  @BeforeEach
  void setUp() {
    board = new GameBoard();
  }

  @Test
  void getState_noSows() {
    List<PitState> state = board.getState();
    for (int i = 0; i < state.size(); i++) {
      if (i < 6) {
        assert state.get(i).getStoneCount() == 6;
        continue;
      }
      if (i == 6) {
        assert state.get(i).getStoneCount() == 0;
        continue;
      }
      if (i != 13) {
        assert state.get(i).getStoneCount() == 6;
        continue;
      }
      assert state.get(i).getStoneCount() == 0;
    }
  }

  @Test
  void firstSow() {
    final int pitIndex = 1;

    board.sow(Player.A, pitIndex);

    List<PitState> state = board.getState();

    int i = pitIndex - 1;
    assertEquals(0, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(1, state.get(i++).getStoneCount());
    assertEquals(6, state.get(i).getStoneCount());
  }

  @Test
  void firstSows_rivalKalahRemainsEmpty() {
    int pitIndex = 5;

    board.sow(Player.A, pitIndex);

    List<PitState> state = board.getState();

    int i = pitIndex - 1;
    assertEquals(0, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(1, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(7, state.get(i++).getStoneCount());
    assertEquals(6, state.get(i).getStoneCount());
  }

}