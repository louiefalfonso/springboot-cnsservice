package demo.cnsservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BookingAPIException extends RuntimeException {

    @Getter
    private HttpStatus status;
    private String message;

    public BookingAPIException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public BookingAPIException(String message, HttpStatus status, String message1){
        super(message);
        this.status = status;
        this.message = message1;
    }

    @Override
    public  String getMessage(){
        return  message;
    }

}
