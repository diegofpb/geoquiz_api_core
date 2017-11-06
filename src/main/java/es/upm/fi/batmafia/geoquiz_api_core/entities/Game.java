package es.upm.fi.batmafia.geoquiz_api_core.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
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

}
