package net.geofflittle.congress4j.members.chambermembers;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ChamberMember {

    private final String id;
    private final String apiUri;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dateOfBirth;
    private final String party;
    private final String leadershipRole;
    private final String twitterAccount;
    private final String facebookAccount;
    private final String youtubeAccount;
    private final String govtrackId;
    private final String cspanId;
    private final String votesmartId;
    private final String icpsrId;
    private final String crpId;
    private final String googleEntityId;
    private final String url;
    private final String rssUrl;
    private final String contactForm;
    private final String domain;
    private final Boolean inOffice;
    private final Double dwNominate;
    private final String idealPoint;
    private final String seniority;
    private final String nextElection;
    private final Integer totalVotes;
    private final Integer missedVotes;
    private final Integer totalPresent;
    private final String ocdId;
    private final String office;
    private final String phone;
    private final String fax;
    private final String state;
    private final Double missedVotesPct;
    private final Double votesWithPartyPct;

    // House only
    private final String district;
    private final String atLarge;
    private final String geoId;

    // Senate only
    private final String senateClass;
    private final String stateRank;
    private final String lisId;

}
