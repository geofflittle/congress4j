package net.geofflittle.congress4j.members.memberbydistrict;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class MembersByDistrictRequest {

    @NonNull
    private final String state;
    @NonNull
    private final String district;

}
