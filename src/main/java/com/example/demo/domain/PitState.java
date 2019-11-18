package com.example.demo.domain;

import javafx.util.Pair;
import lombok.Data;

import java.util.Map;

@Data(staticConstructor = "of")
public class PitState {
  private final int pitId;
  private final int stoneCount;
}
