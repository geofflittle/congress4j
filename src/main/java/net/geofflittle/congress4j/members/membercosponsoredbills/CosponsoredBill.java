package net.geofflittle.congress4j.members.membercosponsoredbills;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CosponsoredBill {

    private final String congress;
    private final String billId;
    private final String billType;
    private final String number;
    private final String billUri;
    private final String title;
    private final String cosponsoredDate;
    private final String sponsorTitle;
    private final String sponsorId;
    private final String sponsorName;
    private final String sponsorState;
    private final String sponsorParty;
    private final String sponsorUri;
    private final String gpoPdfUri;
    private final String congressdotgovUrl;
    private final String govtrackUrl;
    private final String introducedDate;
    private final Boolean active;
    private final String housePassage;
    private final String senatePassage;
    private final String enacted;
    private final String vetoed;
    private final Integer cosponsors;
    private final String committees;
    private final String primarySubject;
    private final String summary;
    private final String summaryShort;
    private final String latestMajorActionDate;
    private final String latestMajorAction;

}
