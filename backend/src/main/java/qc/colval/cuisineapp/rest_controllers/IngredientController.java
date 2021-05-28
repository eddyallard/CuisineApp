package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.IngredientDTO;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.services.IngredientService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/api/ingredient")
@AllArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;
    private final EntityMapper<Ingredient, IngredientDTO> ingredientMapper;

    //GET MAPPING
    @GetMapping("/find")
    public ResponseEntity<List<IngredientDTO>> findIngredientsByNameSubStr(@RequestParam String ingredientNameSubStr){
        return ResponseEntity.ok(ingredientService.findByIngredientNameSubStr(ingredientNameSubStr)
                .stream().map(ingredientMapper::entityToDto)
                .collect(Collectors.toList()));
    }

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> findAllIngredients(){
        return ResponseEntity.ok(ingredientService.findAll()
                .stream().map(ingredientMapper::entityToDto)
                .collect(Collectors.toList()));
    }
}
