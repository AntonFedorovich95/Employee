package pro.sky.employee.service;

import pro.sky.employee.data.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    List<Employee> getEmployeeList();

    String sumSalary();
    List<Employee> maxSalaryInDepartment(Integer idDepartment);

    List<Employee> findEmployeesIdDepartment(Integer idDepartment);

    List<Employee> minSalaryInDepartment(Integer idDepartment);

    List<Employee> sortListEmployeesDepartment();

    void checkEmployeeWrongNameException(String lastName, String firstName);

    void checkEmployeeExistsException(Map<String, Employee> employees, String s);

    void checkEmployeeNotFoundException(Map<String, Employee> employees, String s);
}