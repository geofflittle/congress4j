package net.geofflittle.congress4j.members.chambermembers;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class ChamberMembersResponse {

    private final String status;
    private final String copyright;
    private final List<ChamberMembersResult> results;

}
