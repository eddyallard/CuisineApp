package qc.colval.cuisineapp.rest_controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qc.colval.cuisineapp.mappers.EntityMapper;
import qc.colval.cuisineapp.models.dto.IngredientDTO;
import qc.colval.cuisineapp.models.entities.Ingredient;
import qc.colval.cuisineapp.services.IngredientService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ingredient")
@AllArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;
    private final EntityMapper<Ingredient, IngredientDTO> ingredientMapper;

    //GET MAPPING
    @GetMapping("/find")
    public List<Ingredient> findIngredientsByNameSubStr(@RequestBody Map<String, String> ingredientNameSubStr){
        return ingredientService.findByIngredientNameSubStr(ingredientNameSubStr.get("ingredientNameSubStr"));
    }
}
