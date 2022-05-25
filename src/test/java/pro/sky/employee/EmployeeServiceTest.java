package pro.sky.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.employee.data.Employee;
import pro.sky.employee.exceptions.EmployeeExistsException;
import pro.sky.employee.exceptions.InvalidNameException;
import pro.sky.employee.exceptions.NotFoundException;
import pro.sky.employee.service.impl.EmployeeServiceImpl;
import static pro.sky.employee.EmployeeTestConstants.*;

class EmployeeServiceTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void shouldThrowEmployeeWrongNameException() {
        Assertions.assertThrows(InvalidNameException.class,
                () -> out.addEmployee(
                        BAD_LAST_NAME,
                        FIRST_NAME1,
                        DEPARTMENT_ID1,
                        SALARY));
        Assertions.assertThrows(InvalidNameException.class,
                () -> out.addEmployee(
                        LAST_NAME1,
                        BAD_FIRST_NAME,
                        DEPARTMENT_ID2,
                        MIN_SALARY));
    }

    @Test
    public void shouldThrowEmployeeExistsException() {
        Assertions.assertThrows(EmployeeExistsException.class,
        () -> out.checkEmployeeExistsException(DEFAULT_EMPLOYEE_MAP,EMPLOYEE));
    }

    @Test
    public void shouldThrowEmployeeNotFoundException() {
        Assertions.assertThrows(NotFoundException.class,
                () -> out.checkEmployeeNotFoundException(DEFAULT_EMPLOYEE_MAP, FAKE_EMPLOYEE));
    }


    @Test
    public void shouldThrowNullPointerException() {
        Assertions.assertThrows(NullPointerException.class,
                () -> out.findEmployeesIdDepartment(null));
    }
    }