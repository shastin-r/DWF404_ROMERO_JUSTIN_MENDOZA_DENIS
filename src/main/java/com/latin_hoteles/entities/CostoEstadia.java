package com.latin_hoteles.entities;

import javax.persistence.*;

@Entity
@Table(name = "costos_estadia")
public class CostoEstadia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_cuarto", nullable = false)
    private String tipoCuarto;

    @Column(name = "costo_por_noche", nullable = false)
    private double costoPorNoche;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCuarto() {
        return tipoCuarto;
    }

    public void setTipoCuarto(String tipoCuarto) {
        this.tipoCuarto = tipoCuarto;
    }

    public double getCostoPorNoche() {
        return costoPorNoche;
    }

    public void setCostoPorNoche(double costoPorNoche) {
        this.costoPorNoche = costoPorNoche;
    }
}
