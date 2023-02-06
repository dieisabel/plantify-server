package ua.kadyrov.plantify.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.kadyrov.plantify.enums.LightLevel;

@AllArgsConstructor
@Data
public class SensorsData {
    private int temperature;
    private LightLevel light;
    private int moisture;
}
