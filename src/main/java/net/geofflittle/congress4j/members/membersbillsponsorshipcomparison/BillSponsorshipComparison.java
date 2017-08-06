package net.geofflittle.congress4j.members.membersbillsponsorshipcomparison;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BillSponsorshipComparison {

    private final String number;
    private final String apiUri;
    private final String title;
    private final String cosponsoredDate;
    private final String sponsorTitle;
    private final String sponsorId;
    private final String sponsorName;
    private final String sponsorState;
    private final String sponsorParty;
    private final String sponsorUri;
    private final String introducedDate;
    private final String cosponsors;
    private final String committees;
    private final String latestMajorActionDate;
    private final String latestMajorAction;
    private final String firstMemberDate;
    private final String secondMemberDate;

}
