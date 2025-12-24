package com.example.application.enums;

public enum ActivityLevel {
    Low, Medium, High;

    public String toLabel() {
        return switch (this) {
            case Low -> "Low";
            case Medium -> "Medium";
            case High -> "High";
        };
    }
}
