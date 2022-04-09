package tsp.drugfun.configuration;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.potion.PotionEffect;
import tsp.drugfun.Drugfun;
import tsp.drugfun.implementation.data.PotionData;
import tsp.drugfun.util.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Config {

    private final File file;
    private FileConfiguration data;
    private File drugsFile;
    private String fileType;
    private boolean multi;
    private int overdoseExpire;
    private final Map<PotionEffect, Integer> overdoseEffects;

    public Config(File file) {
        this.file = file;
        this.data = YamlConfiguration.loadConfiguration(file);
        this.drugsFile = new File(Drugfun.getInstance().getDataFolder(), data.getString("drugsFile"));
        this.fileType = data.getString("fileType");
        this.multi = data.getBoolean("multiFile");
        this.overdoseExpire = data.getInt("overdose.expire");
        this.overdoseEffects = Utils.asOverdoseEffects(asPotionData());
    }

    public Map<PotionEffect, Integer> getOverdoseEffects() {
        return overdoseEffects;
    }

    private List<PotionData> asPotionData() {
        List<PotionData> result = new ArrayList<>();
        ConfigurationSection section = data.getConfigurationSection("overdose.effects");
        for (String entry : section.getKeys(false)) {
            result.add(PotionData.builder()
                    .id(entry)
                    .type(section.getString(entry + ".type"))
                    .duration(section.getInt(entry + ".duration"))
                    .amplifier(section.getInt(entry + ".amplifier"))
                    .required(section.getInt(entry + ".required"))
                    .build());
        }

        return result;
    }

    public int getOverdoseExpire() {
        return overdoseExpire;
    }

    public File getDrugsFile() {
        return drugsFile;
    }

    public String getFileType() {
        return fileType;
    }

    public boolean isMulti() {
        return multi;
    }

}
