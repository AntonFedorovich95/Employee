package pro.sky.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeIsFullException extends RuntimeException {
    public EmployeeIsFullException() {
        super();
    }
}