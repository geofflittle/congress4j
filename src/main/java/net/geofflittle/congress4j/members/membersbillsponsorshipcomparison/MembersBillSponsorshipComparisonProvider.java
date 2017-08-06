package net.geofflittle.congress4j.members.membersbillsponsorshipcomparison;

import lombok.NonNull;
import net.geofflittle.congress4j.client.ProPublicaApiFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MembersBillSponsorshipComparisonProvider {

    private static final Function<MembersBillSponsorshipComparisonRequest, String>
            MEMBER_BILL_SPONSORSHIP_COMPARISON_PATH_FORMATTER = membersBillSponsorshipComparisonRequest -> String
            .format("/congress/v1/members/%s/bills/%s/%s/%s.json",
                    membersBillSponsorshipComparisonRequest.getMemberId1(),
                    membersBillSponsorshipComparisonRequest.getMemberId2(),
                    membersBillSponsorshipComparisonRequest.getCongress(),
                    membersBillSponsorshipComparisonRequest.getChamber());
    private final Function<MembersBillSponsorshipComparisonRequest, MembersBillSponsorshipComparisonResponse>
            memberBillSponsorshipComparisonApi;

    @Inject
    public MembersBillSponsorshipComparisonProvider(@NonNull ProPublicaApiFactory proPublicaApiFactory) {
        this.memberBillSponsorshipComparisonApi = proPublicaApiFactory
                .get(MEMBER_BILL_SPONSORSHIP_COMPARISON_PATH_FORMATTER, MembersBillSponsorshipComparisonResponse.class);
    }

    public List<BillSponsorshipComparison> get(
            @NonNull MembersBillSponsorshipComparisonRequest membersBillSponsorshipComparisonRequest) {
        return memberBillSponsorshipComparisonApi.apply(membersBillSponsorshipComparisonRequest).getResults().stream()
                .map(MembersBillSponsorshipComparisonResult::getBills)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
