package pro.sky.Employee;

public interface EmployeeService {
    Employees addEmployee(String firstName, String lastName);
    Employees removeEmployee(String firstName, String lastName);
    Employees findEmployee(String firstName, String lastName);
}

