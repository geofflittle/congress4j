package net.geofflittle.congress4j.members.membervotes;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemberVotesResponse {

    private final String status;
    private final String copyright;
    private final List<MemberVoteResult> results;

}
