package net.geofflittle.congress4j.members.newmembers;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class NewMembersResult {

    private final String numResults;
    private final String offset;
    private final List<NewMember> members;

}
