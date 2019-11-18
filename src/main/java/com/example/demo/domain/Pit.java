package com.example.demo.domain;

public class Pit {
  protected int stoneCount = 6;

  public void addStone() {
    stoneCount++;
  }

  public void removeStone() {
    stoneCount--;
  }

  public int getStoneCount() {
    return stoneCount;
  }
}
