package com.cef.testTask.service;

import com.cef.testTask.dto.OrdersDto;
import com.cef.testTask.dto.UsersDto;
import com.cef.testTask.model.OrdersModel;
import com.cef.testTask.model.UsersModel;
import com.cef.testTask.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public List<UsersDto> getAllUsersLocal() {
        return usersRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UsersDto convertEntityToDto(UsersModel usersModel) {
        UsersDto usersDto = new UsersDto();
        usersDto.setLogin(usersModel.getLogin());
        usersDto.setName(usersModel.getName());
        usersDto.setEmail(usersModel.getEmail());
        return usersDto;
    }


    public UsersModel registerUser(String login, String password, String name, String email,
                                   String fileName, String filePath) throws IOException {
        if (login == null || password == null)
            return null;
        else {
            if (usersRepository.findFirstByLogin(login).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setName(name);
            usersModel.setEmail(email);
            usersModel.setFileName(fileName);
            usersModel.setFilePath(filePath);
            return usersRepository.save(usersModel);
        }
    }

    public UsersModel authenticate(String login, String password) {
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
