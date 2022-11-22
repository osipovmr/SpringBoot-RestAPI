package com.cef.testTask.controller;

import com.cef.testTask.dto.UserDto;
import com.cef.testTask.model.User;
import com.cef.testTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class UserController {

    public static String uploadDirectory = "/Users/vulpix_li/Downloads/SpringBoot-RestAPI/src/main/resources/static";

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usersLocation")
    public @ResponseBody List<UserDto> getUsersLocal () {
        System.out.println(userService.getAllUsersLocal());
        return userService.getAllUsersLocal();
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "register_form";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerRequest") @Valid User user, BindingResult bindingResult,
                           @RequestParam("file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors())
            return "register_form";
        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(uploadDirectory, fileName).toString();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        stream.write(file.getBytes());
        stream.close();
        User registeredUser = userService.registerUser(user.getLogin(), user.getPassword(),
                user.getName(), user.getEmail(), fileName, filePath);
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        User authenticated = userService.authenticate(user.getLogin(), user.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            model.addAttribute("userName", authenticated.getName());
            model.addAttribute("userEmail", authenticated.getEmail());
            model.addAttribute("userFileName", authenticated.getFileName());
            model.addAttribute("userFilePath", authenticated.getFilePath());

            return "personal_page";}
        else {
            return "error_page";
        }
    }
}
