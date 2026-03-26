package co.edu.uptc.animals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uptc.animals.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}