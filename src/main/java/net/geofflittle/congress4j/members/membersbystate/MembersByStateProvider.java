package net.geofflittle.congress4j.members.membersbystate;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;

public class MembersByStateProvider {

    private static final Function<MembersByStateRequest, String> MEMBERS_BY_STATE_PATH_FORMATTER =
            membersByStateRequest -> String
                    .format("/congress/v1/members/%s/%s/current.json", membersByStateRequest.getChamber(),
                            membersByStateRequest.getState());

    private final Function<MembersByStateRequest, MembersByStateResponse> membersByStateApi;

    @Inject
    public MembersByStateProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.membersByStateApi =
                proPublicaApiFactory.get(MEMBERS_BY_STATE_PATH_FORMATTER, MembersByStateResponse.class);
    }

    public List<MemberByState> get(@NonNull MembersByStateRequest membersByStateRequest) {
        return membersByStateApi.apply(membersByStateRequest).getResults();
    }
}
