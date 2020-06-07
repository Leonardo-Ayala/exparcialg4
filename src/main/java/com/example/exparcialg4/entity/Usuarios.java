package com.example.exparcialg4.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idusuarios;

    private String rol;

    @NotBlank(message = "El texto no puede estar vacio")
    @Size(max = 40, message = "el nombre NO puede poseer más de 40 caracteres")
    @Size(min = 2, message = "el nombre debe poseer más de 2 caracteres")
    @Pattern(regexp = "[a-zA-Z]",message = "solo se debe ingresar letras")
    private String nombre;

    @NotBlank(message = "El texto no puede estar vacio")
    @Size(max = 40, message = "el nombre NO puede poseer más de 40 caracteres")
    @Size(min = 2, message = "el nombre debe poseer más de 2 caracteres")
    @Pattern(regexp = "[a-zA-Z]",message = "solo se debe ingresar letras")
    private String apellido;

    private int activo;

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @NotBlank(message = "el correo no debe ser vacio")
    @Pattern(regexp="[A-Za-z0-9._%-+]+@pucp+\\.edu+\\.pe", message="ingrese un correo válido")
    private String email;

    @NotBlank(message = "El DNI no debe ser vacío")
    @Pattern(regexp = "[0-9]{8}" ,message = "Solo se aceptan numeros")
    private String dni;

    @NotBlank(message = "El pass no debe ser vacío")
    @Size(max = 10, message = "maximo 10 caracteres")
    @Size(min = 8, message = "minimo 8 caracteres")
    @Pattern(regexp = "[0-9]{2,}" ,message = "Debe tener al menos 2 numeros")
    private String pwd;
}
