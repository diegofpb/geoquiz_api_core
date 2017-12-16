package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Friendship;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.FriendshipRepository;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.UserRepository;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.Constants;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.FriendshipWrapper;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.exceptions.GeoExceptionElementNotFound;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RepositoryRestController
@RequestMapping("/friendships")

public class FriendshipController {

  private UserRepository userRepository;
  private FriendshipRepository friendshipRepository;

  @Autowired
  public FriendshipController(UserRepository userRepository,
      FriendshipRepository friendshipRepository) {
    this.userRepository = userRepository;
    this.friendshipRepository = friendshipRepository;
  }

  // TODO ACORDARSE DE A LA HORA DE SOLICITAR AMISTADES, EL SOLICITANTE ES EL USER1.
  @PostMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public void saveFriendship(@Valid @RequestBody FriendshipWrapper friendshipWrapper)
      throws GeoExceptionElementNotFound {

    User user1 = userRepository.findByUsername(friendshipWrapper.getUsername1());
    User user2 = userRepository.findByUsername(friendshipWrapper.getUsername2());

    if (user1 == null || user2 == null) {
      throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,
          Constants.USER_NOT_FOUND_MSG);
    }

    if (friendshipRepository.checkIfFriends(user1, user2) != null) {
      throw new GeoExceptionElementNotFound(Constants.FRIENDSHIP_ALREADY_CREATED_CODE,
          Constants.FRIENDSHIP_ALREADY_CREATED_MSG);
    }

    friendshipRepository.save(new Friendship(user1, user2, false));

  }


  @GetMapping("/getPendingFriendships")
  @ResponseBody
  public List<Friendship> getPendingFriendships(@RequestParam("username") String username)
      throws GeoExceptionElementNotFound {

    User user = userRepository.findByUsername(username);

    if (user == null) {
      throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,
          Constants.USER_NOT_FOUND_MSG);
    }

    return friendshipRepository.findByUser2AndAcceptedFalse(user);
  }


  @PutMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void acceptFriendship(@RequestParam("username1") String username1,
      @RequestParam("username2") String username2)
      throws GeoExceptionElementNotFound {

    User user1 = userRepository.findByUsername(username1);
    User user2 = userRepository.findByUsername(username2);

    if (user1 == null || user2 == null) {
      throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,
          Constants.USER_NOT_FOUND_MSG);
    }

    Friendship friendship = friendshipRepository
        .findByUser1AndUser2AndAcceptedFalse(user1, user2);

    friendship.setAccepted(true);

    friendshipRepository.save(friendship);

  }

}
