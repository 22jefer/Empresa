package com.example.Empresa.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    public enum tipoUsuario{
        administrador, operativo
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
/*
    @Column(name = "empresa")
    private Empresa empresa;


 */

    @Column(name = "tipoUsuario")
    private tipoUsuario tipoU;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
/*
    public Empresa getEmpresa() {
        return empresa;
    }



    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
 */


    public tipoUsuario getTipoU() {
        return tipoU;
    }

    public void setTipoU(tipoUsuario tipoU) {
        this.tipoU = tipoU;
    }

}
