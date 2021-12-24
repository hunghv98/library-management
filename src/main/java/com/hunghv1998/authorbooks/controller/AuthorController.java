package com.hunghv1998.authorbooks.controller;

import com.hunghv1998.authorbooks.entity.Author;
import com.hunghv1998.authorbooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/get")
    private Author getAuthorByEmail(@RequestParam(value = "email") String email) {
        return authorService.findByEmail(email);
    }

    @GetMapping("/betweenAge")
    private List<Author> getAuthorBetweenAge(@RequestParam(value = "age1") int age1,
                                             @RequestParam(value = "age2") int age2) {
        return authorService.findBetweenAge(age1, age2);
    }

    @GetMapping("/find")
    private Author getAuthorById(@RequestParam(value = "id") Long id) {
        return authorService.findAuthorById(id);
    }
}
