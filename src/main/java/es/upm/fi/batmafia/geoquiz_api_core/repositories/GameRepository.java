package es.upm.fi.batmafia.geoquiz_api_core.repositories;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Game;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Timestamp;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "game", path = "games")
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByUserAndDateAfterAndDateBefore(User user, Timestamp date, Timestamp date2);

}
