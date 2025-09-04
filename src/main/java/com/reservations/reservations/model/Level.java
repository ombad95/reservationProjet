package com.reservations.reservations.model;

public enum Level {
    NATIVE("Langue maternelle"),
    BEGINNER("Débutant"),
    INTERMEDIATE("Intermédiaire"),
    FLUENT("Courant");

    private final String displayName;

    Level(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}