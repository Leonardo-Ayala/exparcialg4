package com.example.exparcialg4.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name="productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproductos;

    @NotBlank(message = "El código del producto no puede estar vacío")
    private String codigo;

    @NotBlank(message = "El texto no puede estar vacio")
    @Size(max = 40, message = "el nombre NO puede poseer más de 40 caracteres")
    @Size(min = 2, message = "el nombre debe poseer más de 2 caracteres")
    @Pattern(regexp = "[a-zA-Z]",message = "solo se debe ingresar letras")
    private String nombre;

    @Digits(integer = 10, fraction = 4)
    @Positive
    private BigDecimal precio;

    @Digits(integer = 10, fraction = 0)
    @Positive
    private int stock;

    public int getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Lob
    private byte[] foto;

    @NotBlank(message = "La descripción del producto no puede estar vacio")
    @Size(max = 45,message = "La descripción del producto no puede tener más de 45 caracteres")
    private String descripcion;
}
