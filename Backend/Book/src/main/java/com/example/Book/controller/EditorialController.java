package com.example.Book.controller;

import com.example.Book.domain.Editorial;
import com.example.Book.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class EditorialController{
        @Autowired
        private final EditorialService editorialService;

        public EditorialController(EditorialService editorialService) {
            this.editorialService = editorialService;
        }

        /*
        Entradas: url
        Salidas: lista de editoriales
        Función: Obtiene una lista de todas las editoriales que hay
         */
        @GetMapping("/public/editorial")
        public List<Editorial> list() {
            return editorialService.listAll();
        }

        /*
        Entradas: url
        Salidas: Respuesta de que si encontro la editorial
        Función: Obtiene una editorial dado un id
         */
        @GetMapping("/public/editorial/{id}")
        public ResponseEntity<Editorial> get(@PathVariable Integer id) {
            try {
                Editorial editorial = editorialService.get(id);

                return new ResponseEntity<Editorial>(editorial, HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<Editorial>(HttpStatus.NOT_FOUND);
            }
        }

        /*
        Entradas: url
        Salidas:--
        Función: Crea una editorial
         */
        @PostMapping("/admin/editorial")
        public void add(@RequestBody Editorial editorial) {
            editorialService.save(editorial);
        }

        /*
        Entradas:url
        Salidas: Repuesta de que si puedo realizar el metodo
        Función: Actualizar la información de una editorial dado un id
         */
        @PutMapping("/admin/editorial/{id}")
        public ResponseEntity<?> update(@RequestBody Editorial editorial, @PathVariable Integer id) {
            try {
                Editorial existingEditorial = editorialService.get(id);
                System.out.println(existingEditorial);
                editorialService.save(editorial);

                return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        /*
        Entradas: url
        Salidas:--
        Función: Eliminar una editorial según su id
         */
        @DeleteMapping("/admin/editorial/{id}")
        public void delete(@PathVariable Integer id) {
            editorialService.delete(id);
        }
}

