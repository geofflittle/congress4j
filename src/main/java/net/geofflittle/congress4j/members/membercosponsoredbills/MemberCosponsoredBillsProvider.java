package net.geofflittle.congress4j.members.membercosponsoredbills;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MemberCosponsoredBillsProvider {

    private static final Function<MemberCosponsoredBillsRequest, String> MEMBER_COSPONSORED_BILLS_PATH_FORMATTER =
            memberCosponsoredBillsRequest -> String.format("/congress/v1/members/%s/bills/%s.json",
                    memberCosponsoredBillsRequest.getMemberId(),
                    memberCosponsoredBillsRequest.getCosponsorshipStatus());
    private final Function<MemberCosponsoredBillsRequest, MemberCosponsoredBillsResponse> memberCosponsoredBillsApi;

    @Inject
    public MemberCosponsoredBillsProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.memberCosponsoredBillsApi =
                proPublicaApiFactory.get(MEMBER_COSPONSORED_BILLS_PATH_FORMATTER, MemberCosponsoredBillsResponse.class);
    }

    public List<CosponsoredBill> get(@NonNull MemberCosponsoredBillsRequest memberCosponsoredBillsRequest) {
        return memberCosponsoredBillsApi.apply(memberCosponsoredBillsRequest).getResults().stream()
                .map(MemberCosponsoredBillsResult::getBills)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
