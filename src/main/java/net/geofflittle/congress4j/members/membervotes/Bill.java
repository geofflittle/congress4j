package net.geofflittle.congress4j.members.membervotes;

import lombok.Value;

@Value
public class Bill {

    private final String number;
    private final String billUri;
    private final String title;
    private final String latestAction;

}
