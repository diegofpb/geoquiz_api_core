package es.upm.fi.batmafia.geoquiz_api_core.controllers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RepositoryRestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {

        userService.createUser(user);


    }

}
