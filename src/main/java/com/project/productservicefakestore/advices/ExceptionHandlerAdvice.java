//package com.project.productservicefakestore.advices;
//
//import com.project.productservicefakestore.dtos.ExceptionDto;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.io.FileNotFoundException;
//
//@ControllerAdvice
//public class ExceptionHandlerAdvice {
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException ex){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(ex.getMessage());
//        exceptionDto.setCode(400);
//        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<ExceptionDto> handleArithmeticException(RuntimeException ex){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(ex.getMessage());
//        exceptionDto.setCode(403);
//        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler(FileNotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleFileNotFoundExceptionException(FileNotFoundException ex){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(ex.getMessage());
//        exceptionDto.setCode(200);
//        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionDto> handleException(Exception e){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setMessage(e.getMessage());
//        exceptionDto.setCode(402);
//        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
//    }
//}
