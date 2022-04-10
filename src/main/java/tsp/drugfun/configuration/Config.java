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
    private final FileConfiguration data;
    private final File drugsFile;
    private final String fileType;
    private final boolean multi;
    private final int overdoseExpire;
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
        for (String id : data.getConfigurationSection("overdose.effects").getKeys(false)) {
            String path = "overdose.effects." + id;
            result.add(PotionData.builder()
                    .id(id)
                    .type(data.getString(path + ".type"))
                    .duration(data.getInt(path + ".duration") * 20)
                    .amplifier(data.getInt(path + ".amplifier") - 1)
                    .required(data.getInt(path + ".required"))
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
