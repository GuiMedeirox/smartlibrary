package com.smartlib.smartlib.repository;

import com.smartlib.smartlib.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l WHERE l.nome = :nome")
    Optional<Livro> findByName(@Param("nome") String nome);
    @Query("SELECT c FROM Livro c WHERE c.sessao = :sessao")
    List<Livro> findBySection(@Param("sessao") String sessao);

    List<Livro>  findByNomeStartingWith(String nome);
    List<Livro>  findByNomeStartingWithAndSessao(String nome, String sessao);
    List<Livro>  findByNomeStartingWithOrderBySessao(String sessao);
    List<Livro>  findByIdLessThanEqual(Long id);
}