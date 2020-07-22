package com.example.demo.service;

import com.example.demo.model.Benefits;
import com.example.demo.repository.BenefitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@RestController
public class BenefitsService {

    @Autowired
    BenefitsRepository repository;

    @RequestMapping("/save-benefits")
    public String save() throws IOException {
        File file = new File("/home/rafa160/Downloads/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String infos = br.readLine();

        Benefits benefits = new Benefits();
        benefits.setId(infos.charAt(0));
        benefits.setSalary(infos.substring(12,16));
        benefits.setFoodVoucher(infos.substring(16,19));
        benefits.setPassCard(infos.substring(19,22));
        benefits.setDay(infos.substring(22,24));
        benefits.setMonth(infos.substring(24,26));
        benefits.setYear(infos.substring(26,30));
        repository.save(benefits);
        return "saved";
    }

}
