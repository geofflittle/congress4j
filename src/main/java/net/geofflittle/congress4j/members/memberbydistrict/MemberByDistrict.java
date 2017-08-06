package net.geofflittle.congress4j.members.memberbydistrict;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class MemberByDistrict {

    private final String id;
    private final String name;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String role;
    private final String gender;
    private final String party;
    private final String timesTopicsUrl;
    private final String twitterId;
    private final String facebookAccount;
    private final String youtubeId;
    private final String seniority;
    private final String nextElection;
    private final String apiUri;
    private final String district;
    private final Boolean atLarge;

}
