package practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {


    static Employee[] employees = {
            new Employee(1, "John", 10000),
            new Employee(2, "Jane", 12000),
            new Employee(3, "Bob", 15000)
    };


    static void main(String[] args) {

        Stream.of(employees).forEach(e -> System.out.println(e.name));

        Stream.of(employees).filter(e -> e.salary > 10000).forEach(e -> System.out.println(e.id + " " + e.name + " " + e.salary));

        List<Employee> empList = Arrays.asList(employees);
        System.out.println(empList.stream());

        Stream.of(employees[0], employees[1], employees[2]);
        Stream.Builder<Employee> builder = Stream.builder();
        builder.accept(employees[0]);
        builder.accept(employees[1]);
        builder.accept(employees[2]);
        builder.build().forEach(e -> System.out.println(e.id + " " + e.name + " " + e.salary));
    }

    static class Employee {
        int id;
        String name;
        double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
    }

}
