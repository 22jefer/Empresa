package com.example.Empresa.Entity;

import javax.persistence.*;

@Entity
@Table(name = "MovimientosEmpresa")
public class MovimientosEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "monto")
    private int monto;
/*
    private Usuario usuario;


 */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
/*
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

 */
}
