package com.smartlib.smartlib.controller;

import com.smartlib.smartlib.model.Autor;
import com.smartlib.smartlib.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping("/autor")
    @ResponseStatus(HttpStatus.CREATED)
    public Autor criarAutor(@RequestBody Autor autor){
        return autorService.criarAutor(autor);
    }

    @GetMapping("/autor")
    @ResponseStatus(HttpStatus.OK)
    public List<Autor> listarAutores(){
        return autorService.listarAutores();
    }

    @GetMapping("/autor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Autor> listarAutorPorId(@PathVariable(value = "id") Long id){
        return autorService.listarAutorById(id);
    }

//    @PutMapping("/autor/{id}")



}
