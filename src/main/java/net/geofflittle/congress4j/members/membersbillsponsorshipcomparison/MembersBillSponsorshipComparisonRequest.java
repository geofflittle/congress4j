package net.geofflittle.congress4j.members.membersbillsponsorshipcomparison;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import net.geofflittle.congress4j.model.Chamber;

@Value
@Builder
public class MembersBillSponsorshipComparisonRequest {

    @NonNull
    private final String memberId1;
    @NonNull
    private final String memberId2;
    @NonNull
    private final Integer congress;
    @NonNull
    private final Chamber chamber;

}
