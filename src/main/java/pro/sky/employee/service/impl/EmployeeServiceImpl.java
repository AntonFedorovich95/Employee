package pro.sky.employee.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeExistsException;
import pro.sky.employee.exceptions.EmployeeIsFullException;
import pro.sky.employee.data.Employees;
import pro.sky.employee.exceptions.NotFound;
import pro.sky.employee.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employees> employees = new ArrayList<>();

    @Override
    public Employees addEmployee(String firstName, String lastName) {
        Employees employee = new Employees(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeExistsException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employees removeEmployee(String firstName, String lastName) {
        Employees employee = new Employees(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new NotFound();
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employees findEmployee(String firstName, String lastName) {
        Employees employee = new Employees(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new NotFound();
        }
        return employee;
    }

    @Override
    public List<Employees> getEmployeeList() {
        return employees;
    }
}