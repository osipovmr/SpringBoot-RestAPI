package com.cef.testTask.service;

import com.cef.testTask.dto.UserDto;
import com.cef.testTask.model.User;
import com.cef.testTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDto> getAllUsersLocal() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setLogin(user.getLogin());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }


    public User registerUser(String login, String password, String name, String email,
                             String fileName, String filePath) throws IOException {
        if (login == null || password == null)
            return null;
        else {
            if (userRepository.findFirstByLogin(login).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setName(name);
            user.setEmail(email);
            user.setFileName(fileName);
            user.setFilePath(filePath);
            return userRepository.save(user);
        }
    }

    public User authenticate(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
