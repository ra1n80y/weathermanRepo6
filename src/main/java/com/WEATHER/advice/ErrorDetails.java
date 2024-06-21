package com.WEATHER.advice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class ErrorDetails
{
    public ErrorDetails(String statusCode,String msg,LocalDateTime when)
    {
        super();
        this.statusCode = statusCode;
        this.msg = msg;
        this.when = when;
    }

    private String statusCode;
    private String msg;
    private LocalDateTime when;

}
