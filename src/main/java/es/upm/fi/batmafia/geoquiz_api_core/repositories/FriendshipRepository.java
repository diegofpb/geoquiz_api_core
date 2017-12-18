package es.upm.fi.batmafia.geoquiz_api_core.repositories;

import es.upm.fi.batmafia.geoquiz_api_core.entities.Friendship;
import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "friendship", path = "friendships")
public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {

  @Query(value = "SELECT * FROM friendship WHERE (user1_username = ?1 AND user2_username = ?2) " +
      "OR (user1_username = ?2 AND user2_username = ?1)", nativeQuery = true)
  Friendship checkIfFriends(User user1, User user2);

  List<Friendship> findByUser2AndAcceptedFalse(User user2);

  Friendship findByUser1AndUser2AndAcceptedFalse(User user1, User user2);

}
