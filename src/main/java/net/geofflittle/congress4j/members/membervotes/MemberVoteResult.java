package net.geofflittle.congress4j.members.membervotes;

import lombok.Value;

import java.util.List;

@Value
public class MemberVoteResult {

    private final String memberId;
    private final String totalVotes;
    private final String offset;
    private final List<Vote> votes;

}
