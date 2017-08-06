package net.geofflittle.congress4j.members.membercosponsoredbills;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class MemberCosponsoredBillsRequest {

    @NonNull
    private final String memberId;
    @NonNull
    private final CosponsorshipStatus cosponsorshipStatus;
}
