package com.reactive.programming.streamChaining.data;

import com.reactive.programming.streamChaining.beans.Employee;
import com.reactive.programming.streamChaining.beans.Project;

import java.util.Date;;
import java.util.List;

public class Personnel {

        public List<Employee> getAllEmployees() {

            List<Employee> employeeList = List.of(
                    new Employee(1, "Bruce", "Roshanravan", new Date(1968, 5, 10), 76000,
                            List.of(
                                    new Project(1, "Lockheed Martin", new Date(2021, 10, 1), 600000),
                                    new Project(2, "Raytheon", new Date(2020, 12, 15), 1300000)
                            )),
                    new Employee(2, "Laleh", "Yazzi", new Date(1975, 5, 15), 56000,
                            List.of(
                                    new Project(1, "Lockheed Martin", new Date(2021, 10, 1), 65000),
                                    new Project(3, "Air Bus", new Date(2021, 8, 15), 55000)
                            )),
                   new Employee(3, "Areya", "Roshanravan", new Date(1968, 5, 10), 65000,
                            List.of(
                                    new Project(1, "Boeing", new Date(2020, 10, 1), 1300000),
                                    new Project(3, "BAE Systems", new Date(2021, 8, 15), 1300000)
                            )),
                    new Employee(4, "Atoosa", "Roshanravan", new Date(1968, 5, 10), 55000,
                            List.of(
                                    new Project(2, "Northrop Grumman", new Date(2020, 12, 15), 1300000),
                                    new Project(3, "Air Bus", new Date(2021, 8, 15), 1300000)
                            ))
            );

            return employeeList;
        }



}
