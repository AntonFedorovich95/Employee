package pro.sky.employee.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.employee.service.EmployeeService;
import pro.sky.employee.data.Employees;

import java.util.List;

@RestController
@RequestMapping("/emploees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employees addEmployeeToList(@RequestParam("lastName") String lastName,
                                      @RequestParam("firstName") String firstName,
                                      @RequestParam("department") Integer idDepartment,
                                      @RequestParam("salary") Integer salaryPerMonth) {
        return employeeService.addEmployee(lastName, firstName, idDepartment, salaryPerMonth);
    }

    @GetMapping("/remove")
    public Employees removeEmployeeFromList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping("/find-employee")
    public Employees findEmployeeInList(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/employeelist")
    public List<Employees> printEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/sum-salary-month")
    public String sumSalary() {
        return employeeService.sumSalary();
    }

    @GetMapping("/departments/max-salary")
    public List<Employees> employeesMaxSalaryInDepartment(@RequestParam Integer idDepartment) {
        return employeeService.maxSalaryInDepartment(idDepartment);
    }

    @GetMapping("/departments/min-salary")
    public List<Employees> employeesMinSalaryInDepartment(@RequestParam Integer idDepartment) {
        return employeeService.minSalaryInDepartment(idDepartment);
    }

    @GetMapping(value = {"/departments/all",  "/departments/all/{idDepartment}"})
    public List<Employees> createListOfEmployees(@PathVariable(required = false) Integer idDepartment) {
        if (idDepartment != null) {
            return employeeService.findEmployeesIdDepartment(idDepartment);
        } else {
            return employeeService.sortListEmployeesDepartment();
        }
    }

}