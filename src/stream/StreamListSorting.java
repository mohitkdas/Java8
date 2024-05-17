package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamListSorting {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        // ascending order
        fruits.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println("****************");

        fruits.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println("****************");

        fruits.stream()
                .sorted()
                .forEach(System.out::println);

        // descending order
        System.out.println();
        fruits.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println();
        fruits.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .forEach(System.out::println);

        // sort employees by salary in ascending order
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10, "Ramesh", 30, 40000));
        employees.add(new Employee(20, "Santosh", 29, 35000));
        employees.add(new Employee(30, "Sanjay", 30, 45000));
        employees.add(new Employee(40, "Pramod", 29, 50000));

        System.out.println();
        employees.stream()
                .sorted(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return (int) (o1.getSalary() - o2.getSalary());
                    }
                }).forEach(System.out::println);

        System.out.println("------------------Ascending");
        employees.stream()
                .sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))
                .forEach(System.out::println);
        System.out.println("---------------------Descending");
        employees.stream()
                .sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()))
                .forEach(System.out::println);

        System.out.println();
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(System.out::println); // ascending order
        System.out.println();
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println); // descending order

        System.out.println();
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println); // ascending order

        System.out.println();
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println); // ascending order
    }
}

class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}