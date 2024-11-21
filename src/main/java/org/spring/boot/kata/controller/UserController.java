package org.spring.boot.kata.controller;

import org.spring.boot.kata.model.User;
import org.spring.boot.kata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = this.userService.getAll();

        model.addAttribute("users", users);

        return "index";
    }

    @GetMapping("/user")
    public String userInfo(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "user";
    }

    @GetMapping("/save")
    public RedirectView save(@ModelAttribute User user) {
        userService.save(user);

        return new RedirectView("/");
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        User user = userService.get(id);

        model.addAttribute("user", user);

        return "user";
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam("id") int id) {
        userService.delete(id);

        return new RedirectView("/");
    }
}