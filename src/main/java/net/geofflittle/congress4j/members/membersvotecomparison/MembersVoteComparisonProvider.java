package net.geofflittle.congress4j.members.membersvotecomparison;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.function.Function;

public class MembersVoteComparisonProvider {

    private static final Function<MembersVoteComparisonRequest, String> MEMBER_VOTE_COMPARISON_PATH_FORMATTER =
            membersVoteComparisonRequest -> String
                    .format("/congress/v1/members/%s/votes/%s/%s/%s.json", membersVoteComparisonRequest.getMemberId1(),
                            membersVoteComparisonRequest.getMemberId2(), membersVoteComparisonRequest.getCongress(),
                            membersVoteComparisonRequest.getChamber());

    private final Function<MembersVoteComparisonRequest, MembersVoteComparisonResponse> memberVoteComparisonApi;

    @Inject
    public MembersVoteComparisonProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.memberVoteComparisonApi =
                proPublicaApiFactory.get(MEMBER_VOTE_COMPARISON_PATH_FORMATTER, MembersVoteComparisonResponse.class);
    }

    public MembersVoteComparison get(@NonNull MembersVoteComparisonRequest membersVoteComparisonRequest) {
        return memberVoteComparisonApi.apply(membersVoteComparisonRequest).getResults().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("No member vote comparison for %s", membersVoteComparisonRequest)));
    }

}
