package com.example.application.singletons;

import com.example.application.enums.ActivityLevel;
import com.example.application.enums.BMIStatus;
import com.example.application.enums.Gender;

public final class User {
    public static final String name = "";
    public static final int age = 0;
    public static final int height = 0; // cm
    public static final int weight = 0; // kg
    public static final ActivityLevel activityLevel = ActivityLevel.Low;
    public static final Gender gender = Gender.Male;

    public static Double getBMI() {
        return weight / Math.pow(height, 2);
    }

    public static BMIStatus getBMIStatus() {
        return BMIStatus.fromDouble(getBMI());
    }

    // Calculates BMR using Harris-Benedict
    public static double getDailyCalories() {
        return switch (gender) {
            case Male -> 66.5 + (13.75 * weight) + (5.003 * height) - (6.75);
            case Female -> 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
        };
    }
}
