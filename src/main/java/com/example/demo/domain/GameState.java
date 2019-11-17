package com.example.demo.domain;

import lombok.Data;

import java.util.List;

@Data(staticConstructor = "of")
public class GameState {
  private final String id;
  private final String uri;
  private final List<PitState> status;
}
