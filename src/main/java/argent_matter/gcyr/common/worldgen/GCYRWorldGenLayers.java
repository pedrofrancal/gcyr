package argent_matter.gcyr.common.worldgen;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.common.data.block.GCYRBlocks;

import com.gregtechceu.gtceu.api.data.worldgen.IWorldGenLayer;
import com.gregtechceu.gtceu.api.data.worldgen.SimpleWorldGenLayer;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.Set;

import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;

public class GCYRWorldGenLayers {

    public static final Holder<IWorldGenLayer> MOON = register("moon",
            () -> new BlockMatchTest(GCYRBlocks.LUNAR_STONE.get()), "luna");
    public static final Holder<IWorldGenLayer> MARS = register("mars",
            () -> new BlockMatchTest(GCYRBlocks.MARTIAN_ROCK.get()), "mars");
    public static final Holder<IWorldGenLayer> MERCURY = register("mercury",
            () -> new BlockMatchTest(GCYRBlocks.MERCURY_ROCK.get()), "mercury");
    public static final Holder<IWorldGenLayer> VENUS = register("venus",
            () -> new BlockMatchTest(GCYRBlocks.VENUS_ROCK.get()), "venus");
    public static final Holder<IWorldGenLayer> PROXIMA_CENTAURI_B = register("proxima_centauri_b",
            () -> new BlockMatchTest(GCYRBlocks.PROXIMIAN_STONE.get()), "proxima_centauri_b");

    private static Holder<IWorldGenLayer> register(String name, IWorldGenLayer.RuleTestSupplier target,
                                                   String dimension) {
        Set<ResourceKey<Level>> levels = Set.of(ResourceKey.create(Registries.DIMENSION, GCYR.id(dimension)));
        return REGISTRATE.simple(name, GTRegistries.Keys.WORLD_GEN_LAYER,
                () -> new SimpleWorldGenLayer(GCYR.id(name), target, levels));
    }

    public static void init() {}
}
