package net.geofflittle.congress4j.members.newmembers;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NewMembersProvider {

    private static final String NEW_MEMBERS_PATH = "/congress/v1/members/new.json";

    private final Function<NewMembersRequest, NewMembersResponse> newMembersApi;

    @Inject
    public NewMembersProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.newMembersApi = proPublicaApiFactory.get(newMembersRequest -> NEW_MEMBERS_PATH, NewMembersResponse.class);
    }

    public List<NewMember> get(@NonNull NewMembersRequest newMembersRequest) {
        return newMembersApi.apply(newMembersRequest).getResults().stream()
                .map(NewMembersResult::getMembers)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
