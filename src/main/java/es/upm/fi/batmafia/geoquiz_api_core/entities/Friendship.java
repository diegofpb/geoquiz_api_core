package es.upm.fi.batmafia.geoquiz_api_core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @NotNull
  @OneToOne
  private User user1;
  @NotNull
  @OneToOne
  private User user2;
  @NotNull
  private boolean accepted;

  public Friendship(User user1, User user2, boolean accepted) {
    this.user1 = user1;
    this.user2 = user2;
    this.accepted = accepted;
  }

}
