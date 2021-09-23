package model;

import lombok.*;

import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String fullName;
    @Column(name = "dob")
    private String birthDay;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "type")
    private String type;
    @Column(name = "count")
    private int count;

    public Employee(String fullName, String birthDay, String phone, String email, String type, int count) {
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.count = count;
    }
    public void showInformation(){
        System.out.println("ID: " + id + " | Full name: " + fullName + " | DOB: " + birthDay + " | Phone number: " + phone + " | Email: " + email + " | Type: " + type + " | Identity: " + count);
    }
}
