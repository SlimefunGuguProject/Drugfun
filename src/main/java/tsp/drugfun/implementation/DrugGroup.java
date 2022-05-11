package tsp.drugfun.implementation;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import tsp.drugfun.Drugfun;

public final class DrugGroup extends ItemGroup {

    public static final DrugGroup GROUP = new DrugGroup();

    private DrugGroup() {
        super(new NamespacedKey(Drugfun.getInstance(), "drugs"), new CustomItemStack(Material.WHEAT, "&2医药科技"));
        register(Drugfun.getInstance());
    }

}
