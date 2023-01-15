package com.voyado.techtest.service;

import com.voyado.techtest.dto.ResultDto;
import com.voyado.techtest.dto.SearchDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface SearchService {
    ResultDto search(SearchDto searchDto) throws IOException;
}
