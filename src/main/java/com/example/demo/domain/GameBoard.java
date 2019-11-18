package com.example.demo.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameBoard {

  private final Map<Integer, Pit> pits = new LinkedHashMap<>();

  public GameBoard() {
    int pitNumber = 1;

    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Kalah());

    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber++, new Pit());
    pits.put(pitNumber, new Kalah());
  }

  public PlayerTurn makeAMove(PlayerTurn turn) {
//todo
    return PlayerTurn.B;
  }

  public List<PitState> getState() {
    return pits.entrySet()
            .stream()
            .map(this::toState)
            .collect(Collectors.toList());
  }

  private PitState toState(Map.Entry<Integer, Pit> pit) {
    final int pitKey = pit.getKey();
    final int stoneCount = pit.getValue().getStoneCount();
    return PitState.of(pitKey, stoneCount);
  }

}
