package com.latin_hoteles.beans;

import com.latin_hoteles.entities.CostoEstadia;
import com.latin_hoteles.services.CostoEstadiaService;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class CostoEstadiaBean {

    private String tipoCuarto;
    private double costoPorNoche;

    private CostoEstadiaService costoEstadiaService = new CostoEstadiaService();

    // Método para crear un nuevo costo de estadía
    public void registrarCostoEstadia() {
        CostoEstadia costoEstadia = new CostoEstadia();
        costoEstadia.setTipoCuarto(tipoCuarto);
        costoEstadia.setCostoPorNoche(costoPorNoche);

        costoEstadiaService.crearCostoEstadia(costoEstadia);
    }

    // Método para obtener todos los costos de estadía (si lo necesitas en una tabla)
    public List<CostoEstadia> obtenerTodosLosCostosEstadia() {
        return costoEstadiaService.obtenerTodosLosCostosEstadia();
    }

    // Getters y Setters
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
