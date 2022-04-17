package pro.sky.employee.service;

import pro.sky.employee.data.Employees;

import java.util.List;

public interface EmployeeService {
    Employees addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth);

    Employees removeEmployee(String lastName, String firstName);

    Employees findEmployee(String lastName, String firstName);

    List<Employees> getEmployeeList();

    String sumSalary();
    List<Employees> maxSalaryInDepartment(Integer idDepartment);

    List<Employees> findEmployeesIdDepartment(Integer idDepartment);

    List<Employees> minSalaryInDepartment(Integer idDepartment);

    List<Employees> sortListEmployeesDepartment();
}