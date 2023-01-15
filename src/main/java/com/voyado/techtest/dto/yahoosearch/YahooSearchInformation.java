package com.voyado.techtest.dto.yahoosearch;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class YahooSearchInformation {
    public BigInteger total_results;
    public String query_displayed;
}
