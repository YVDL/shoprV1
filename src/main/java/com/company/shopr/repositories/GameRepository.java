package com.company.shopr.repositories;

import com.company.shopr.domain.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Game> getGames() {
        List<Game> gamesList = entityManager.createQuery("select g from Game g order by g.title , g.publisher, g.price", Game.class).getResultList();
        return gamesList; }

    @Transactional
    public void addGame(Game newGame) {
        entityManager.persist(newGame);
    }

    @Transactional
    public Game findGameById(long gameId){
        return entityManager.find(Game.class, gameId);
    }

    @Transactional
    public void editGameById(Game editedGame) { entityManager.merge(editedGame); }

    @Transactional
    public void removeGame(long id) { Game game = findGameById(id); entityManager.remove(game); }
}

