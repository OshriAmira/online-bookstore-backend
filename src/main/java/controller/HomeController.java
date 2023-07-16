package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "This is the root URL";
    }

    @GetMapping("/home")
    public String home() {
        return "You are in home page";
    }
}
