package net.geofflittle.congress4j.model;

public enum Chamber {

    HOUSE,
    SENATE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
