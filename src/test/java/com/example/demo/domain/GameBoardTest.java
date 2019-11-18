package com.example.demo.domain;

import com.example.demo.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest extends BaseTest {
  private GameBoard board = new GameBoard();

  @Test
  void getState() {
    final List<PitState> state = board.getState();
  }
}