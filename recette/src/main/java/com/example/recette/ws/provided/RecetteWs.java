package com.example.recette.ws.provided;

import com.example.recette.bean.Recette;
import com.example.recette.service.facade.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/recette")
public class RecetteWs {
    @Autowired
    private RecetteService recetteService;

    @GetMapping("/ref/{ref}")
    public Recette findByRef(@PathVariable String ref) {
        return recetteService.findByRef(ref);
    }

    @GetMapping("/user-id/{user-id}")
    public List<Recette> findByUserId(@PathVariable int userId) {
        return recetteService.findByUserId(userId);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return recetteService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Recette> findAll() {
        return recetteService.findAll();
    }

    @PostMapping("/")
    public int save(Recette recette) {
        return recetteService.save(recette);
    }

    @PutMapping("/")
    public int update(Recette recette) {
        return recetteService.update(recette);
    }
}
