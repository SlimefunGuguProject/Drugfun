package tsp.drugfun.implementation.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResearchData {

    private String id;
    private int legacyId;
    private String name;
    private int cost;

}
