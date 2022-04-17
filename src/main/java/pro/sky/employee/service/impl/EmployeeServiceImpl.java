package pro.sky.employee.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeExistsException;
import pro.sky.employee.data.Employees;
import pro.sky.employee.exceptions.NotFound;
import pro.sky.employee.service.EmployeeService;


import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employees> employees = new HashMap<>();

    @Override
    public Employees addEmployee(String lastName, String firstName) {
        String s = lastName + ' ' + firstName;
        if (employees.containsKey(s)) {
            throw new EmployeeExistsException();
        }
        employees.put(s, new Employees(lastName, firstName));
        return employees.get(s);
    }

    @Override
    public Employees removeEmployee(String lastName, String firstName) {
        String s = lastName + ' ' + firstName;
        if (!employees.containsKey(s)) {
            throw new NotFound();
        }
        Employees employee = employees.get(s);
        employees.remove(s);
        return employee;
    }

    @Override
    public Employees findEmployee(String lastName, String firstName) {
        String s = lastName + ' ' + firstName;
        if (!employees.containsKey(s)) {
            throw new NotFound();
        }
        return employees.get(s);
    }

    @Override
    public List<Employees> getEmployeeList() {
        List<Employees> employeeList = new ArrayList<>(employees.values());
        return employeeList;
    }
}