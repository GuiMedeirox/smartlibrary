package com.smartlib.smartlib.service;

import com.smartlib.smartlib.model.Autor;
import com.smartlib.smartlib.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor criarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public ResponseEntity<Autor> listarAutorById(Long id) {
        return autorRepository.findById(id).map(autor -> ResponseEntity.ok().body(autor)).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Autor> editarAutor(Long id, Autor autor) {
        return autorRepository.findById(id).map(autorToUpdate -> {
            autorToUpdate.setNome(autor.getNome());
            Autor autorUpdated = autorRepository.save(autorToUpdate);
            return ResponseEntity.ok().body(autorUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> excluirAutor(Long id) {
        return autorRepository.findById(id).map(livroToDelete -> {
            autorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}