package net.geofflittle.congress4j.members.member;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Committee {

    private final String name;
    private final String code;
    private final String apiUri;
    private final Integer rankInParty;
    private final String beginDate;
    private final String endDate;

}
