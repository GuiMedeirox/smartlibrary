package com.smartlib.smartlib.service;

import com.smartlib.smartlib.model.Livro;
import com.smartlib.smartlib.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    public ResponseEntity<Livro> buscarLivroPorId(Long id){
        return livroRepository.findById(id).map(livro -> ResponseEntity.ok().body(livro)).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Livro> editarLivro(Long id, Livro livro){

        return livroRepository.findById(id).map(livroToUpdate -> {
            livroToUpdate.setGenero(livro.getGenero());
            livroToUpdate.setNome(livro.getNome());
            livroToUpdate.setSessao(livro.getSessao());
            Livro livroUpdated = livroRepository.save(livroToUpdate);
            return ResponseEntity.ok().body(livroUpdated);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> excluirLivro(Long id){
        return livroRepository.findById(id).map(livroToDelete -> {
           livroRepository.deleteById(id);
           return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Livro> buscarLivroPeloNome(String nome){
        return livroRepository.findByName(nome)
                .map(livro -> ResponseEntity.ok().body(livro))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Livro> buscarLivroPorSessao(String sessao){
        return livroRepository.findBySection(sessao);
    }

    public List<Livro> buscarLivroQueComecaCom(String parte){
        return livroRepository.findByNomeStartingWith(parte);
    }
    public List<Livro> buscarLivroQueComecaComESessao(String parte, String sessao){
        return livroRepository.findByNomeStartingWithAndSessao(parte, sessao);
    }

    public List<Livro> buscarLivroOrdenadoPorSessao(String sessao){
        return livroRepository.findByNomeStartingWithOrderBySessao(sessao);
    }

    public List<Livro> buscarListaDeId(Long id){
        return livroRepository.findByIdLessThanEqual(id);
    }


}