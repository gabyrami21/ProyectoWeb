package com.example.Book.controller;


import com.example.Book.domain.Book;
import com.example.Book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*
    Entradas: url
    Salidas: lista de libros
    Función: lista todos los libros que hay
     */
    @GetMapping("/public/books")
    public List<Book> list() {
        return bookService.listAll();
    }

    /*
    Entradas: url
    Salidas: libro y Respuesta de encontrar el libro solicitado
    Función: Obtiene un libro dado un id
     */
    @GetMapping("/public/book/{id}")
    public ResponseEntity<Book> get(@PathVariable Integer id) {
        try {
            Book book = bookService.get(id);

            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    Entradas: url
    Salidas: --
    Función: Crear un nuevo libro
     */
    @PostMapping("/admin/books")
    public void add(@RequestBody Book book) {
        bookService.save(book);
    }

    /*
    Entradas: url
    Salidas: libro y Respuesta de encontrar el libro solicitado
    Función: Actualiza la información de un libro dado el id
     */
    @PutMapping("/books/{id}")
    public ResponseEntity<?> update(@RequestBody Book book,@PathVariable Integer id){
        try{
            // Si se encuentra una editorial con el id dado, se actualiza y el servidor devuelve el estado HTTP OK.
            Book existBook= bookService.get(id);
            existBook.setName(book.getName());
            existBook.setDescription(book.getDescription());
            existBook.setImageUrl(book.getImageUrl());
            existBook.setCantidad(book.getCantidad());
            existBook.setEditorialId(book.getEditorialId());
            bookService.save(existBook);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NoSuchElementException e) {
            //si no se encuentra ningun libro, se devuelve el estado HTTP Not found (404).
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }}

    /*
    Entradas:url
    Salidas:--
    Función: Eliminar un libro
     */
    @DeleteMapping("/admin/book/{id}")
    public void delete(@PathVariable Integer id) {
        bookService.delete(id);
    }

    /*
    Entradas: url
    Salidas: Respuesta de contenido sobre la entidad
    Función: Obtiene una lista de libros dada una editorial
     */
    @GetMapping("/books/editorial/{editorialId}")
    public ResponseEntity<List<Book>> listBooksByEditorialId(@PathVariable("editorialId") Integer id){
        List<Book> books = bookService.byEditorialId(id);
        if(books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }

    /*
    Entradas: url
    Salidas: Repuesta de contenido sobre la entidad
    Función: Filtra los libros por nombre
    */
    @Modifying
    @GetMapping("/book/{name}")
    public ResponseEntity<List<Book>> filterByName(@PathVariable("name") String name){
        List<Book> books= bookService.filterByName("%" + name + "%");
        if(books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(books);
    }
}

