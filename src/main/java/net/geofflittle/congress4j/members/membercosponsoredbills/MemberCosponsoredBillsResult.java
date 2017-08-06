package net.geofflittle.congress4j.members.membercosponsoredbills;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemberCosponsoredBillsResult {

    private final String id;
    private final String memberUri;
    private final String name;
    private final Integer numResults;
    private final Integer offset;
    private final List<CosponsoredBill> bills;

}
