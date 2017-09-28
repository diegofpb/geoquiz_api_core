package es.upm.fi.batmafia.geoquiz_api_core.repositories;

import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User, String> {

}
