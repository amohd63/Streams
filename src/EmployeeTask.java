import models.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.Position;

public class EmployeeTask {
    private static Map<Position, Double> positionSalaryMap = new HashMap<>();
    public static void main(String[] args) {
        positionSalaryMap.put(Position.QA, 50000.0);
        positionSalaryMap.put(Position.BE, 60000.0);
        positionSalaryMap.put(Position.FE, 65000.0);
        positionSalaryMap.put(Position.HR, 55000.0);

        List<Employee> employeeList = new ArrayList<>();

        // Add employees to the list
        employeeList.add(new Employee(1L, "John", "Doe", "QA", LocalDate.of(1990, 5, 15)));
        employeeList.add(new Employee(2L, "Jane", "Smith", "BE", LocalDate.of(1992, 8, 25)));
        employeeList.add(new Employee(3L, "Alice", "Johnson", "FE", LocalDate.of(1988, 2, 10)));
        employeeList.add(new Employee(4L, "Bob", "Brown", "HR", LocalDate.of(1987, 10, 30)));

        // Task 1 - sol 1
        System.out.println("Task 1");
        System.out.println(
                employeeList.stream()
                        .map(Employee::getId)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
        );

        // Task 1 - sol 2
        System.out.println(
                employeeList.stream()
                        .map(employee -> {
                            return String.valueOf(employee.getId());
                        })
                        .collect(Collectors.joining(","))
        );

        // Task 2
        System.out.println("\nTask 2");
        Map<Long, Employee> employeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, employee -> employee));

        employeeMap.forEach((id, employee) -> System.out.println(id + " - " + employee.toString()));

        // Task 3
        System.out.println("\nTask 3");
        employeeList.forEach(EmployeeTask::printSalary);
    }

    public static void printSalary(Employee employee) {
        System.out.println("Employee [" + employee.getId() + "] with position [" +
                employee.getPosition().name() + "], salary is " + positionSalaryMap.get(employee.getPosition()));
    }
}
