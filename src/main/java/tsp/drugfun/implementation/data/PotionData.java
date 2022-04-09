package tsp.drugfun.implementation.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PotionData {

    private String id;
    private String type;
    private int duration;
    private int amplifier;
    private int required;

}
