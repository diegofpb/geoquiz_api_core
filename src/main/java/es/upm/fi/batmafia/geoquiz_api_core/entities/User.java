package es.upm.fi.batmafia.geoquiz_api_core.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  private String username;
  private String password;
  private String country;
  private String email;

  private boolean validated;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isValidated() {
    return validated;
  }

  public void setValidated(boolean validated) {
    this.validated = validated;
  }
}

