package net.geofflittle.congress4j.members.member;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class MemberRequest {

    @NonNull
    private final String memberId;

}
