package com.spring.test.ci.controller;

import com.spring.test.ci.dto.ResponseDto;
import com.spring.test.ci.entities.Author;
import com.spring.test.ci.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("/author/{name}")
    public ResponseDto<List<Author> > getAuthorByName(@PathVariable("name") String name) {
        List<Author> authors = authorService.findAuthorByName(name);
        ResponseDto<List<Author> > responseDto = new ResponseDto<>();
        responseDto.setSuccess(true);
        responseDto.setData(authors);
        return  responseDto;
    }

    @RequestMapping("/author2/{name}")
    public ResponseDto<List<Author> > getResponseDto(@PathVariable("name") String name) {
        List<Author> authors = authorService.findAuthorByName(name);
        ResponseDto<List<Author> > responseDto = new ResponseDto<>();
        responseDto.setSuccess(true);
        responseDto.setData(authors);
        return  responseDto;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return "hello, " + name;
    }
}
