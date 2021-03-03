package it.marczuk.pracadomowa_tydzien5_1.controller;

import it.marczuk.pracadomowa_tydzien5_1.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public String getAllGames(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        return "index";
    }
}
