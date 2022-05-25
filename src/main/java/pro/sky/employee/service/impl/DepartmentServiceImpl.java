package pro.sky.employee.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employee.data.Employee;
import pro.sky.employee.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employee;

    public DepartmentServiceImpl(EmployeeServiceImpl employee) {
        this.employee = employee;
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salary) {
        return employee.addEmployee(lastName, firstName, idDepartment, salary);
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        return employee.removeEmployee(lastName, firstName);
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        return employee.findEmployee(lastName, firstName);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employee.getEmployeeList();
    }

    @Override
    public String sumSalary() {
        return employee.sumSalary();
    }

    @Override
    public List<Employee> maxSalaryInDepartment(Integer idDepartment) {
        return employee.maxSalaryInDepartment(idDepartment);
    }

    @Override
    public List<Employee> minSalaryInDepartment(Integer idDepartment) {
        return employee.minSalaryInDepartment(idDepartment);
    }

    @Override
    public List<Employee> findEmployeesIdDepartment(Integer idDepartment) {
        return employee.findEmployeesIdDepartment(idDepartment);
    }

    @Override
    public List<Employee> sortListEmployeesDepartment() {
        return employee.sortListEmployeesDepartment();
    }
}
