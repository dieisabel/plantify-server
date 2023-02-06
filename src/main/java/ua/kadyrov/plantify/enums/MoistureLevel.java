package ua.kadyrov.plantify.enums;

public enum MoistureLevel {
    LOW("Low"),
    HIGH("High");

    private final String displayValue;

    private MoistureLevel(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static MoistureLevel fromInt(int moisture) {
        if (moisture <= 300) {
            return MoistureLevel.LOW;
        } else {
            return MoistureLevel.HIGH;
        }
    }
}
