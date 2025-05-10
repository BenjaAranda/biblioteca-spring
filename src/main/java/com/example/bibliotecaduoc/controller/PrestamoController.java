package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Prestamo;
import com.example.bibliotecaduoc.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> listar() {
        return prestamoService.listarPrestamos();
    }

    @PostMapping
    public Prestamo guardar(@RequestBody Prestamo prestamo) {
        return prestamoService.guardarPrestamo(prestamo);
    }

    @GetMapping("/{id}")
    public Prestamo obtenerPrestamoPorId(@PathVariable int id) {
        return prestamoService.buscarPrestamoPorId(id);
    }

    @PutMapping("/{id}")
    public Prestamo actualizarPrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        prestamo.setId_prestamo(id);
        return prestamoService.actualizarPrestamo(prestamo);
    }

    @DeleteMapping("/{id}")
    public String eliminarPrestamo(@PathVariable int id) {
        prestamoService.eliminarPrestamo(id);
        return "Prestamo eliminado";
    }
}
