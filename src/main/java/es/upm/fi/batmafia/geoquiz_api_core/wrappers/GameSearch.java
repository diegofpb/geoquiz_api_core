package es.upm.fi.batmafia.geoquiz_api_core.wrappers;

import es.upm.fi.batmafia.geoquiz_api_core.entities.User;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class GameSearch {

    private Timestamp date1;
    private Timestamp date2;

    private User user;

}
