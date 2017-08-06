package net.geofflittle.congress4j.members.membervotes;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class MemberVotesRequest {

    @NonNull
    private final String memberId;

}
