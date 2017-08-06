package net.geofflittle.congress4j.members.member;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Member {

    private final String memberId;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String dateOfBirth;
    private final String gender;
    private final String url;
    private final String timesTopicsUrl;
    private final String timesTag;
    private final String govtrackId;
    private final String cspanId;
    private final String votesmartId;
    private final String icpsrId;
    private final String twitterAccount;
    private final String facebookAccount;
    private final String youtubeAccount;
    private final String crpId;
    private final String googleEntityId;
    private final String rssUrl;
    private final String domain;
    private final String inOffice;
    private final String currentParty;
    private final String mostRecentVote;
    private final List<Role> roles;

}
