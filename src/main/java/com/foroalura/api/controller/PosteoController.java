package com.foroalura.api.controller;

import com.foroalura.api.modelo.Posteo;
import com.foroalura.api.dto.*;
import com.foroalura.api.repository.PosteoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {

    @Autowired
    private PosteoRepository posteoRepository;

    @PostMapping //Para mapear un request tipo POST
    public void publicarPosteo(@RequestBody @Valid DatosNuevoPosteo datosNuevoPosteo) {
        System.out.println(datosNuevoPosteo);
        posteoRepository.save(new Posteo(datosNuevoPosteo));
    }

    @GetMapping //Para mapear un request tipo GET
    public Page<DatosListPosteo> listPosteos(@PageableDefault(
            sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return posteoRepository.findAll(pageable).map(DatosListPosteo::new);
    }
    @GetMapping("/{id}")
    public Optional<DatosListPosteo> getPosteoPorId(@PathVariable Long id) {
        return posteoRepository.findById(id).map(DatosListPosteo::new);
    }

    @PutMapping
    @Transactional
    public void editarPosteo(@RequestBody @Valid DatosEditPosteo datosEditPosteo) {
        Posteo posteo = posteoRepository.getReferenceById(datosEditPosteo.id());
        posteo.actualizarDatos(datosEditPosteo);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarPost (@PathVariable Long id) {
        Posteo post = posteoRepository.getReferenceById(id);
        posteoRepository.delete(post);
    }
}

