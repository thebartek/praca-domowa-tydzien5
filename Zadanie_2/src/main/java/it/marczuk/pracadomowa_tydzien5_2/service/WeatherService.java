package it.marczuk.pracadomowa_tydzien5_2.service;

import it.marczuk.pracadomowa_tydzien5_2.entity.Weather;

public interface WeatherService {

    Weather getWeather(String city);
}
