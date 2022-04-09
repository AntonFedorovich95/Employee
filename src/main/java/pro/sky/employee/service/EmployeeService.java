package pro.sky.employee.service;

import pro.sky.employee.data.Employees;

import java.util.List;

public interface EmployeeService {
    Employees addEmployee(String firstName, String lastName);
    Employees removeEmployee(String firstName, String lastName);
    Employees findEmployee(String firstName, String lastName);
    List<Employees> getEmployeeList();
}
