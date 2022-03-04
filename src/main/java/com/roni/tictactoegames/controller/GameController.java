package com.roni.tictactoegames.controller;

import com.roni.tictactoegames.model.GameDomain;
import com.roni.tictactoegames.model.MoveDomain;
import com.roni.tictactoegames.model.BeginDomain;
import com.roni.tictactoegames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService service;

    @PostMapping(value = "/begin")
    public GameDomain beginGame(@RequestBody BeginDomain input) {
        return service.beginGame(input);
    }

    @PutMapping(value = "/move")
    public GameDomain move(@RequestBody MoveDomain input) {
        return service.move(input);
    }

    @GetMapping
    public GameDomain getGame() {
        return service.getGame();
    }
}
