package com.voyado.techtest.util;

import com.google.gson.Gson;
import com.voyado.techtest.dto.ResultDto;
import com.voyado.techtest.dto.SearchDto;
import com.voyado.techtest.dto.googlesearch.GoogleSearchResponseDto;
import com.voyado.techtest.dto.yahoosearch.YahooSearchResponseDto;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URL;

public class SerpApiUtil {
    @Value("${serpapi.apikey}")
    private String serpApiKey;

    @Autowired
    OkHttpClient client;

    @Autowired
    Gson gson;

    public ResultDto sendReq(SearchDto searchDto) throws IOException {
        String requestUrl = makeRequestURL(searchDto);
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("Content-Type", "application/json")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String responseBody = response.body().string();
        ResultDto result = new ResultDto();
        switch (searchDto.searchEngine){
            case "google":
                GoogleSearchResponseDto gResponse = gson.fromJson(responseBody, GoogleSearchResponseDto.class);
                result.resultCount = gResponse.googleSearchInformation.total_results;
                result.query = gResponse.googleSearchInformation.query_displayed;
                break;
            case "yahoo":
                YahooSearchResponseDto yResponse = gson.fromJson(responseBody, YahooSearchResponseDto.class);
                result.resultCount = yResponse.yahooSearchInformation.total_results;
                result.query = yResponse.yahooSearchInformation.query_displayed;
                break;
        }
        return result;
    }

    public String makeRequestURL(SearchDto searchDto){
        URL url = new HttpUrl.Builder()
                .scheme("https")
                .host("serpapi.com")
                .addPathSegments("search.json")
                .addQueryParameter("engine", searchDto.searchEngine)
                .addQueryParameter("api_key", serpApiKey)
                .build().url();
        switch (searchDto.searchEngine){
            case "google":
                return UriComponentsBuilder.fromUriString(url.toString()).queryParam("q", searchDto.searchQuery).toUriString();
            case "yahoo":
                return UriComponentsBuilder.fromUriString(url.toString()).queryParam("p", searchDto.searchQuery).toUriString();
        }
        return null;
    }
}
