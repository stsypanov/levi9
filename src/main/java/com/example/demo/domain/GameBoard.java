package com.example.demo.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameBoard {

  private final Map<Integer, HasStones> pits = new LinkedHashMap<>();

  public GameBoard() {
    int pitNumber = 1;

    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, Kalah.of(Player.A));

    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber, Kalah.of(Player.B));
  }

  public Player sow(Player player, int pitIndex) {
    checkIndex(player, pitIndex);

    int stones = putAllStonesAwayFromPit(pitIndex);

    int index = pitIndex + 1;

    boolean lastStonePutIntoKalah = false;

    while (stones > 0) {
      HasStones pit = pits.get(index);
      if (pit.isPit() || pit.isMyKalah(player)) {
        pit.addStone();
      }
      if (index++ == 14) {
        index = 1;
      }
      stones--;
      lastStonePutIntoKalah = pit.isKalah();
    }

    if (lastStonePutIntoKalah) {
      return player; //same player sows again
    }

    switch (player) {
      case A:
        return Player.B;
      case B:
        return Player.A;
      default:
        throw new IllegalStateException("Expected either player A or B but was " + player);
    }
  }

  private int putAllStonesAwayFromPit(int pitIndex) {
    return pits.get(pitIndex).removeAllStones();
  }

  private void checkIndex(Player turn, int pitIndex) {
    if (turn == Player.A && pitIndex >= 8) {
      throw new IllegalArgumentException("Player A expects indices 1-7, but was " + pitIndex);
    }

    if (turn == Player.B && pitIndex <= 8) {
      throw new IllegalArgumentException("Player A expects indices 8-14, but was " + pitIndex);
    }

  }

  public List<PitState> getState() {
    return pits.entrySet()
            .stream()
            .map(this::toState)
            .collect(Collectors.toList());
  }

  private PitState toState(Map.Entry<Integer, HasStones> pit) {
    final int pitId = pit.getKey();
    final int stoneCount = pit.getValue().getStoneCount();
    return PitState.of(pitId, stoneCount);
  }

}
