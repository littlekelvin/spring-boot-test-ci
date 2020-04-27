package com.spring.test.ci.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseDto<T> {
    boolean success;
    String errMsg;
    T data;
}
