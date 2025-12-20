package com.example.application.components.grid;

public sealed interface GridTrack permits GridTrack.AutoFit, GridTrack.Count {
    default String toCss() {
        return switch (this) {
            case AutoFit ignored -> "auto-fit";
            case Count(int n) -> String.valueOf(n);
        };
    }

    record AutoFit() implements GridTrack {}

    record Count(int n) implements GridTrack {
        public Count {
            if (n <= 0) {
                throw new IllegalArgumentException("value must be positive");
            }
        }
    }
}

