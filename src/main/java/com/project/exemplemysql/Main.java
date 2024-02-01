package com.project.exemplemysql;

import java.util.HashSet;
import java.util.Set;

public class Main {

   public static void main(String[] args) {
      
      Manager.createSessionFactory("exemplemysql/hibernate.properties", "exemplemysql/hibernate.cfg.xml");

      Employee refEmp1 = Manager.addEmployee("Employee 1", "Aes", 1000);
      Employee refEmp2 = Manager.addEmployee("Employee 2", "Bes", 2000);
      Employee refEmp3 = Manager.addEmployee("Employee 3", "Ces", 3000);
      Employee refEmp4 = Manager.addEmployee("Employee 4", "Des", 4000);

      Contact refCon1 = Manager.addContact("Contact 1", "ves@a.com");
      Contact refCon2 = Manager.addContact("Contact 2", "wes@a.com");
      Manager.addContact("Contact 3", "xes@ga.com");
      Manager.addContact("Contact 4", "yes@ga.com");
      Contact refCon5 = Manager.addContact("Contact 5", "zes@ga.com");

      Manager.updateEmployee(refEmp1.getEmployeeId(), refEmp1.getFirstName(), refEmp1.getLastName(), 55);

      Set<Employee> employeesEmp1 = new HashSet<Employee>();
      employeesEmp1.add(refEmp2);
      employeesEmp1.add(refEmp3);
      Manager.updateContact(refCon1.getContactId(), refCon1.getName(), refCon1.getEmail(), employeesEmp1);

      Set<Employee> employeesEmp2 = new HashSet<Employee>();
      employeesEmp2.add(refEmp1);
      employeesEmp2.add(refEmp2);
      Manager.updateContact(refCon2.getContactId(), refCon1.getName(), refCon1.getEmail(), employeesEmp2);

      Manager.delete(Employee.class, refEmp4.getEmployeeId());
      Manager.delete(Contact.class, refCon5.getContactId());

      System.out.println(Manager.collectionToString(Employee.class, Manager.listCollection(Employee.class)));
      System.out.println(Manager.collectionToString(Contact.class, Manager.listCollection(Contact.class)));

      // Exemple de crear i cridar un "Stored procedure" de MySQL
      System.out.println("Exemple named query:");
      Manager.queryUpdate("DROP PROCEDURE IF EXISTS GetAllFoos");
      Manager.queryUpdate("CREATE PROCEDURE GetAllFoos() BEGIN SELECT * FROM Contact; END");
      System.out.println(Manager.tableToString(Manager.queryTable("CALL GetAllFoos()")));
      // A MySQL: SHOW PROCEDURE STATUS WHERE Db = 'exemplemysql';

      Manager.close();
   }
}