package ua.kadyrov.plantify.enums;

public enum LightLevel {
    HEAVY_SHADE("Heavy shade"),
    PARTIAL_SHADE("Partial shade"),
    MEDIUM("Medium"),
    FULL_SUN("Full sun");

    private final String displayValue;

    private LightLevel(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public static LightLevel fromInt(int light) {
        if (light <= 5000) {
            return LightLevel.HEAVY_SHADE;
        }
        if (light <= 15000) {
            return LightLevel.PARTIAL_SHADE;
        }
        if (light <= 35000) {
            return LightLevel.MEDIUM;
        } else {
            return LightLevel.FULL_SUN;
        }
    }
}
