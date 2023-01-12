package com.example.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//core katmanı bir tek burada değil başka projelerde de kullanıcak 
//ortak olan kodlar core a taşınır 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="personel")
public class Personel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Email
@NotBlank
@Column(name = "email")
@NotNull
private String email;


@NotNull
@NotBlank
@Column(name = "password")
private String password;

@NotNull
@NotBlank
@Column(name = "userName")
private String userName;

@Column
private String role;

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}
