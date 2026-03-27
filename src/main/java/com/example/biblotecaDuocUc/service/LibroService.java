package com.example.biblotecaDuocUc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.biblotecaDuocUc.model.Libro;
import com.example.biblotecaDuocUc.repository.LibroRepository;

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
}
