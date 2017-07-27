package com.gft.GiFT.entities;

import com.gft.GiFT.utils.DateUtils;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorMessage {

    private String timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorMessage(HttpStatus status, String message) {
        this.timestamp = DateUtils.getDateTimeFormatterToString(new Date());
        this.status = status.value();
        this.error = status.name();
        this.message = message;
    }
}