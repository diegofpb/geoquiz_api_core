package es.upm.fi.batmafia.geoquiz_api_core.wrappers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GeoExceptionElementNotFound extends Exception {

  private int code;
  private String message;

}