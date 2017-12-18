package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Game;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.GameRepository;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.UserRepository;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.Constants;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.GameSearch;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.exceptions.GeoExceptionElementNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RepositoryRestController
public class UserController {

  private GameRepository gameRepository;
  private UserRepository userRepository;

  @Autowired
  public UserController(GameRepository gameRepository, UserRepository userRepository) {
    this.gameRepository = gameRepository;
    this.userRepository = userRepository;
  }

  @PostMapping("/users/{userId}/score")
  @ResponseBody
  public int ranking(@PathVariable("userId") String userId,
      @Valid @RequestBody GameSearch gameSearch) throws GeoExceptionElementNotFound {

    User user = userRepository.findByUsername(userId);
    if (user == null) {
      throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,
          Constants.USER_NOT_FOUND_MSG);
    }

    List<Game> games = gameRepository.findGamesByUserAndDateAfterAndDateBefore(
        user, new Timestamp(gameSearch.getDate1()), new Timestamp(gameSearch.getDate2()));

    if (games.size() == 0) {
      throw new GeoExceptionElementNotFound(Constants.GAME_NOT_FOUND_CODE,
          Constants.GAME_NOT_FOUND_MSG);
    }

    int score = 0;
    for (Game game : games) {
      score += game.getScore();
    }

    return score;

  }


  @CrossOrigin
  @ResponseBody
  @PutMapping("/users")
  public void updateUser(@Valid @RequestBody User userRequest) throws GeoExceptionElementNotFound {

    User user = userRepository.findOne(userRequest.getUsername());

    if (user == null) {
      throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,
          Constants.USER_NOT_FOUND_MSG);
    }

    user.setCountry(userRequest.getCountry());
    user.setPassword(userRequest.getPassword());
    user.setValidated(userRequest.isValidated());

    userRepository.save(user);

  }

  @CrossOrigin
  @ResponseBody
  @PostMapping("/users")
  public void createUser(@Valid @RequestBody User userRequest) throws GeoExceptionElementNotFound {
    userRepository.save(userRequest);
  }

  @CrossOrigin
  @GetMapping("/users")
  @ResponseBody
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @CrossOrigin
  @GetMapping("/users/orderByCountry")
  @ResponseBody
  public List<User> getAllUsersOrderByCountry() {
    return userRepository.findAllByOrderByCountryAsc();
  }

}
