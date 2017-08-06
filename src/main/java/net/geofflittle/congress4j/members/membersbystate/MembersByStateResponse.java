package net.geofflittle.congress4j.members.membersbystate;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MembersByStateResponse {

    private final String status;
    private final String copyright;
    private final List<MemberByState> results;

}
