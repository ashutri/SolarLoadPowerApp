package com.SolarProject.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SolarProject.Models.Login;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/v1/login")
public class LoginController {

	@GetMapping(path = "/basicauth")
    public Login basicauth() {
        return new Login("You are authenticated");
    }
}
