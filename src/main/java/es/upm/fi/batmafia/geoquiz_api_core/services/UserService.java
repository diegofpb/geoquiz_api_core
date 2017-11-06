package es.upm.fi.batmafia.geoquiz_api_core.services;

import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import es.upm.fi.batmafia.geoquiz_api_core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

}
