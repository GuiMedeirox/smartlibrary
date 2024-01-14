package com.smartlib.smartlib.controller;

import com.smartlib.smartlib.model.Livro;
import com.smartlib.smartlib.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @PostMapping("/livros")
    @ResponseStatus(HttpStatus.CREATED)
    public Livro criarLivro(@RequestBody Livro livro){
        return livroService.criarLivro(livro);




    }

    @GetMapping("/livros")
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> listarLivros(){
        return livroService.listarLivros();
    };

    @GetMapping("/livros/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livro> listarLivroPorId(@PathVariable(value = "id") Long id ){
        return livroService.buscarLivroPorId(id);
    };

    @PutMapping("/livros/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livro> editarLivro(@PathVariable(value="id") Long id, @RequestBody Livro livro){
        return livroService.editarLivro(id, livro);
    }

    @DeleteMapping("/livros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> editarLivro(@PathVariable(value="id") Long id){
        return livroService.excluirLivro(id);
    }

    @GetMapping("/livros/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livro> buscarLivroPeloNome (@PathVariable(value = "nome") String nome){
        return livroService.buscarLivroPeloNome(nome);
    }

    @GetMapping("/livros/sessao")
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarLivroPelaSessao(@RequestParam String nome_sessao){
        return livroService.buscarLivroPorSessao(nome_sessao);
    }

    @GetMapping("/livros/nome")
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarLivroQueComecaCom(@RequestParam String comeco_livro){
        return livroService.buscarLivroQueComecaCom(comeco_livro);
    }

    @GetMapping("/livros/nome-sessao")
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarLivroQueComecaComESessao(@RequestParam String comeco_livro, String sessao){
        return livroService.buscarLivroQueComecaComESessao(comeco_livro, sessao);
    }

    @GetMapping("/livros/sessao-nome")
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarLivroOrdenadoPorSessao(@RequestParam String sessao){
        return livroService.buscarLivroOrdenadoPorSessao(sessao);
    }

    @GetMapping("/livros/id")
    @ResponseStatus(HttpStatus.OK)
    public List<Livro> buscarListaDeId(@RequestParam Long id){
        return livroService.buscarListaDeId(id);
    }


}