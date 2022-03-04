package com.roni.tictactoegames.service;

import com.roni.tictactoegames.model.GameDomain;
import com.roni.tictactoegames.model.MoveDomain;
import com.roni.tictactoegames.model.BeginDomain;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GameDomain game;

    public GameDomain getGame() {
        if (this.game == null) {
            this.game = new GameDomain(3);
        }
        return this.game;
    }

    public GameDomain beginGame(BeginDomain input) {
        this.game = new GameDomain(input.getBoardDimension());
        return this.game;
    }

    public GameDomain move(MoveDomain move) {
        this.game.doMove(move.getX(), move.getY());
        return this.game;
    }
}
