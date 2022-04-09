package tsp.drugfun.implementation.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecipeData {

    private String type;
    private int output;
    private List<String> ingredients;

}
