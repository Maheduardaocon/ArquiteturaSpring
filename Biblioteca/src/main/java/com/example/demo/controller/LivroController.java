package com.example.demo.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/autor/{nome}")
    public List<Livro> getLivrosByAutor(@PathVariable String nome) {
        return livroRepository.findByAutorNome(nome);
    }

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Integer id) {
        return livroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Integer id, @RequestBody Livro livroDetails) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null) {
            livro.setTitulo(livroDetails.getTitulo());
            livro.setAno(livroDetails.getAno());
            livro.setAutor(livroDetails.getAutor());
            livro.setCategoria(livroDetails.getCategoria());
            return livroRepository.save(livro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Integer id) {
        livroRepository.deleteById(id);
    }
}

	