package com.kerellpnz.sarafan.controller;

import com.kerellpnz.sarafan.domain.User;
import com.kerellpnz.sarafan.repo.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @GetMapping("/user")
    @ResponseBody
    public User user(@AuthenticationPrincipal OAuth2User principal) {
        String id = principal.getAttribute("sub");
        User user = userDetailsRepo.findById(id).orElseGet(() -> {
            User newUser = new User();
            newUser.setId(id);
            newUser.setName(principal.getAttribute("name"));
            newUser.setEmail(principal.getAttribute("email"));
            newUser.setGender(principal.getAttribute("gender"));
            newUser.setLocale(principal.getAttribute("locale"));
            return newUser;
        });
        user.setLastVisit(LocalDateTime.now());
        return userDetailsRepo.save(user);
    }

//    @GetMapping
//    public String main(Model model, @AuthenticationPrincipal User user) {
//        HashMap<Object, Object> data = new HashMap<>();
//
//        data.put("profile", user);
//        data.put("messages", null);
//
//        model.addAttribute("frontendData", data);
//        return "index";
//    }
}
