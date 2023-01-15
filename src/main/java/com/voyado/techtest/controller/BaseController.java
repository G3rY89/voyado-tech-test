package com.voyado.techtest.controller;

import com.voyado.techtest.dto.ResultDto;
import com.voyado.techtest.dto.SearchDto;
import com.voyado.techtest.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

    @ApiOperation(value = "With the given search object do a search against the requested search engines and returns " +
            "the given query and the corresponding result count.")
    @ResponseBody
    @RequestMapping(value = "/dosearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDto doSearch(@ApiParam(value = "An object containing the search criteria.")
                                  @RequestBody SearchDto searchObject) throws IOException {
        return searchService.search(searchObject);
    }
}
