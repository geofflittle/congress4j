package net.geofflittle.congress4j.members.membersbystate;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.geofflittle.congress4j.model.Chamber;

@Value
@Builder
public class MembersByStateRequest {

    @NonNull
    private final Chamber chamber;
    @NonNull
    private final String state;

}
