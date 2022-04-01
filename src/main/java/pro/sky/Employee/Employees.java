package pro.sky.Employee;

import java.util.Objects;

public class Employees {
String firstName;
String lastName;

    public Employees(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employees emploees = (Employees) obj;
        return Objects.equals(firstName, emploees.firstName) && Objects.equals(lastName, emploees.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " " + " Фамилия: " + lastName + "   ";
    }

}
