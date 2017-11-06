package es.upm.fi.batmafia.geoquiz_api_core.services;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Game;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.GameRepository;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.GameSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findGamesBetween(User user, GameSearch gameSearch) {
        return gameRepository.findByUserAndDateAfterAndDateBefore(user, gameSearch.getDate(), gameSearch.getDate2());
    }

}
