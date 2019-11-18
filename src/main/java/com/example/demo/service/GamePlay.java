package com.example.demo.service;

import com.example.demo.domain.Game;
import com.example.demo.domain.PitState;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GamePlay {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final ConcurrentHashMap<Long, Game> games = new ConcurrentHashMap<>();

    public long startNewGame() {
        final long newGameId = newGameId();
        games.put(newGameId, new Game());
        return newGameId;
    }

    public List<PitState> sow(long gameId, int pitId) {
        return games.get(gameId).sow(pitId);
    }

    private long newGameId() {
        long key;
        do {
            key = random.nextLong(9999L);
        } while (games.containsKey(key));
        return key;
    }
}
