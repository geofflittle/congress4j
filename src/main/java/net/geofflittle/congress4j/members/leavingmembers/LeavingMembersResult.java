package net.geofflittle.congress4j.members.leavingmembers;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class LeavingMembersResult {

    private final String congress;
    private final String chamber;
    private final Integer numResults;
    private final Integer offset;
    private final List<LeavingMember> members;

}
