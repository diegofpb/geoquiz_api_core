package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Game;
import es.upm.fi.batmafia.geoquiz_api_core.services.GameService;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.GameSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.sql.Timestamp;
import java.util.List;

@RepositoryRestController
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public List<Game> findGamesBetween(GameSearch gameSearch) {
        return gameService.findGamesBetween(gameSearch);
    }

}
