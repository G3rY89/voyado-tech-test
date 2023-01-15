package com.voyado.techtest.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class ResultDto {
    public BigInteger resultCount;
    public String query;
}
