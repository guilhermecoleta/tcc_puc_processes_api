package puc.tcc.processes.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ProcessesApiException extends Exception {

    private final HttpStatus statusCode;
    private final String field;
    private final String message;

}
