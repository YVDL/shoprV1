package com.company.shopr.services;

import com.company.shopr.domain.Game;
import com.company.shopr.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public List<Game> getGames() {
        return gameRepository.getGames();
    }

    public void addGame(Game newGame) {
        gameRepository.addGame(newGame);
    }

    public Game findGameById(Long id) {
        return gameRepository.findGameById(id);
    }

    public void editGameById(Game editedGame) { gameRepository.editGameById(editedGame); }

    public void removeGame(long id) { gameRepository.removeGame(id);
    }
}
