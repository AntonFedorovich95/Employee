package pro.sky.Employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employees[] employees = new Employees[5];
    static int counter = 0;

    @Override
    public Employees addEmployee(String firstName, String lastName) {
        if (counter <= employees.length) {
            for (int i = 0; i < employees.length; i++) {
                if ((employees[i] != null) && employmentVerification(firstName, lastName, employees[i])) {
                    throw new EmployeeExistsException();
                }
            }
        } else {
            throw new EmployeeIsFullException();
        }
        int i = 0;
        while (employees[i] != null) {
            i++;
        }
        employees[i] = new Employees(firstName, lastName);
        counter++;
        return employees[i];
    }

    @Override
    public Employees removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && employmentVerification(firstName, lastName, employees[i])) {
                employees[i] = null;
                counter--;
                return new Employees(firstName, lastName);
            }
        }
        throw new NotFound();
    }

    @Override
    public Employees findEmployee(String firstName, String lastName) {
        boolean isFound = false;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && employmentVerification(firstName, lastName, employees[i])) {
                isFound = true;
            }
        }
        if (isFound == true) {
            return new Employees(firstName, lastName);
        } else throw new NotFound();
    }

    public boolean employmentVerification(String firstName, String lastName, Employees employees) {
        boolean answer = false;
        if (employees.getFirstName().equals(firstName) &&
                employees.getLastName().equals(lastName)) {
            answer = true;
        }
        return answer;
    }
}

