package com.latin_hoteles.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "registro_estadia")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre_cliente;

    @Temporal(TemporalType.DATE)
    private Date fecha_ini_estadia;

    @Temporal(TemporalType.DATE)
    private Date fecha_fin_estadia;

    private String tipo_cuarto;

    private double costo_total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public Date getFecha_ini_estadia() {
        return fecha_ini_estadia;
    }

    public void setFecha_ini_estadia(Date fecha_ini_estadia) {
        this.fecha_ini_estadia = fecha_ini_estadia;
    }

    public Date getFecha_fin_estadia() {
        return fecha_fin_estadia;
    }

    public void setFecha_fin_estadia(Date fecha_fin_estadia) {
        this.fecha_fin_estadia = fecha_fin_estadia;
    }

    public String getTipo_cuarto() {
        return tipo_cuarto;
    }

    public void setTipo_cuarto(String tipo_cuarto) {
        this.tipo_cuarto = tipo_cuarto;
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }
}
