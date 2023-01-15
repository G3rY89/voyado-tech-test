package com.voyado.techtest.service;

import com.voyado.techtest.dto.ResultDto;
import com.voyado.techtest.dto.SearchDto;
import com.voyado.techtest.util.SerpApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    SerpApiUtil serpApiUtil;
    @Override
    public ResultDto search(SearchDto searchDto) throws IOException {
        return serpApiUtil.sendReq(searchDto);
    }
}
