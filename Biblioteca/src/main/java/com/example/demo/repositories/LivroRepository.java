package com.example.demo.repositories;

import com.example.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findByAutorNome(String nome);
}