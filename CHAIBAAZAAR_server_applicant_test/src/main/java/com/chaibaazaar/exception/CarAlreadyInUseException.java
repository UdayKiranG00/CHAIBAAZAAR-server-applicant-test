package com.chaibaazaar.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated ...")
public class CarAlreadyInUseException extends Exception{
	static final long serialVersionUID = -3387516993434229948L;


    public CarAlreadyInUseException(String message)
    {
        super(message);
    }
}
