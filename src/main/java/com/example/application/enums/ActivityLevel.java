package com.example.application.enums;

public enum ActivityLevel {
    Sedentary, LightlyActive, ModeratelyActive, VeryActive, ExtremelyActive;

    public String toLabel() {
        return switch (this) {
            case Sedentary -> "Sedentary";
            case LightlyActive -> "Lightly active";
            case ModeratelyActive -> "Moderately active";
            case VeryActive -> "Very active";
            case ExtremelyActive -> "Extremely active";
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
