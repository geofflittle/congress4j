package net.geofflittle.congress4j.members.leavingmembers;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.geofflittle.congress4j.model.Chamber;

@Value
@Builder
public class LeavingMembersRequest {

    @NonNull
    private final Integer congress;
    @NonNull
    private final Chamber chamber;

}
