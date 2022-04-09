package tsp.drugfun.implementation.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OverdoseData {

    private List<PotionData> effects;

}
