package com.example.demo.controller;

import com.example.demo.domain.GameState;
import com.example.demo.domain.PitState;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {
  private final GamePlay gamePlay;
  private final UriProvider uriProvider;

  @ResponseBody
  @PostMapping(value = "/games")
  public ResponseEntity<NewGameInfo> startNewGame(HttpServletRequest request) {
    long newGameId = gamePlay.startNewGame();

    String uri = uriProvider.newGameUri(request);

    NewGameInfo newGameInfo = NewGameInfo.of(String.valueOf(newGameId), uri);

    return new ResponseEntity<>(newGameInfo, HttpStatus.CREATED);
  }

  @ResponseBody
  @PutMapping(value = "/games/{gameId}/pits/{pitId}")
  public ResponseEntity<GameState> makeAMove(
          @PathVariable("gameId") long gameId,
          @PathVariable("pitId") int pitId,
          HttpServletRequest request
  ) {
    final List<PitState> pitStates = gamePlay.makeAMove(gameId, pitId);
    final String uriString = uriProvider.existingGameUri(request, gameId);
    final GameState state = GameState.of(String.valueOf(gameId), uriString, pitStates);
    return ResponseEntity.ok(state);
  }

  @Data(staticConstructor = "of")
  static class NewGameInfo {
    private final String id;
    private final String uri;
  }
}
