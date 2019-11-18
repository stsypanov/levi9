package com.example.demo.domain;

public interface HasStones {

  int getStoneCount();

  default boolean isMyKalah(Player player) {
    return false;
  }

  default boolean isKalah() {
    return false;
  }

  default boolean isPit() {
    return true;
  }

  void addStone();

  int removeAllStones();
}
