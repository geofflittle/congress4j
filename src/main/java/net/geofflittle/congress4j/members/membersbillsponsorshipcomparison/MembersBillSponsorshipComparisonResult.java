package net.geofflittle.congress4j.members.membersbillsponsorshipcomparison;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MembersBillSponsorshipComparisonResult {

    private final String firstMemberApiUri;
    private final String secondMemberApiUri;
    private final String chamber;
    private final String congress;
    private final String commonBills;
    private final List<BillSponsorshipComparison> bills;

}
