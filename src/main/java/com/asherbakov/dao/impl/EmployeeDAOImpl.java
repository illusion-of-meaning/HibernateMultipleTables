package com.asherbakov.dao.impl;

import com.asherbakov.HibernateManager;
import com.asherbakov.dao.EmployeeDAO;
import com.asherbakov.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee employee) {
        try(Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return HibernateManager.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = (List<Employee>) HibernateManager.getSessionFactory().openSession().createQuery("FROM Employee").list();
        return employeeList;
    }

    @Override
    public void changeEmployee(Employee employee) {
        try(Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void removeEmployee(Employee employee) {
        try(Session session = HibernateManager.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
