package com.latin_hoteles.beans;

import com.latin_hoteles.entities.Registro;
import com.latin_hoteles.services.RegistroService;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.sql.Date;
import java.util.List;

@Named
@RequestScoped
public class RegistroBean {

    private String nombreCliente;
    private Date fechaIniEstadia;
    private Date fechaFinEstadia;
    private String tipoCuarto;
    private double costoTotal;

    private RegistroService registroService = new RegistroService();

    // Método para ingresar un nuevo registro
    public void ingresarRegistro() {
        Registro registro = new Registro();
        registro.setNombre_cliente(nombreCliente);
        registro.setFechaIniEstadia(fechaIniEstadia);
        registro.setFechaFinEstadia(fechaFinEstadia);
        registro.setTipoCuarto(tipoCuarto);

        // Ingresar el registro y calcular el costo total
        registroService.ingresarRegistro(registro);
        this.costoTotal = registro.getCostoTotal(); // Para mostrar el costo en el registro
    }

    // Método para obtener todos los registros
    public List<Registro> obtenerTodosLosRegistros() {
        return registroService.obtenerTodosLosRegistros();
    }

    // Getters y Setters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaIniEstadia() {
        return fechaIniEstadia;
    }

    public void setFechaIniEstadia(Date fechaIniEstadia) {

        this.fechaIniEstadia = fechaIniEstadia;
    }

    public Date getFechaFinEstadia() {
        return fechaFinEstadia;
    }

    public void setFechaFinEstadia(Date fechaFinEstadia) {
        this.fechaFinEstadia = fechaFinEstadia;
    }

    public String getTipoCuarto() {
        return tipoCuarto;
    }

    public void setTipoCuarto(String tipoCuarto) {
        this.tipoCuarto = tipoCuarto;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
