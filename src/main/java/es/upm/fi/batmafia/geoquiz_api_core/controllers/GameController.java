package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Game;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.GameRepository;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.UserRepository;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.Constants;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.GameSearch;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.GameWrapper;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.exceptions.GeoExceptionElementNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RepositoryRestController
@RequestMapping("/games")
public class GameController {

    private GameRepository gameRepository;
    private UserRepository userRepository;

    @Autowired
    public GameController(GameRepository gameRepository, UserRepository userRepository) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/{userId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void saveGame(@PathVariable("userId") String userId,
                       @Valid @RequestBody GameWrapper gameWrapper) throws GeoExceptionElementNotFound {

        User user = userRepository.findByUsername(userId);
        if (user == null) {
            throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,Constants.USER_NOT_FOUND_MSG);
        }

        gameRepository.save(new Game(user,gameWrapper.getContinent(),
                new Timestamp(gameWrapper.getDate()),gameWrapper.getScore()));

    }

}
