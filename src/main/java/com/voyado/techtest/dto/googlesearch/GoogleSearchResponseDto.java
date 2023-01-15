package com.voyado.techtest.dto.googlesearch;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GoogleSearchResponseDto {
    @SerializedName("search_information")
    public GoogleSearchInformation googleSearchInformation;
}
