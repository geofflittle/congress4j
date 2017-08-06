package net.geofflittle.congress4j.members.membersvotecomparison;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.geofflittle.congress4j.model.Chamber;

@Value
@Builder
public class MembersVoteComparisonRequest {

    @NonNull
    private final String memberId1;
    @NonNull
    private final String memberId2;
    @NonNull
    private final Integer congress;
    @NonNull
    private final Chamber chamber;

}
