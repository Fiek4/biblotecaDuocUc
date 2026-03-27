package com.example.biblotecaDuocUc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    private String titulo;
    private int id;
    private String isbn;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}
