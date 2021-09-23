package main;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Hibernate {
    public static void main(String[] args) {

        try {
            Session session = Util.getSessionFactory().openSession();
            // Begin a unit of work
            session.beginTransaction();

            // Insert user
            Employee employee = new Employee("hieu","2000", "0342217180", "hieu@gmail.com", "fresher", 1);
            session.save(employee);

            //update
//            Employee uEmp = session.load(Employee.class, 1);
//            uEmp.setEmail("hieuCT");
//            session.save(uEmp);

            //list
            List<Employee> list = session.createCriteria(Employee.class).list();
            System.out.println(list.toString());

            //delete
            Employee emp = session.load(Employee.class, 1);
            session.delete(emp);

            System.out.println(list.toString());
            // Commit the current resource transaction, writing any unflushed changes to the database.
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
