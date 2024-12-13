package com.example.backend_cardapio.controller;

import com.example.backend_cardapio.food.Food;
import com.example.backend_cardapio.food.FoodRepository;
import com.example.backend_cardapio.food.FoodRequestDTO;
import com.example.backend_cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class foodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO Data) {
        Food FoodData = new Food(Data);
     repository.save(FoodData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
