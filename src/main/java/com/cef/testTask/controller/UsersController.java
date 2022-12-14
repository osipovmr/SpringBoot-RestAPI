package com.cef.testTask.controller;

import com.cef.testTask.dto.UsersDto;
import com.cef.testTask.model.UsersModel;
import com.cef.testTask.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
public class UsersController {

    public static String uploadDirectory = "/Users/vulpix_li/Downloads/SpringBoot-RestAPI/src/main/resources/static";

    @Autowired
    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    private final AuthService authService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }

    @GetMapping("/usersLocation")
    public @ResponseBody List<UsersDto> getUsersLocal () {
        System.out.println(usersService.getAllUsersLocal());
        return usersService.getAllUsersLocal();
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UsersModel());
        return "register_form";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UsersModel());
        return "login_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerRequest") @Valid UsersModel usersModel, BindingResult bindingResult,
                           @RequestParam("file") MultipartFile file) throws IOException {
        if (bindingResult.hasErrors())
            return "register_form";
        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(uploadDirectory, fileName).toString();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
        stream.write(file.getBytes());
        stream.close();
        UsersModel registeredUser = usersService.registerUser(usersModel.getLogin(), usersModel.getPassword(),
                usersModel.getName(), usersModel.getEmail(), fileName, filePath);
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersModel usersModel, Model model){
        UsersModel authenticated = usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
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
