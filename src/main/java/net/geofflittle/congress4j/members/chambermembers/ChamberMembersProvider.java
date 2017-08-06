package net.geofflittle.congress4j.members.chambermembers;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChamberMembersProvider {

    private static final Function<ChamberMembersRequest, String> CHAMBER_MEMBERS_PATH_FORMATTER =
            chamberMembersRequest -> String
                    .format("/congress/v1/%s/%s/members.json", chamberMembersRequest.getCongress(),
                            chamberMembersRequest.getChamber());

    private final Function<ChamberMembersRequest, ChamberMembersResponse> chamberMembersApi;

    @Inject
    public ChamberMembersProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.chamberMembersApi = proPublicaApiFactory.get(CHAMBER_MEMBERS_PATH_FORMATTER, ChamberMembersResponse.class);
    }

    public List<ChamberMember> get(@NonNull ChamberMembersRequest chamberMembersRequest) {
        return chamberMembersApi.apply(chamberMembersRequest).getResults().stream()
                .map(ChamberMembersResult::getMembers)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
