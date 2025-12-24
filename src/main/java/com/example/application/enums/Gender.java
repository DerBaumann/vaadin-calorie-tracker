package com.example.application.enums;

public enum Gender {
    Male,
    Female;

    public String toLabel() {
        return switch (this) {
            case Male ->  "Male";
            case Female ->  "Female";
        };
    }
}
