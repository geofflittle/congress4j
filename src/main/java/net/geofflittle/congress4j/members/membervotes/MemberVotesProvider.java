package net.geofflittle.congress4j.members.membervotes;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MemberVotesProvider {

    private static final Function<MemberVotesRequest, String> MEMBER_VOTES_PATH_FORMATTER =
            memberVotesRequest -> String.format("/congress/v1/members/%s/votes.json", memberVotesRequest.getMemberId());

    private final Function<MemberVotesRequest, MemberVotesResponse> memberVotesApi;

    @Inject
    public MemberVotesProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.memberVotesApi = proPublicaApiFactory.get(MEMBER_VOTES_PATH_FORMATTER, MemberVotesResponse.class);
    }

    public List<Vote> get(@NonNull MemberVotesRequest memberVotesRequest) {
        return memberVotesApi.apply(memberVotesRequest).getResults().stream()
                .map(MemberVoteResult::getVotes)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
