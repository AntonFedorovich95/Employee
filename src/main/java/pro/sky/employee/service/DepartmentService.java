package pro.sky.employee.service;

import pro.sky.employee.data.Employee;

import java.util.List;

public interface DepartmentService {
    Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryMonth);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    List<Employee> getEmployeeList();

    String sumSalary();

    List<Employee> maxSalaryInDepartment(Integer idDepartment);

    List<Employee> minSalaryInDepartment(Integer idDepartment);

    List<Employee> findEmployeesIdDepartment(Integer idDepartment);

    List<Employee> sortListEmployeesDepartment();
}
