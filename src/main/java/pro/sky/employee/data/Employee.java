package pro.sky.employee.data;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final Integer idDepartment;
    private final Integer salary;

    public Employee(String lastName, String firstName, Integer idDepartment, Integer salary) {
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

    @Override
    public String toString() {
        return ("Фамилия: " + lastName
                + ", Имя: " + firstName
                + ", Департамент: " + idDepartment
                + ", Зарплата: " + salary + " rub/month");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
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