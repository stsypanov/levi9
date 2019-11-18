package com.example.demo.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Pit implements HasStones {
  private int stoneCount = 6;

  @Override
  public void addStone() {
    stoneCount++;
  }

  @Override
  public int removeAllStones() {
    final int stoneCount = this.stoneCount;
    this.stoneCount = 0;
    return stoneCount;
  }

}
