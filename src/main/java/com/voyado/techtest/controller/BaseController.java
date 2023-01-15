package com.voyado.techtest.controller;

import com.voyado.techtest.dto.ResultDto;
import com.voyado.techtest.dto.SearchDto;
import com.voyado.techtest.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
public class BaseController {
    @Autowired
    SearchService searchService;

    @GetMapping(value = "/")
    public String getIndex(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/dosearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDto doSearch(@RequestBody SearchDto searchObject) throws IOException {
        return searchService.search(searchObject);
    }
}
