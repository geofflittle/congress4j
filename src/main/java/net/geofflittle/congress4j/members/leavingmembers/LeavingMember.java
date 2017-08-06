package net.geofflittle.congress4j.members.leavingmembers;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LeavingMember {

    private final String id;
    private final String apiUri;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String party;
    private final String state;
    private final String district;
    private final String beginDate;
    private final String endDate;
    private final String status;
    private final String note;

}
