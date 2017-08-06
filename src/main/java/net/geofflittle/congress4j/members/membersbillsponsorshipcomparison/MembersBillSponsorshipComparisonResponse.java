package net.geofflittle.congress4j.members.membersbillsponsorshipcomparison;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MembersBillSponsorshipComparisonResponse {

    private final String status;
    private final String copyright;
    private final List<MembersBillSponsorshipComparisonResult> results;

}
