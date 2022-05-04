package pro.sky.employee.data;

import java.util.Objects;

public class Employees {
    private String lastName;
    private String firstName;
    private Integer idDepartment;
    private Integer salary;

    public Employees(String lastName, String firstName, Integer idDepartment, Integer salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idDepartment = idDepartment;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public void setSalaryPerMonth(Integer salaryPerMonth) {
        this.salary = salaryPerMonth;
    }

    @Override
    public String toString() {
        return ("lastName: " + lastName
                + ", firstName: " + firstName
                + ", idDepartment: " + idDepartment
                + ", salary: " + salary + " rub/month");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employees employee = (Employees) obj;
        return lastName.equals(employee.lastName)
                && firstName.equals(employee.firstName)
                && idDepartment.equals(employee.idDepartment)
                && salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, idDepartment, salary);
    }

}