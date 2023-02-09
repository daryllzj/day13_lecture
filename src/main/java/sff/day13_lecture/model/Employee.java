package sff.day13_lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {

    @NotEmpty (message = "mandatory field")
    @Size (min = 2, max = 100, message = "between 2-100 characters")
    private String firstname;

    @NotEmpty (message = "mandatory field")
    @Size (min = 2, max = 100, message = "between 2-100 characters")
    private String lastname;

    @Email (message = "invalid")
    @NotEmpty (message = "mandatory field")
    private String email;

    @Pattern (regexp = "(8|9)[0-9]{7}", message = "invalid phone format")
    private String phoneNo;

    @Min(value = 1500, message = "min salary is $1500")
    @Max (value = 10500, message = "max salary is $10500")
    private Integer salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthday;

    @Digits(fraction = 0, integer = 6, message = "postal code format: 123456")
    private Integer postalCode;

    
    public Employee() {
    }

    

    public Employee(
            @NotEmpty(message = "mandatory field") @Size(min = 2, max = 100, message = "between 2-100 characters") String firstname,
            @NotEmpty(message = "mandatory field") @Size(min = 2, max = 100, message = "between 2-100 characters") String lastname,
            @Email(message = "invalid") @NotEmpty(message = "mandatory field") String email,
            @Pattern(regexp = "(\\8|9)[0-9]{8}", message = "invalid phone format") String phoneNo,
            @Min(value = 1500, message = "min salary is $1500") @Max(value = 10500, message = "max salary is $10500") Integer salary,
            @Past Date birthday,
            @Digits(fraction = 0, integer = 6, message = "postal code format: 123456") Integer postalCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.birthday = birthday;
        this.postalCode = postalCode;
    }





    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Integer getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (phoneNo == null) {
            if (other.phoneNo != null)
                return false;
        } else if (!phoneNo.equals(other.phoneNo))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (birthday == null) {
            if (other.birthday != null)
                return false;
        } else if (!birthday.equals(other.birthday))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNo="
                + phoneNo + ", salary=" + salary + ", birthday=" + birthday + ", postalCode=" + postalCode + "]";
    }

    

    

    
}
