package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Game;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.GameRepository;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.GameSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RepositoryRestController
@RequestMapping("/users")
public class UserController {

    GameRepository gameRepository;

    @Autowired
    public UserController(GameRepository gameRepository) {this.gameRepository=gameRepository;}

    @PostMapping("/score")
    public int ranking(@RequestBody GameSearch gameSearch) {

        int score = 0;
        List<Game> games = gameRepository.findByUserAndDateAfterAndDateBefore(gameSearch.getUser(),
                gameSearch.getDate1(), gameSearch.getDate2());

        for(Game game : games)
            score += game.getScore();

        return score;

    }

}
