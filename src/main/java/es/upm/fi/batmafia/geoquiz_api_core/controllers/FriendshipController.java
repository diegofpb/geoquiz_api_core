package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Friendship;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.FriendshipRepository;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.UserRepository;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.Constants;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.FriendshipWrapper;
import es.upm.fi.batmafia.geoquiz_api_core.wrappers.exceptions.GeoExceptionElementNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RepositoryRestController
public class FriendshipController {

    private UserRepository userRepository;
    private FriendshipRepository friendshipRepository;

    @Autowired
    public FriendshipController (UserRepository userRepository, FriendshipRepository friendshipRepository) {
        this.userRepository = userRepository;
        this.friendshipRepository = friendshipRepository;
    }

    @PostMapping("/friendships")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void saveFriendship (@Valid @RequestBody FriendshipWrapper friendshipWrapper) throws GeoExceptionElementNotFound {

        User user1 = userRepository.findByUsername(friendshipWrapper.getUser1());
        User user2 = userRepository.findByUsername(friendshipWrapper.getUser2());

        if(user1 == null || user2 == null) {
            throw new GeoExceptionElementNotFound(Constants.USER_NOT_FOUND_CODE,Constants.USER_NOT_FOUND_MSG);
        }

        if(friendshipRepository.checkIfFriends(user1, user2) != null) {
            throw new GeoExceptionElementNotFound(Constants.FRIENDSHIP_ALREADY_CREATED_CODE,Constants.FRIENDSHIP_ALREADY_CREATED_MSG);
        }

        friendshipRepository.save(new Friendship(user1, user2));

    }

}
