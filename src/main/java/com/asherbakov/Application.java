package com.asherbakov;

import com.asherbakov.dao.CityDAO;
import com.asherbakov.dao.EmployeeDAO;
import com.asherbakov.dao.impl.CityDAOImpl;
import com.asherbakov.dao.impl.EmployeeDAOImpl;
import com.asherbakov.entity.City;
import com.asherbakov.entity.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) throws SQLException, IOException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        // 1. Создание(добавление) сущности Employee в таблицу
        CityDAO cityDAO = new CityDAOImpl();
        City city = cityDAO.getCityById(1L);
        employeeDAO.create(new Employee("Anthon", "Schvetsov", "Male", 21, city));

        // 2. Получение конкретного объекта Employee по id
        System.out.println("\nДля получения объекта базы данных, введите его id: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Long employeeId = Long.valueOf(reader.readLine());
        Optional<Employee> employee = Optional.ofNullable(employeeDAO.getEmployeeById(employeeId));
        if (employee.isPresent()) {
            System.out.println(employee.get());
        } else {
            System.out.println("Объект не найден.");
        }

        // 3. Получение списка всех объектов Employee из базы
        System.out.println("\nПолучение списка всех объектов Employee из базы:");
        List<Employee> employeeList = employeeDAO.getAllEmployee();
        if (!employeeList.isEmpty()) {
            employeeList.forEach(System.out::println);
        } else {
            System.out.println("Список пуст.");
        }

        //    4. Изменение конкретного объекта Employee в базе по id
        if (employee.isPresent()) {
            Employee e = employee.get();
            e.setAge(15);
            e.setCity(city);
            employeeDAO.changeEmployee(e);
        }

        // 5. Удаление конкретного объекта Employee из базы по id
        if (employee.isPresent()) {
            Employee e = employee.get();
            employeeDAO.removeEmployee(e);
        }

    }
}
