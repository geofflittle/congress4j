package net.geofflittle.congress4j.members.memberbydistrict;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.function.Function;

public class MemberByDistrictProvider {

    private static final Function<MembersByDistrictRequest, String> MEMBER_BY_DISTRICT_PATH_FORMATTER =
            membersByDistrictRequest -> String
                    .format("/congress/v1/members/house/%s/%s/current.json", membersByDistrictRequest.getState(),
                            membersByDistrictRequest.getDistrict());

    private final Function<MembersByDistrictRequest, MemberByDistrictResponse> membersByDistrictApi;

    @Inject
    public MemberByDistrictProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.membersByDistrictApi =
                proPublicaApiFactory.get(MEMBER_BY_DISTRICT_PATH_FORMATTER, MemberByDistrictResponse.class);
    }

    public MemberByDistrict get(@NonNull MembersByDistrictRequest membersByDistrictRequest) {
        return membersByDistrictApi.apply(membersByDistrictRequest).getResults().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("No member for %s", membersByDistrictRequest)));
    }
}
