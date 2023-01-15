package com.voyado.techtest.dto.googlesearch;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class GoogleSearchInformation {
    public BigInteger total_results;
    public String query_displayed;
}
