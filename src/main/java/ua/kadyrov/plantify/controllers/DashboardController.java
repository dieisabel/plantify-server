package ua.kadyrov.plantify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kadyrov.plantify.dtos.SensorsData;
import ua.kadyrov.plantify.services.SensorsService;

@Controller
@RequestMapping(value = "/dashboard", method = {RequestMethod.GET})
public class DashboardController {
    @Autowired
    @Qualifier("sensorsService")
    private SensorsService service;

    @GetMapping
    public String getDashboardTemplate() {
        return "dashboard.html";
    }

    @ModelAttribute("data")
    SensorsData fetchSensorsData() {
        return service.fetchData();
    }

    @ModelAttribute("title")
    String getTitle() {
        return "Dashboard";
    }
}
