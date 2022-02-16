/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huy.dto;

/**
 *
 * @author Fangl
 */
public class Employee extends Information {

    private String birthdate;
    private String role;
    private String sex;
    private String password;

    public Employee(String birthdate, String role, String sex, String password, String id, String name) {
        super(id, name);
        this.birthdate = birthdate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" + "Id=" + super.id + "Name=" + super.getName() + "birthdate=" + birthdate + ", role=" + role + ", sex=" + sex + ", password=" + password + '}';
    }

}
