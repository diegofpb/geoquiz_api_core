package es.upm.fi.batmafia.geoquiz_api_core.wrappers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FriendshipWrapper {

    private String user1;
    private String user2;

}
