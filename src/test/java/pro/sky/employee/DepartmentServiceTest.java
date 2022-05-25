package pro.sky.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employee.service.impl.DepartmentServiceImpl;
import pro.sky.employee.service.impl.EmployeeServiceImpl;

import static org.mockito.Mockito.when;
import static pro.sky.employee.EmployeeTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldCallWhenAddEmployee() {
        when(employeeServiceMock.addEmployee(
                LAST_NAME2,
                FIRST_NAME2,
                DEPARTMENT_ID2,
                MIN_SALARY)).
                thenReturn(DEFAULT_EMPLOYEE);
        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.addEmployee(
                        LAST_NAME2,
                        FIRST_NAME2,
                        DEPARTMENT_ID2,
                        MIN_SALARY));
    }

    @Test
    public void shouldCallWhenRemoveEmployee() {
        when(employeeServiceMock.removeEmployee(
                LAST_NAME1,
                FIRST_NAME1)).
                thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.removeEmployee(
                        LAST_NAME1,
                        FIRST_NAME1));
    }

    @Test
    public void shouldCallWhenFindEmployee() {
        when(employeeServiceMock.findEmployee(
                LAST_NAME2,
                FIRST_NAME2)).
                thenReturn(DEFAULT_EMPLOYEE);

        Assertions.assertEquals(DEFAULT_EMPLOYEE,
                out.findEmployee(
                        LAST_NAME2,
                        FIRST_NAME2));
    }

    @Test
    public void shouldCallWhenSumSalaryMethod() {
        when(employeeServiceMock.sumSalary()).thenReturn(String.valueOf(EMPLOYEE_LIST));

        Assertions.assertEquals(String.valueOf(EMPLOYEE_LIST), out.sumSalary());
    }

    @Test
    public void shouldEmployeeWithMinSalaryInDepartment() {
        when(employeeServiceMock.minSalaryInDepartment(DEPARTMENT_ID1)).
                thenReturn(EMPLOYEE_LIST);

        Assertions.assertEquals(EMPLOYEE_LIST,
                out.minSalaryInDepartment(DEPARTMENT_ID1));
    }

    @Test
    public void shouldCallEmployeeWithMaxSalaryInDepartment() {
        when(employeeServiceMock.maxSalaryInDepartment(DEPARTMENT_ID1)).
                thenReturn(EMPLOYEE_LIST);

        Assertions.assertEquals(EMPLOYEE_LIST,
                out.maxSalaryInDepartment(DEPARTMENT_ID1));
    }

    @Test
    public void shouldCallAllEmployeesByIdDepartment() {
        when(employeeServiceMock.findEmployeesIdDepartment(DEPARTMENT_ID1)).
                thenReturn(EMPLOYEE_LIST);

        Assertions.assertEquals(EMPLOYEE_LIST,
                out.findEmployeesIdDepartment(DEPARTMENT_ID1));
    }
}