package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class LibroRepository {
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository() {
        //agregar libros por defecto
        listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random HouseGrupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "Addison- Wesley", 2008, "Joshua Bloch"));
        listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "PrenticeHall", 2017, "Robert C. Martin"));
        listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "Addison- Wesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    public Libro buscarPorId(int id){
        for(Libro libro : listaLibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for(Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }
    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setIsbn(lib.getIsbn());
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setEditorial(lib.getEditorial());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());

        listaLibros.add(idPosicion, libro1);
        return libro1;

    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if(libro != null){
            listaLibros.remove(libro);
        }
    }

    public int totalLibros(){
        return listaLibros.size();
    }

    public int contarPorAnio(int anio) {
        int contador = 0;
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() == anio) {
                contador++;
            }
        }
        return contador;
    }

    public Libro buscarPorAutor(String autor) {
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        return null;
    }

    public Libro buscarLibroAntiguo() {
        Libro antiguo = listaLibros.get(0);
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() < antiguo.getFechaPublicacion()) {
                antiguo = libro;
            }
        }
        return antiguo;
    }

    public Libro buscarLibroNuevo() {
        Libro nuevo = listaLibros.get(0);
        for (Libro libro : listaLibros) {
            if (libro.getFechaPublicacion() > nuevo.getFechaPublicacion()) {
                nuevo = libro;
            }
        }
        return nuevo;
    }

    public List<Libro> obtenerLibrosOrdenadosPorFecha() {
        List<Libro> copia = new ArrayList<>(listaLibros); // para no modificar la lista original
        copia.sort(Comparator.comparingInt(Libro::getFechaPublicacion));
        return copia;
    }




}
