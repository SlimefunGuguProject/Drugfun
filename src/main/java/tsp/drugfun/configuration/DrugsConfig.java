package tsp.drugfun.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import tsp.drugfun.implementation.data.DrugData;
import tsp.drugfun.implementation.data.RecipeData;
import tsp.drugfun.implementation.data.TriggerData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DrugsConfig {
    
    private final File file;
    private final List<DrugData> drugs = new ArrayList<>();

    public DrugsConfig(File file) {
        this.file = file;
    }

    public List<DrugData> getDrugs() {
        return drugs;
    }

    public void loadYaml(boolean multi) {
        File[] files = new File[]{file};
        if (multi) {
            files = file.listFiles();
        }

        if (files == null) {
            return;
        }

        drugs.clear();
        for (File f : files) {
            drugs.addAll(loadYaml(f));
        }
    }

    public static List<DrugData> loadYaml(File file) {
        List<DrugData> result = new ArrayList<>();
        FileConfiguration data = YamlConfiguration.loadConfiguration(file);
        for (String id : data.getKeys(false)) {
            result.add(DrugData.builder()
                    .id(id)
                    .name(data.getString(id + ".name"))
                    .material(data.getString(id + ".material"))
                    .lore(data.getStringList(id + ".lore"))

                    .recipeData(RecipeData.builder()
                            .type(data.getString(id + ".recipe.type"))
                            .output(data.getInt(id + ".recipe.output"))
                            .ingredients(data.getStringList(id + ".recipe.ingredients"))
                            .build()
                    )

                    .triggerData(TriggerData.builder()
                            .amount(data.getInt(id + ".amount"))
                            .effects(data.getStringList(id + ".trigger.effects"))
                            .build())
                    .build());
        }

        return result;
    }

}
