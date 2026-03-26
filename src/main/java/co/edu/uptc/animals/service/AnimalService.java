package co.edu.uptc.animals.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.animals.model.Animal;
import co.edu.uptc.animals.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<Animal> getAll() {
        return repository.findAll();
    }

    public Animal save(Animal animal) {
        return repository.save(animal);
    }

    public Animal getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}