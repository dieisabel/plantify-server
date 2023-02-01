package ua.kadyrov.plantify.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SensorsData {
    private int temperature;
    private int light;
    private int moisture;
}
