package com.example.bibliotecaduoc.services;

import com.example.bibliotecaduoc.model.Prestamo;
import com.example.bibliotecaduoc.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.obtenerPrestamos();
    }

    public Prestamo guardarPrestamo(Prestamo prestamo) {
        return prestamoRepository.guardarPrestamo(prestamo);
    }

    public Prestamo buscarPrestamoPorId(int id) {
        return prestamoRepository.obtenerPrestamoPorId(id);
    }

    public Prestamo actualizarPrestamo(Prestamo prestamo) {
        return prestamoRepository.actualizarPrestamo(prestamo);
    }

    public void eliminarPrestamo(int id) {
        prestamoRepository.eliminar(id);
    }
}
