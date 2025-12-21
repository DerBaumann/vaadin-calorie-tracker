package com.example.application.enums;

public enum BMIStatus {
    Underweight, Normal, Overweight, ObesetyClass1, ObesetyClass2, ObesetyClass3;

    public static BMIStatus fromDouble(double bmi) {
        if (bmi < 18.5) {
            return BMIStatus.Underweight;
        } else if (bmi < 25.0) {
            return BMIStatus.Normal;
        } else if (bmi < 30.0) {
            return BMIStatus.Overweight;
        } else if (bmi < 35.0) {
            return BMIStatus.ObesetyClass1;
        } else if (bmi < 40.0) {
            return BMIStatus.ObesetyClass2;
        } else {
            return BMIStatus.ObesetyClass3;
        }
    }

    public String toString() {
        return switch (this) {
            case Underweight -> "underweight";
            case Normal -> "normal";
            case Overweight -> "overweight";
            case ObesetyClass1 -> "obesety class 1";
            case ObesetyClass2 -> "obesety class 2";
            case ObesetyClass3 -> "obesety class 3";
        };
    }
}
