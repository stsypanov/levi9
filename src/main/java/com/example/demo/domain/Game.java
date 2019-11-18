package com.example.demo.domain;

import java.util.List;

public class Game {
  private final GameBoard board = new GameBoard();

  private PlayerTurn turn = PlayerTurn.A;

  public List<PitState> makeAMove(int pit) {
    checkPitNumber(pit);

    turn = board.makeAMove(turn);

    return board.getState();
  }

  private void checkPitNumber(int pit) {
    if (pit < 1 || pit > 14) {
      throw new IllegalArgumentException("Pit number expected to be 1..14 but was " + pit);
    }
  }

}
