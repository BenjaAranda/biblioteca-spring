package com.example.bibliotecaduoc.services;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public Libro buscarPorIsbn(String isbn) {
        return libroRepository.buscarPorIsbn(isbn);
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }

    public Libro getLibro(int id){
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "Libro eliminado";
    }

    public int totalLibrosV1(){
        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }

    public int contarPorAnio(int anio){
        return libroRepository.contarPorAnio(anio);
    }

    public Libro buscarPorAutor(String autor){
        return libroRepository.buscarPorAutor(autor);
    }

    public Libro buscarLibroAntiguo(){
        return (libroRepository.buscarLibroAntiguo());
    }

    public Libro buscarLibroNuevo(){
        return (libroRepository.buscarLibroNuevo());
    }

    public List<Libro> ordenarCronologicamente(){
        return libroRepository.obtenerLibrosOrdenadosPorFecha();
    }
}
