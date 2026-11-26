package argent_matter.gcyr.common.data;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.common.data.block.GCYRBlocks;
import argent_matter.gcyr.common.data.material.GCYRMaterials;

import com.gregtechceu.gtceu.api.registry.registrate.entry.TagPrefixEntry;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;

/**
 * Ore tag prefixes for GCYR's planet stones (previously registered in {@code IGTAddon#registerTagPrefixes}).
 */
public class GCYRTagPrefixes {

    public static final TagPrefixEntry ORE_LUNAR = REGISTRATE.oreTagPrefix("lunar", BlockTags.MINEABLE_WITH_PICKAXE)
            .lang("Lunar %s Ore")
            .registerOre(() -> GCYRBlocks.LUNAR_STONE.get().defaultBlockState(), null,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F),
                    GCYR.id("block/lunar_stone"))
            .register();

    public static final TagPrefixEntry ORE_MARTIAN = REGISTRATE.oreTagPrefix("martian", BlockTags.MINEABLE_WITH_PICKAXE)
            .lang("Martian %s Ore")
            .registerOre(() -> GCYRBlocks.MARTIAN_ROCK.get().defaultBlockState(), GCYRMaterials.MartianRockDust,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops()
                            .strength(3.0f, 3.0f),
                    GCYR.id("block/martian_rock"))
            .register();

    public static final TagPrefixEntry ORE_VENUSIAN = REGISTRATE
            .oreTagPrefix("venusian", BlockTags.MINEABLE_WITH_PICKAXE)
            .lang("Venusian %s Ore")
            .registerOre(() -> GCYRBlocks.VENUS_ROCK.get().defaultBlockState(), null,
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F),
                    GCYR.id("block/venusian_rock"))
            .register();

    public static final TagPrefixEntry ORE_MERCURIAN = REGISTRATE
            .oreTagPrefix("mercurian", BlockTags.MINEABLE_WITH_PICKAXE)
            .lang("Mercurian %s Ore")
            .registerOre(() -> GCYRBlocks.MERCURY_ROCK.get().defaultBlockState(), null,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F),
                    GCYR.id("block/mercurian_rock"))
            .register();

    // NOTE: upstream uses the mercurian rock as the proximian ore base; kept as-is.
    public static final TagPrefixEntry ORE_PROXIMIAN = REGISTRATE
            .oreTagPrefix("proximian", BlockTags.MINEABLE_WITH_PICKAXE)
            .lang("Proximian %s Ore")
            .registerOre(() -> GCYRBlocks.MERCURY_ROCK.get().defaultBlockState(), null,
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops()
                            .strength(3.0F, 3.0F),
                    GCYR.id("block/proximian_stone"))
            .register();

    public static void init() {}
}
