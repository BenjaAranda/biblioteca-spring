package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);

    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id){
        return libroService.getLibro(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

    @GetMapping("/total")
    public int totalLibrosV2(){
        return libroService.totalLibrosV2();
    }

    @GetMapping("/isbn/{isbn}")
    public Libro buscarLibro(@PathVariable String isbn){
        return libroService.buscarPorIsbn(isbn);
    }

    @GetMapping("anio/{anio}")
    public int contarLibrosPorAnio(@PathVariable int anio){
        return libroService.contarPorAnio(anio);
    }

    @GetMapping("autor/{autor}")
    public Libro buscarLibroPorAutor(@PathVariable String autor){
        return libroService.buscarPorAutor(autor);
    }

    @GetMapping("/libroMasAntiguo")
    public Libro buscarLibroMasAntiguo(){
        return libroService.buscarLibroAntiguo();
    }

    @GetMapping("/libroMasNuevo")
    public Libro buscarLibroMasNuevo(){
        return libroService.buscarLibroNuevo();
    }

    @GetMapping("/librosOrdenadosCronologicamente")
    public List<Libro> buscarLibrosOrdenadosCronologicamente(){
        return libroService.ordenarCronologicamente();
    }

}
