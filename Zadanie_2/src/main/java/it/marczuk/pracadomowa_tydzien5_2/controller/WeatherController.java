package it.marczuk.pracadomowa_tydzien5_2.controller;

import it.marczuk.pracadomowa_tydzien5_2.entity.City;
import it.marczuk.pracadomowa_tydzien5_2.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService service;

    @Autowired
    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public String getIndexPage(Model model) {
        model.addAttribute("city", new City());
        return "index";
    }

    @GetMapping("/{city}")
    public String getWeather(Model model, @PathVariable String city) {
        model.addAttribute("weather", service.getWeather(city));
        return "weather";
    }

    @PostMapping("/name")
    public String setLocation(@ModelAttribute City newCity){
        return "redirect:/weather/" + newCity.getName();
    }
}
