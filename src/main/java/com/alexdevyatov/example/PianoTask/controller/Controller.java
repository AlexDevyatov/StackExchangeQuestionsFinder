package com.alexdevyatov.example.PianoTask.controller;

import com.alexdevyatov.example.PianoTask.model.Question;
import com.alexdevyatov.example.PianoTask.service.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Алексей on 12.01.2018.
 */
@RestController
public class Controller {

    @Autowired
    private DataLoader loader;

    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }

    @RequestMapping("/search")
    public List<Question> search(@RequestParam(value="keyword", defaultValue="java") String keyword) {
        return loader.getQuestionsList(keyword);
    }
}
