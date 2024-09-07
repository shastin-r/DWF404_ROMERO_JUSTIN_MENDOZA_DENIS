package com.latin_hoteles.services;

import com.latin_hoteles.entities.Registro;
import com.latin_hoteles.repositories.RegistroRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RegistroService {
    private RegistroRepository registroRepository = new RegistroRepository();

    // Método para registrar una nueva visita con el costo calculado
    public void registrarVisita(Registro registro) {
        // Calcular el número de noches entre la fecha de entrada y la fecha de salida
        LocalDate fechaEntrada = registro.getFechaIniEstadia().toLocalDate();
        LocalDate fechaSalida = registro.getFechaFinEstadia().toLocalDate();
        long numeroNoches = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);

        // Obtener el costo por noche del tipo de habitación (puedes obtener esto de la base de datos)
        double costoPorNoche = obtenerCostoPorTipoDeHabitacion(registro.getTipoCuarto());

        // Calcular el costo total
        double costoTotal = numeroNoches * costoPorNoche;
        registro.setCostoTotal(costoTotal);

        // Ingresar Registro
        registroRepository.crearRegistro(registro);
    }

    // Método para obtener el costo de la habitación (de la tabla 'costos_estadia')
    public double obtenerCostoPorTipoDeHabitacion(String tipoCuarto) {

        switch (tipoCuarto) {
            case "Económica":
                return 50.00;
            case "Estándar":
                return 100.00;
            case "Lujo":
                return 200.00;
            default:
                return 0.00; // Si no se encuentra el tipo de cuarto
        }
    }

    public Registro obtenerRegistroPorId(int id) {
        return registroRepository.obtenerRegistroPorId(id);
    }

    public List<Registro> obtenerTodosLosRegistros() {
        return registroRepository.obtenerTodosLosRegistros();
    }

    public void actualizarRegistro(Registro registro) {
        registroRepository.actualizarRegistro(registro);
    }

    public void eliminarRegistro(int id) {
        registroRepository.eliminarRegistro(id);
    }
}
