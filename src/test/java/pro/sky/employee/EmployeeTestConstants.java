package pro.sky.employee;

import pro.sky.employee.data.Employee;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;


public class EmployeeTestConstants {
    public static final String FIRST_NAME1 = "Roman";
    public static final String FIRST_NAME2 = "Lev";
    public static final String LAST_NAME1 = "Petrov";
    public static final String LAST_NAME2 = "Smirnov";
    public static final String BAD_FIRST_NAME = "IVAN><<&";
    public static final String BAD_LAST_NAME = "IvaNNOv98";
    public static final int SALARY = 55000;
    public static final int MIN_SALARY = 25000;
    public static final int DEPARTMENT_ID1 = 1;
    public static final int DEPARTMENT_ID2 = 2;
    public static final int BAD_DEPARTMENT_ID = 3;
    public static final String EMPLOYEE = LAST_NAME1 + FIRST_NAME1;
    public static final String FAKE_EMPLOYEE = "Maksimov Denis";
    public static final Map<String, Employee> DEFAULT_EMPLOYEE_MAP = new HashMap<>((Map.of(
            EMPLOYEE,
            new Employee(
                    LAST_NAME1,
                    FIRST_NAME1,
                    DEPARTMENT_ID1,
                    SALARY))));
    public static final Employee DEFAULT_EMPLOYEE =
            new Employee(
                    LAST_NAME2,
                    FIRST_NAME2,
                    DEPARTMENT_ID2,
                    MIN_SALARY);
    public static final List<Employee> EMPLOYEE_LIST = new ArrayList<>(Arrays.asList(
            new Employee(LAST_NAME1, FIRST_NAME1, DEPARTMENT_ID1, SALARY),
            new Employee(LAST_NAME2, FIRST_NAME2, DEPARTMENT_ID1, MIN_SALARY)
    ));
}