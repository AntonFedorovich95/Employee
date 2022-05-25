package pro.sky.employee.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employee.exceptions.EmployeeExistsException;
import pro.sky.employee.data.Employee;
import pro.sky.employee.exceptions.NotFoundException;
import pro.sky.employee.service.EmployeeService;
import pro.sky.employee.exceptions.InvalidNameException;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employee = new HashMap<>();

    @Override
    public Employee addEmployee(String lastName, String firstName, Integer idDepartment, Integer salary) {
        checkEmployeeWrongNameException(lastName, firstName);
        String s = StringUtils.capitalize(lastName) + ' ' + StringUtils.capitalize(firstName);
        checkEmployeeExistsException(employee, s);
        employee.put(s, new Employee(StringUtils.capitalize(lastName), StringUtils.capitalize(firstName), idDepartment, salary));
        return employee.get(s);
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        checkEmployeeWrongNameException(lastName, firstName);
        String s = StringUtils.capitalize(lastName) + ' ' + StringUtils.capitalize(firstName);
        checkEmployeeNotFoundException(employee, s);
        Employee employee = this.employee.get(s);
        this.employee.remove(s);
        return employee;
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        checkEmployeeWrongNameException(lastName, firstName);
        String s = StringUtils.capitalize(lastName) + ' ' + StringUtils.capitalize(firstName);
        checkEmployeeNotFoundException(employee,s);
        return employee.get(s);
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>(employee.values());
        return employeeList;
    }

    @Override
    public String sumSalary() {
        return "Общая сумма затрат на зарплату в месяц: "
                + String.valueOf(employee.values().stream()
                .mapToInt(e -> e.getSalary())
                .sum())
                + " руб.";
    }

    @Override
    public List<Employee> maxSalaryInDepartment(Integer idDepartment) {
        Integer maxSalary = employee.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .map(e -> e.getSalary())
                .max(Integer::compare).get();
        List<Employee> listOfEmployeesWithMaxSalary = employee.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .filter(e -> e.getSalary().equals(maxSalary)).collect(Collectors.toList());
        return listOfEmployeesWithMaxSalary;
    }

    @Override
    public List<Employee> minSalaryInDepartment(Integer idDepartment) {
        Integer minSalary = employee.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .map(e -> e.getSalary())
                .min(Integer::compare).get();
        List<Employee> listOfEmployeesWithMinSalary = employee.values().stream()
                .filter(e -> e.getIdDepartment().equals(idDepartment))
                .filter(e -> e.getSalary().equals(minSalary)).collect(Collectors.toList());
        return listOfEmployeesWithMinSalary;
    }

    @Override
    public List<Employee> findEmployeesIdDepartment(Integer idDepartment) {
        if (idDepartment == null) {
            throw new NullPointerException("При вызове метода не задан номер отдела");
        } else {
            return employee.values().stream()
                    .filter(e -> e.getIdDepartment().equals(idDepartment))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<Employee> sortListEmployeesDepartment() {
        return employee.values().stream()
                .sorted(Comparator.comparing(Employee::getIdDepartment)).collect(Collectors.toList());
    }

    @Override
    public void checkEmployeeWrongNameException(String lastName, String firstName) {
        if ((StringUtils.isAlpha(lastName) != true) || (StringUtils.isAlpha(firstName) != true)) {
            throw new InvalidNameException();
        }
    }

    @Override
    public void checkEmployeeExistsException(Map<String, Employee> employees, String s) {
        if (employees.containsKey(s)) {
            throw new EmployeeExistsException();
        }
    }

    @Override
    public void checkEmployeeNotFoundException(Map<String, Employee> employees, String s) {
        if (!employees.containsKey(s)) {
            throw new NotFoundException();
        }
    }

}