package net.geofflittle.congress4j.members.leavingmembers;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LeavingMembersResponse {

    private final String status;
    private final String copyright;
    private final List<LeavingMembersResult> results;

}
