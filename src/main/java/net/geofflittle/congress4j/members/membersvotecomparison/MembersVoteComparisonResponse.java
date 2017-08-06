package net.geofflittle.congress4j.members.membersvotecomparison;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MembersVoteComparisonResponse {

    private final String status;
    private final String copyright;
    private final List<MembersVoteComparison> results;

}
