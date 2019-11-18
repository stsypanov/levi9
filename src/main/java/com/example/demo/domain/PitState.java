package com.example.demo.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@ToString
@Data(staticConstructor = "of")
public class PitState {
  private final int pitId;
  private final int stoneCount;
}
