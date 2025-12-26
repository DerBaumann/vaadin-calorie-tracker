package com.example.application.enums;

public enum ActivityLevel {
    Sedentary, LightlyActive, ModeratelyActive, VeryActive, ExtremelyActive;

    public String toLabel() {
        return switch (this) {
            case Sedentary -> "Sitzend";
            case LightlyActive -> "Leicht aktiv";
            case ModeratelyActive -> "Mässig aktiv";
            case VeryActive -> "Sehr aktiv";
            case ExtremelyActive -> "Extrem aktiv";
        };
    }

    public double getFactor() {
        return switch (this) {
            case Sedentary -> 1.2;
            case LightlyActive -> 1.375;
            case ModeratelyActive -> 1.55;
            case VeryActive -> 1.725;
            case ExtremelyActive -> 1.9;
        };
    }
}
