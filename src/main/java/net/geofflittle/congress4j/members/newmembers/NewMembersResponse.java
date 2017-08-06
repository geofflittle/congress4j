package net.geofflittle.congress4j.members.newmembers;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class NewMembersResponse {

    private final String status;
    private final String copyright;
    private final List<NewMembersResult> results;

}
