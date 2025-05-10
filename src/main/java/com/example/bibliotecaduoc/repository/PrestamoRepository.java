package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {
    List<Prestamo> prestamos = new ArrayList<>();
    private int contador_id = 1;

    public List<Prestamo> obtenerPrestamos() {
        return prestamos;
    }

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        prestamo.setId_prestamo(contador_id++);
        prestamos.add(prestamo);
        return prestamo;
    }

    public Prestamo obtenerPrestamoPorId(int id) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId_prestamo() == id) {
                return prestamo;
            }
        }
        return null;
    }

    public Prestamo actualizarPrestamo(Prestamo prestamo) {
        eliminar(prestamo.getId_prestamo());
        prestamos.add(prestamo);
        return prestamo;

    }

    public void eliminar(int id) {
        prestamos.removeIf(e -> e.getId_prestamo() == id);
    }
}
