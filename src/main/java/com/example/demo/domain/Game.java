package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game {
//  private final Player player1 = new Player();
//  private final Player player2 = new Player();

  private PlayerTurn turn = PlayerTurn.A;

  public List<PitState> makeAMove(int pit) {
    checkPitNumber(pit);

    switch (turn) {
      case A:
        break;
      case B:
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + turn);
    }

    return new ArrayList<>();
  }

  private void checkPitNumber(int pit) {
    if (pit < 1 || pit > 14) {
      throw new IllegalArgumentException("Pit number expected to be 1..14 but was " + pit);
    }
  }

  private enum PlayerTurn {
    A, B
  }
}
