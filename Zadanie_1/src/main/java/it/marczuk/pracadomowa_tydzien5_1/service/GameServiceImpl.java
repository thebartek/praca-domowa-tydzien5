package it.marczuk.pracadomowa_tydzien5_1.service;

import it.marczuk.pracadomowa_tydzien5_1.entity.Game;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Override
    public List<Game> getAllGames() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Game[] forObject = restTemplate.getForObject("https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15", Game[].class);
            List<Game> collect = Arrays.stream(forObject).collect(Collectors.toList());
            return collect;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
