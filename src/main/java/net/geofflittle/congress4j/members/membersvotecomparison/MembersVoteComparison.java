package net.geofflittle.congress4j.members.membersvotecomparison;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MembersVoteComparison {

    private final String firstMemberId;
    private final String firstMemberApiUri;
    private final String secondMemberId;
    private final String secondMemberApiUri;
    private final String congress;
    private final String chamber;
    private final String commonVotes;
    private final String disagreeVotes;
    private final String agreePercent;
    private final String disagreePercent;

}
