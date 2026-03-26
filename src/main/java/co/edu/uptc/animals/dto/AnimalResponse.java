package co.edu.uptc.animals.dto;

import java.util.List;

import co.edu.uptc.animals.model.Animal;

public class AnimalResponse {

    private String container;
    private List<Animal> data;

    public AnimalResponse(String container, List<Animal> data) {
        this.container = container;
        this.data = data;
    }

    public String getContainer() { return container; }
    public List<Animal> getData() { return data; }
}