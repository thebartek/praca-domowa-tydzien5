package it.marczuk.pracadomowa_tydzien5_2.service;

import it.marczuk.pracadomowa_tydzien5_2.entity.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Override
    public Weather getWeather(String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject("http://api.weatherapi.com/v1/current.json?key=ab6b5e968d8e4350a4e165036210303&q=" + city, Weather.class);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return new Weather();
    }
}
