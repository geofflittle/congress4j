package net.geofflittle.congress4j.members.member;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.function.Function;

public class MemberProvider {

    private static final Function<MemberRequest, String> MEMBER_PATH_FORMATTER =
            memberRequest -> String.format("/congress/v1/members/%s.json", memberRequest.getMemberId());

    private final Function<MemberRequest, MemberResponse> memberApi;

    @Inject
    public MemberProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.memberApi = proPublicaApiFactory.get(MEMBER_PATH_FORMATTER, MemberResponse.class);
    }

    public Member get(@NonNull MemberRequest memberRequest) {
        return memberApi.apply(memberRequest).getResults().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("No member for %s", memberRequest)));
    }

}
