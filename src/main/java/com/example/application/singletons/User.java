package com.example.application.singletons;

import com.example.application.enums.ActivityLevel;
import com.example.application.enums.BMIStatus;
import com.example.application.enums.Gender;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private String name = "Bob";
    private int age = 32;
    private int height = 180; // cm
    private int weight = 91; // kg
    private ActivityLevel activityLevel = ActivityLevel.Low;
    private Gender gender = Gender.Male;

    public Double getBMI() {
        return weight / Math.pow((double) height / 100, 2);
    }

    public BMIStatus getBMIStatus() {
        return BMIStatus.fromDouble(getBMI());
    }

    // Calculates BMR using Harris-Benedict
    public int getDailyCalories() {
        return (int) switch (gender) {
            case Male -> 66.5 + (13.75 * weight) + (5.003 * height) - (6.75);
            case Female -> 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
        };
    }
}
