package es.upm.fi.batmafia.geoquiz_api_core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String country;
    @NotNull
    @Email
    private String email;
    private boolean validated;

    public User(String username, String password, String country, String email, boolean validated) {
        this.username = username;
        this.password = password;
        this.country = country;
        this.email = email;
        this.validated = validated;
    }
}

