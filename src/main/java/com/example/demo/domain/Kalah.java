package com.example.demo.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@RequiredArgsConstructor(staticName = "of")
public class Kalah implements HasStones {
    private final Player player;
    private int stoneCount = 0;

    @Override
    public boolean isMyKalah(Player player) {
        return this.player == Objects.requireNonNull(player);
    }

    @Override
    public boolean isKalah() {
        return true;
    }

    @Override
    public boolean isPit() {
        return false;
    }

    @Override
    public void addStone() {
        stoneCount++;
    }

    @Override
    public int removeAllStones() {
        throw new UnsupportedOperationException("Stones cannot be taken out of kalah!");
    }
}
