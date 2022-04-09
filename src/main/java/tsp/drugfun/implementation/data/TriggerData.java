package tsp.drugfun.implementation.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TriggerData {

    private int amount; // Amount that the counter will be incremented by
    private List<String> effects;

}
