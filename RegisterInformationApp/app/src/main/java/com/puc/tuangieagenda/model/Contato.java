package com.puc.tuangieagenda.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contato {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "age")
    public String age;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "cpf")
    public String cpf;
    @ColumnInfo(name = "phone")
    public String phone;

    public Contato(String name, String age, String email, String cpf, String phone) {
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
