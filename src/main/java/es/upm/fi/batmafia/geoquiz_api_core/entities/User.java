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
@AllArgsConstructor
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

}
