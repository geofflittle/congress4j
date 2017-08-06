package net.geofflittle.congress4j.members.member;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Role {

    private final String congress;
    private final String chamber;
    private final String title;
    private final String state;
    private final String party;
    private final String leadershipRole;
    private final String fecCandidateId;
    private final String seniority;
    private final String district;
    private final Boolean atLarge;
    private final String ocdId;
    private final String startDate;
    private final String endDate;
    private final String office;
    private final String phone;
    private final String fax;
    private final String contactForm;
    private final Integer billsSponsored;
    private final Integer billsCosponsored;
    private final Double missedVotesPct;
    private final Double votesWithPartyPct;
    private final List<Committee> committees;

}
