package sff.day13_lecture.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import sff.day13_lecture.model.Employee;

@Repository
public class EmployeeRepo {

    final String dirPath = "/Users/DarylLee/Desktop/data";
    final String filename = "employee.txt";

    private List<Employee> employees;

    public EmployeeRepo() throws ParseException{
        if (employees == null) {
            employees = new ArrayList<>();
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = df.parse("1999-02-12");
        Employee employee = new Employee("Fred", "Perry", "fred@gmail.com", "81234567", 2000, dt, 123456);
        employees.add(employee);

        df = new SimpleDateFormat("yyyy-MM-dd");
        dt = df.parse("2000-01-20");
        employee = new Employee("Tom", "Cruise", "tom@gmail.com", "81234567", 10000, dt, 223456);
        employees.add(employee);


    }

    public List<Employee> findAll() {

        return employees;
        
    }

    public Boolean save(Employee employee) throws FileNotFoundException {
        Boolean result = employees.add(employee);

        File f = new File(dirPath + File.separator + filename);
        OutputStream os = new FileOutputStream(f, true);
        PrintWriter pw = new PrintWriter(os);
        pw.println(employee.toString());
        pw.flush();
        pw.close();

        return result;
        
    }

    public Boolean delete(Employee employee) {

        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);

        if (employeeIndex>=0) {
            employees.remove(employeeIndex);
            result = true;
        }
        
        return result;
    }

    public Employee findByEmailID(String email) {
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(email)).findFirst().get();

        return emp;
        
    }

    public Boolean updateEmployee(Employee em) {
        Employee emp = employees.stream().filter(e -> e.getEmail().equals(em.getEmail())).findFirst().get();

        int employeeIndex = employees.indexOf(emp);

        if (employeeIndex >= 0) {
            employees.remove(employeeIndex);
        }

        employees.add(em);

        return true;
    }


    
}
