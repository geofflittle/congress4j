package net.geofflittle.congress4j.members.memberbydistrict;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MemberByDistrictResponse {

    private final String status;
    private final String copyright;
    private final List<MemberByDistrict> results;

}
