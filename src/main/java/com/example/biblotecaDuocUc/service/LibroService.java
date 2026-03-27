package com.example.biblotecaDuocUc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblotecaDuocUc.model.Libro;
import com.example.biblotecaDuocUc.repository.LibroRepository;

@Service
public class LibroService {

      @Autowired  
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obteneLibros();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id){
        return libroRepository.buscaPorId(id);
    }

    public Libro uppdateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "producto eliminado";
    }

    public int totalLibrosV1(){
        return libroRepository.obteneLibros().size();
    }

    public int totalLibrosV2(){
        return libroRepository.totalLibros();
    }

    public String buscarPorIsbn(String isbn){
        Libro libro = libroRepository.buscaPorIsbn(isbn);
        if (libro != null) {
            return "Libro encontrado: " + libro.getTitulo() + " por " + libro.getAutor();
        } else {
            return "Libro no encontrado con ISBN: " + isbn;
        }
    }
}
