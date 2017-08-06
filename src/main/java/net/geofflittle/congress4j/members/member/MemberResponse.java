package net.geofflittle.congress4j.members.member;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemberResponse {

    private final String status;
    private final String copyright;
    private final List<Member> results;

}
