package net.geofflittle.congress4j.members.newmembers;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NewMember {

    private final String id;
    private final String apiUri;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String party;
    private final String chamber;
    private final String state;
    private final String district;
    private final String startDate;

}
