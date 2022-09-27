package com.example.Empresa.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "nit")
    private String nit;

    @ManyToOne
    @JoinColumn(name = "Usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "MovimientosEmpresa")
    private MovimientosEmpresa MovimientosEmpresa;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public com.example.Empresa.Entity.MovimientosEmpresa getMovimientosEmpresa() {
        return MovimientosEmpresa;
    }

    public void setMovimientosEmpresa(com.example.Empresa.Entity.MovimientosEmpresa movimientosEmpresa) {
        MovimientosEmpresa = movimientosEmpresa;
    }
}
// ahora, continuar con la conexion de supabase y pusman para aplicar el el CRUD
// cargar el proyecto en el repositorio de gitHub