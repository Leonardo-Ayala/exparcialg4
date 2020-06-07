package com.example.exparcialg4.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpedidos")
    private int idpedidos;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date fecha;


    @ManyToOne
    @JoinColumn(name = "usuarios_idusuarios")
    private Usuarios Usuarios;

}
