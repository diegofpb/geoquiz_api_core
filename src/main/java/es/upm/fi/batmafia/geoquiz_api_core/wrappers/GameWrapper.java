package es.upm.fi.batmafia.geoquiz_api_core.wrappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameWrapper {

  private String continent;
  private Long date;
  private int score;

}
