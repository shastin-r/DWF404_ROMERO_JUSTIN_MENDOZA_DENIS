package com.latin_hoteles.services;

import com.latin_hoteles.entities.CostoEstadia;
import com.latin_hoteles.repositories.CostoEstadiaRepository;

import java.util.List;

public class CostoEstadiaService {

    private CostoEstadiaRepository costoEstadiaRepository = new CostoEstadiaRepository();

    // Método para crear un nuevo costo de estadía
    public void crearCostoEstadia(CostoEstadia costoEstadia) {
        costoEstadiaRepository.crearCostoEstadia(costoEstadia);
    }

    // Método para obtener un costo de estadía por su ID
    public CostoEstadia obtenerCostoEstadiaPorId(int id) {
        return costoEstadiaRepository.obtenerCostoEstadiaPorId(id);
    }

    // Método para obtener todos los costos de estadía
    public List<CostoEstadia> obtenerTodosLosCostosEstadia() {
        return costoEstadiaRepository.obtenerTodosLosCostosEstadia();
    }

    // Método para actualizar un costo de estadía existente
    public void actualizarCostoEstadia(CostoEstadia costoEstadia) {
        costoEstadiaRepository.actualizarCostoEstadia(costoEstadia);
    }

    // Método para eliminar un costo de estadía
    public void eliminarCostoEstadia(int id) {
        costoEstadiaRepository.eliminarCostoEstadia(id);
    }
}
