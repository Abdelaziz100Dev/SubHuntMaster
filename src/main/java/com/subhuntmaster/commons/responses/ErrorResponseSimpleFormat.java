package com.subhuntmaster.commons.responses;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ErrorResponseSimpleFormat {

    private  LocalDateTime timestamp;
    private  String message;
    private  List<String> details;
    private  String path;
    private String status;
}