package com.omanfootball.manager.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(
            ResourceNotFoundException.class
    )
    public ResponseEntity<?>
    handleNotFound(
            ResourceNotFoundException ex
    ){


        Map<String,String> response =
                new HashMap<>();


        response.put(
                "error",
                ex.getMessage()
        );


        return new ResponseEntity<>(
                response,
                HttpStatus.NOT_FOUND
        );


    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<?>
    handleGeneral(
            Exception ex
    ){


        Map<String,String> response =
                new HashMap<>();


        response.put(
                "error",
                ex.getMessage()
        );


        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST
        );


    }


}