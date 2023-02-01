package ua.kadyrov.plantify.services;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.kadyrov.plantify.dtos.SensorsData;
import ua.kadyrov.plantify.exceptions.NetworkException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;

@Service("sensorsService")
public class SensorsServiceImpl implements SensorsService {
    @Value("${plantify.device.ip}")
    private String deviceIp;

    @Value("${plantify.device.port}")
    private int devicePort;

    @Override
    public SensorsData fetchData() {
        HttpResponse<String> response;
        URI uri;
        try {
            uri = new URI(String.format("http://%s:%d/sensors", deviceIp, devicePort));
        } catch (URISyntaxException exception) {
            throw new NetworkException("Invalid uri");
        }
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpClient client = HttpClient.newHttpClient();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException exception) {
            throw new NetworkException("Error while sending or receiving sensors data");
        }
        return new Gson().fromJson(response.body(), SensorsData.class);
    }
}
