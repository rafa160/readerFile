package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class UserService {

    @Autowired
    UserRepository repository;

    @RequestMapping({"/"," "})
    public String find(){
        return "Olá";
    }

    @Autowired
    @RequestMapping("/save")
    public String save() throws IOException {
        File file = new File("/home/rafa160/Downloads/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String infos = br.readLine();

        User user = new User();
        user.setId(infos.charAt(0));
        user.setCpf(infos.substring(1,12));
        repository.save(user);
        return "User: " + user.getId() + "cpf: " + user.getCpf();
    }
}
