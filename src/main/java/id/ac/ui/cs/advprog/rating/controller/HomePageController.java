package id.ac.ui.cs.advprog.rating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class HomePageController {
    String createHTML = "userCreate";
    @GetMapping("")
    @ResponseBody
    public String createUserPage() {
        return "<h1>Test Rating Page sudah berhasil!</h1>";
    }
}