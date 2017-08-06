package net.geofflittle.congress4j.members.membervotes;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Vote {

    private final String memberId;
    private final String chamber;
    private final String congress;
    private final String session;
    private final String rollCall;
    private final Bill bill;
    private final String description;
    private final String question;
    private final String date;
    private final String time;
    private final String position;

}
