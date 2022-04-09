package tsp.drugfun.implementation.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DrugData {

    private String id;
    private String name;
    private String material;
    private List<String> lore;

    private RecipeData recipeData;
    private TriggerData triggerData;

}
