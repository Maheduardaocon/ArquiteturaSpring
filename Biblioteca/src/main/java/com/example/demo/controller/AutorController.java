package com.example.demo.controller;


package com.example.biblioteca.controller;

import com.example.biblioteca.model.Autor;
import com.example.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Integer id, @RequestBody Autor autorDetails) {
        Autor autor = autorRepository.findById(id).orElse(null);
        if (autor != null) {
            autor.setNome(autorDetails.getNome());
            autor.setPais(autorDetails.getPais());
            return autorRepository.save(autor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Integer id) {
        autorRepository.deleteById(id);
    }
}
