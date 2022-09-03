package com.reactive.programming;

import com.reactive.programming.streamChaining.beans.Employee;
import com.reactive.programming.streamChaining.beans.Project;
import com.reactive.programming.streamChaining.data.Personnel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@SpringBootApplication
public class ReactiveProgrammingApplication {

	private static Employee updateSalary(Employee employee, double salary){
		employee.setSalary(salary);
		return employee;
	}
	public static void main(String[] args) {

		List<String> names = List.of("bruce", "Laleh", "Areya", "Atoosa");

		for (String name : names) {
			System.out.println(name);
		}

		names.stream().forEach(System.out::println);

		Personnel personnel = new Personnel();
		List<Employee> employeeList = personnel.getAllEmployees();
		employeeList.stream().forEach(employee -> System.out.println(employee.toString()));
/*
		List<String> employeeNames = employeeList.stream()
				.map(employee ->
					 employee.getFirstName() + " " + employee.getSurname()
				).collect(Collectors.toList());

		employeeNames.forEach(System.out::println);

		System.out.println("========================================================================");
		/*employeeList.stream()
				.filter(employee -> employee.getSalary() < 60000)
				.map(employee -> updateSalary(employee, 80000.0))
				.forEach(employee -> System.out.println(employee.toString()));
		System.out.println("========================================================================");

		employeeList.stream()
				//.filter(employee -> employee.getSalary() <60000)
				.map(employee -> updateSalary(employee, 80000.0))
				.collect(Collectors.toList())
				.forEach(employee -> System.out.println(employee.toString()));
		System.out.println("========================================================================");
		Employee firstEmployee = employeeList.stream()
				//.filter(employee -> employee.getSalary() <60000)
				.map(employee -> updateSalary(employee, 80000.0))
				.skip(2)
				.findFirst()
				.orElse(new Employee());

		System.out.println(firstEmployee.toString());

*/

		System.out.println("========================================================================");

		employeeList.stream()
				//.filter(employee -> employee.getSalary() <60000)
				.map(employee -> updateSalary(employee, 80000.0))
				.flatMap(employee -> employee.getProjectsWorkingOn().stream())
				.forEach(project -> System.out.println(project.toString()));
/*
		System.out.println("========================================================================");

		String projectNames = employeeList
				.stream()
				.skip(1)
				.limit(2)
				.flatMap(employee -> employee.getProjectsWorkingOn()
				.stream())

				.map(project -> project.getProjectName())
				.collect(Collectors.joining(","));

		System.out.println(projectNames);

/*
		System.out.println("========================================================================");

		 		Employee maxSalaryEmployee = employeeList
						.stream()
						.max(Comparator.comparing(Employee::getSalary))
						.orElseThrow(NoSuchElementException::new);


		System.out.println(maxSalaryEmployee.toString());


		System.out.println("========================================================================");

		double totalsalary = employeeList
				.stream()
				.map(employee -> employee.getSalary())
						.reduce(0.0, Double::sum);

		System.out.println("total Salary : " +totalsalary);
	}

	 */
	}

}
