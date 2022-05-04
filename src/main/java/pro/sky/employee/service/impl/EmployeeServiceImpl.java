package pro.sky.employee.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeExistsException;
import pro.sky.employee.data.Employees;
import pro.sky.employee.exceptions.NotFound;
import pro.sky.employee.service.EmployeeService;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employees> employees = new HashMap<>();

    @Override
    public Employees addEmployee(String lastName, String firstName, Integer idDepartment, Integer salaryPerMonth) {
        String s = lastName + ' ' + firstName;
        if (employees.containsKey(s)) {
            throw new EmployeeExistsException();
        }
        employees.put(s, new Employees(lastName, firstName, idDepartment, salaryPerMonth));
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

    @Override
    public String sumSalary() {
        return "Общая сумма затрат на зарплату в месяц: "
                + String.valueOf(employees.values().stream()
                .mapToInt(e -> e.getSalary())
                .sum())
                + " руб.";
    }

    @Override
    public List<Employees> maxSalaryInDepartment(Integer idDepartment) {
        Integer maxSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .map(e -> e.getSalary())
                .max(Integer::compare).get();
        List<Employees> listOfEmployeesWithMaxSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .filter(e -> e.getSalary().equals(maxSalary)).collect(Collectors.toList());
        return listOfEmployeesWithMaxSalary;
    }

    @Override
    public List<Employees> minSalaryInDepartment(Integer idDepartment) {
        Integer minSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .map(e -> e.getSalary())
                .min(Integer::compare).get();
        List<Employees> listOfEmployeesWithMinSalary = employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .filter(e -> e.getSalary().equals(minSalary)).collect(Collectors.toList());
        return listOfEmployeesWithMinSalary;
    }

    @Override
    public List<Employees> findEmployeesIdDepartment(Integer idDepartment) {
        return employees.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employees> sortListEmployeesDepartment() {
        return employees.values().stream()
                .sorted(Comparator.comparing(Employees::getIdDepartment)).collect(Collectors.toList());
    }

}