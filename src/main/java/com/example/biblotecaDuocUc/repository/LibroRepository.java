package com.example.biblotecaDuocUc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.biblotecaDuocUc.model.Libro;



@Repository
public class LibroRepository {
     //Arreglo que guardara todos los libros 
    private List<Libro> listaLibros  = new ArrayList<>();
    
    //Metodo que retorna todos los libros
    public List<Libro> obteneLibros(){
        return listaLibros;
    }

    //buscar un libro por ID
    public Libro buscaPorId (int id){

        for (Libro libro : listaLibros){
            if (libro.getId()== id) {
                return libro;
            }
        }
        return null;
    }

    //Buscar un libro por su isbn
    public Libro buscaPorIsbn(String isbn){ 
        for(Libro libro : listaLibros){
            if (libro.getIsbn().equals(isbn)) {
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
        
        for(int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;            
            }

        }
        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;

        
    }


    public void eliminar(int id){

        //ALTERNATIVA 1
        Libro libro = buscaPorId(id);
        if (libro != null){
            listaLibros.remove(libro);
        }
        //ALTERNATIVA 2
        int idPosicion = 0;
        for(int i = 0 ; i < listaLibros.size(); i++){
            if(listaLibros.get(i).getId() == id){
                idPosicion = i;
                break;
            }
        }

        if(idPosicion > 0){
            listaLibros.remove(idPosicion);
        }
        // otra alternativa
        listaLibros.removeIf(x -> x.getId() == id);

    }

}
