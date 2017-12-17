package es.upm.fi.batmafia.geoquiz_api_core.repositories;

import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

    List<User> findAll();

}
