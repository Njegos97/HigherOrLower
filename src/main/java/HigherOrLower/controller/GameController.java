package HigherOrLower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import HigherOrLower.entity.Game;

@Controller
@RequestMapping("/game")
@SessionAttributes("game")
public class GameController {

	@ModelAttribute("game")
	public Game game() {
		Game game = new Game();
		return  game;
	}
	
	@GetMapping
	public String newGame(@ModelAttribute("game") Game game) {
		game.setNumber(game.generateRandomNumber());
		game.setGameFinished(false);
		return "redirect:/game/show";
	}
	
	@PostMapping("/lower")
	public String lowerNumber(@ModelAttribute("game") Game game) {
	   game.isNumberLower();
		
	   return"redirect:/game/show";
	}
	
	@PostMapping("/higher")
	public String higherNumber(@ModelAttribute("game") Game game) {
		 game.isNumberHigher();
			
		 return"redirect:/game/show";
	
	}
	
	@GetMapping("/show")
	public String showGame() {
		return "game";
	}
	
	@GetMapping("/quitGame")
	public String quitGame(Model model) {
		return"redirect:/UserProfile";
	}
	
	
}
