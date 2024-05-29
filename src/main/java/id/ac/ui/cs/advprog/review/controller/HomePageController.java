package id.ac.ui.cs.advprog.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class HomePageController {
    String createHTML = "userCreate";
    @GetMapping("")
    @ResponseBody
    public String createUserPage() {
        return "HomePage";
    }
}