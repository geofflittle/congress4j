package net.geofflittle.congress4j.members.leavingmembers;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeavingMembersProvider {

    private static final Function<LeavingMembersRequest, String> LEAVING_MEMBERS_PATH_FORMATTER =
            leavingMembersRequest -> String
                    .format("/congress/v1/%s/%s/members/leaving.json", leavingMembersRequest.getCongress(),
                            leavingMembersRequest.getChamber());

    private final Function<LeavingMembersRequest, LeavingMembersResponse> leavingMembersApi;

    @Inject
    public LeavingMembersProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.leavingMembersApi =
                proPublicaApiFactory.get(LEAVING_MEMBERS_PATH_FORMATTER, LeavingMembersResponse.class);
    }

    public List<LeavingMember> get(@NonNull LeavingMembersRequest leavingMembersRequest) {
        return leavingMembersApi.apply(leavingMembersRequest).getResults().stream()
                .map(LeavingMembersResult::getMembers)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
