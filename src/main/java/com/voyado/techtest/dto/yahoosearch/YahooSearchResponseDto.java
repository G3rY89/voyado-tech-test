package com.voyado.techtest.dto.yahoosearch;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class YahooSearchResponseDto {
    @SerializedName("search_information")
    public YahooSearchInformation yahooSearchInformation;
}
