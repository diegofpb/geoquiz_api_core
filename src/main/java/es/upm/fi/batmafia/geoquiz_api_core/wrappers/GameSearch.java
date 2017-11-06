package es.upm.fi.batmafia.geoquiz_api_core.wrappers;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class GameSearch {

    private Timestamp date;
    private Timestamp date2;

}
