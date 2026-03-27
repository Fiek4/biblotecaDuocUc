package com.example.biblotecaDuocUc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.biblotecaDuocUc.model.Libro;
import com.example.biblotecaDuocUc.service.LibroService;

public class LibroController {
     @Autowired
    private LibroService libroService;

    @GetMapping

    public List<Libro> listaLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public Libro busaLibro(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public Libro actualizaLibro(@PathVariable int id , @RequestBody Libro libro){
        
        return libroService.uppdateLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);
    }

}
