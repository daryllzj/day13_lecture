package sff.day13_lecture.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sff.day13_lecture.model.Employee;
import sff.day13_lecture.repository.EmployeeRepo;

@Controller
@RequestMapping(path = {"/employees"})
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping (path = {"/home"})
    public String employeeListpage(Model model) {
        List<Employee> employees = employeeRepo.findAll();

        model.addAttribute("employees", employees);

        return "employeeList";
        
    }

    @GetMapping(path = {"/addnew"})
    public String addPage(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employeeadd";
        
    }

    @PostMapping (path = {"/addnew"})
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employeeForm, BindingResult binding, Model model ) throws FileNotFoundException {

        if (binding.hasErrors()) {
            return "employeeadd";
        }

        Boolean result = false;
        result = employeeRepo.save(employeeForm);

        return "redirect:/employees/home";
    }

    @GetMapping ("/deleteEmployee/{email}")
    public String deleteEmployee(@PathVariable("email") String email) {

        Employee emp = employeeRepo.findByEmailID(email);

        Boolean bResult = employeeRepo.delete(emp);

        return "redirect:/employees/home";
        
    }

    @GetMapping ("/updateEmployee/{email}")
    public String updateEmployee(@PathVariable("email") String email, Model model) {

        Employee emp = employeeRepo.findByEmailID(email);

        model.addAttribute("employee", emp);

        return "employeeupdate";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployeeProcess(@ModelAttribute("employee") Employee employee, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "employeeupdate";
        }
        
        employeeRepo.updateEmployee(employee);
        return "redirect:/employees/home";
    }

}
