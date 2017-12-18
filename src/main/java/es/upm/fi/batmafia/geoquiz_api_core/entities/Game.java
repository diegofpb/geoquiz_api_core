package es.upm.fi.batmafia.geoquiz_api_core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @NotNull
  @ManyToOne
  private User user;
  @NotNull
  private String continent;
  @NotNull
  private Timestamp date;
  @NotNull
  private int score;

  public Game(User user, String continent, Timestamp date, int score) {
    this.user = user;
    this.continent = continent;
    this.date = date;
    this.score = score;
  }

}
