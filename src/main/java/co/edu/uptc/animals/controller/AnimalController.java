package co.edu.uptc.animals.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.animals.model.Animal;
import co.edu.uptc.animals.service.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Value("${CONTAINER_NAME:unknown}")
    private String containerName;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // GET ALL
    @GetMapping
    public Map<String, Object> getAllAnimals() {
        List<Animal> animals = animalService.getAll();

        Map<String, Object> response = new HashMap<>();
        response.put("container", "Soy el contenedor " + containerName);
        response.put("data", animals);

        return response;
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalService.getById(id);
    }

    // CREATE
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.save(animal);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id);
        return animalService.save(animal);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.delete(id);
    }

    // WHOAMI (opcional, pero útil)
    @GetMapping("/whoami")
    public String whoAmI() {
        return "Soy el contenedor " + containerName;
    }
}