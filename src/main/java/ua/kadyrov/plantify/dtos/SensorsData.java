package ua.kadyrov.plantify.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.kadyrov.plantify.enums.LightLevel;
import ua.kadyrov.plantify.enums.MoistureLevel;

@AllArgsConstructor
@Data
public class SensorsData {
    private int temperature;
    private LightLevel light;
    private MoistureLevel moisture;
}
