package net.geofflittle.congress4j.members.membercosponsoredbills;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemberCosponsoredBillsResponse {

    private final String status;
    private final String copyright;
    private final List<MemberCosponsoredBillsResult> results;

}
