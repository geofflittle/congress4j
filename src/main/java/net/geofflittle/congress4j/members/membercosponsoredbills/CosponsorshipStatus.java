package net.geofflittle.congress4j.members.membercosponsoredbills;

public enum CosponsorshipStatus {

    COSPONSORED,
    WITHDRAWN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
