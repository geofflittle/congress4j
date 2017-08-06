package proof;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.log4j.Log4j2;
import net.geofflittle.congress4j.members.chambermembers.ChamberMember;
import net.geofflittle.congress4j.members.chambermembers.ChamberMembersProvider;
import net.geofflittle.congress4j.members.chambermembers.ChamberMembersRequest;
import net.geofflittle.congress4j.members.leavingmembers.LeavingMember;
import net.geofflittle.congress4j.members.leavingmembers.LeavingMembersProvider;
import net.geofflittle.congress4j.members.leavingmembers.LeavingMembersRequest;
import net.geofflittle.congress4j.members.member.Member;
import net.geofflittle.congress4j.members.member.MemberProvider;
import net.geofflittle.congress4j.members.member.MemberRequest;
import net.geofflittle.congress4j.members.memberbydistrict.MemberByDistrict;
import net.geofflittle.congress4j.members.memberbydistrict.MemberByDistrictProvider;
import net.geofflittle.congress4j.members.memberbydistrict.MembersByDistrictRequest;
import net.geofflittle.congress4j.members.membercosponsoredbills.CosponsoredBill;
import net.geofflittle.congress4j.members.membercosponsoredbills.CosponsorshipStatus;
import net.geofflittle.congress4j.members.membercosponsoredbills.MemberCosponsoredBillsProvider;
import net.geofflittle.congress4j.members.membercosponsoredbills.MemberCosponsoredBillsRequest;
import net.geofflittle.congress4j.members.membersbillsponsorshipcomparison.BillSponsorshipComparison;
import net.geofflittle.congress4j.members.membersbillsponsorshipcomparison.MembersBillSponsorshipComparisonProvider;
import net.geofflittle.congress4j.members.membersbillsponsorshipcomparison.MembersBillSponsorshipComparisonRequest;
import net.geofflittle.congress4j.members.membersbystate.MemberByState;
import net.geofflittle.congress4j.members.membersbystate.MembersByStateProvider;
import net.geofflittle.congress4j.members.membersbystate.MembersByStateRequest;
import net.geofflittle.congress4j.members.membervotes.MemberVotesProvider;
import net.geofflittle.congress4j.members.membervotes.MemberVotesRequest;
import net.geofflittle.congress4j.members.membervotes.Vote;
import net.geofflittle.congress4j.members.newmembers.NewMember;
import net.geofflittle.congress4j.members.newmembers.NewMembersProvider;
import net.geofflittle.congress4j.members.newmembers.NewMembersRequest;
import net.geofflittle.congress4j.model.Chamber;

import java.util.List;

@Log4j2
public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Congress4jModule());
        ChamberMembersProvider chamberMembersProvider = injector.getInstance(ChamberMembersProvider.class);
        List<ChamberMember> houseMembers = chamberMembersProvider.get(ChamberMembersRequest.builder()
                .congress(115)
                .chamber(Chamber.HOUSE)
                .build());
        List<ChamberMember> senateMembers = chamberMembersProvider.get(ChamberMembersRequest.builder()
                .congress(115)
                .chamber(Chamber.SENATE)
                .build());

        MemberProvider memberProvider = injector.getInstance(MemberProvider.class);
        Member member = memberProvider.get(MemberRequest.builder().memberId("K000388").build());

        NewMembersProvider newMembersProvider = injector.getInstance(NewMembersProvider.class);
        List<NewMember> newMembers = newMembersProvider.get(NewMembersRequest.builder().build());

        MembersByStateProvider membersByStateProvider = injector.getInstance(MembersByStateProvider.class);
        List<MemberByState> houseMembersByState = membersByStateProvider.get(MembersByStateRequest.builder()
                .chamber(Chamber.HOUSE)
                .state("MD")
                .build());
        List<MemberByState> senateMembersByState = membersByStateProvider.get(MembersByStateRequest.builder()
                .chamber(Chamber.SENATE)
                .state("MD")
                .build());

        MemberByDistrictProvider memberByDistrictProvider = injector.getInstance(MemberByDistrictProvider.class);
        MemberByDistrict memberByDistrict = memberByDistrictProvider.get(MembersByDistrictRequest.builder()
                .state("MD")
                .district("1")
                .build());

        LeavingMembersProvider leavingMembersProvider = injector.getInstance(LeavingMembersProvider.class);
        List<LeavingMember> leavingHouseMembers = leavingMembersProvider.get(LeavingMembersRequest.builder()
                .congress(115)
                .chamber(Chamber.HOUSE)
                .build());
        List<LeavingMember> leavingSenateMembers = leavingMembersProvider.get(LeavingMembersRequest.builder()
                .congress(115)
                .chamber(Chamber.HOUSE)
                .build());

        MemberVotesProvider memberVotesProvider = injector.getInstance(MemberVotesProvider.class);
        List<Vote> votes = memberVotesProvider.get(MemberVotesRequest.builder()
                .memberId("K000388")
                .build());

        MembersBillSponsorshipComparisonProvider membersBillSponsorshipComparisonProvider =
                injector.getInstance(MembersBillSponsorshipComparisonProvider.class);
        List<BillSponsorshipComparison> billSponsorshipComparisons = membersBillSponsorshipComparisonProvider.get(
                MembersBillSponsorshipComparisonRequest.builder()
                        .memberId1("B001283")
                        .memberId2("C001101")
                        .congress(114)
                        .chamber(Chamber.HOUSE)
                        .build());

        MemberCosponsoredBillsProvider memberCosponsoredBillsProvider =
                injector.getInstance(MemberCosponsoredBillsProvider.class);
        List<CosponsoredBill> cosponsoredBills =
                memberCosponsoredBillsProvider.get(MemberCosponsoredBillsRequest.builder()
                        .memberId("B001260")
                        .cosponsorshipStatus(CosponsorshipStatus.COSPONSORED)
                        .build());

        log.info(cosponsoredBills);
    }

}
