package argent_matter.gcyr.common.data.dimension;

import argent_matter.gcyr.GCYR;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import net.minecraft.core.Holder;

import com.gregtechceu.gtceu.api.data.DimensionMarker;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.world.level.block.Block;

import com.tterrag.registrate.util.entry.BlockEntry;

import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;

@SuppressWarnings("unused")
public class GCYRDimensionMarkers {

    static {
        REGISTRATE.resetCreativeModeTab();
    }

    public static final BlockEntry<Block> LUNA_MARKER = createMarker("luna");
    public static final BlockEntry<Block> MARS_MARKER = createMarker("mars");
    public static final BlockEntry<Block> MERCURY_MARKER = createMarker("mercury");
    public static final BlockEntry<Block> VENUS_MARKER = createMarker("venus");

    public static final Holder<DimensionMarker> LUNA = REGISTRATE.simple("luna", GTRegistries.Keys.DIMENSION_MARKER,
            () -> new DimensionMarker(1, () -> LUNA_MARKER, null));
    public static final Holder<DimensionMarker> MARS = REGISTRATE.simple("mars", GTRegistries.Keys.DIMENSION_MARKER,
            () -> new DimensionMarker(2, () -> MARS_MARKER, null));
    public static final Holder<DimensionMarker> MERCURY = REGISTRATE.simple("mercury", GTRegistries.Keys.DIMENSION_MARKER,
            () -> new DimensionMarker(2, () -> MERCURY_MARKER, null));
    public static final Holder<DimensionMarker> VENUS = REGISTRATE.simple("venus", GTRegistries.Keys.DIMENSION_MARKER,
            () -> new DimensionMarker(2, () -> VENUS_MARKER, null));

    private static BlockEntry<Block> createMarker(String name) {
        return REGISTRATE.block("%s_marker".formatted(name), Block::new)
                .lang(FormattingUtil.toEnglishName(name))
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.get(),
                        prov.models().cube(ctx.getName(),
                                prov.modLoc("block/dim_markers/%s/down".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/up".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/north".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/south".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/east".formatted(name)),
                                prov.modLoc("block/dim_markers/%s/west".formatted(name)))
                                .texture("particle", "#north")
                                .guiLight(BlockModel.GuiLight.FRONT)))
                .item()
                .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/" + ctx.getName())))
                .build()
                .register();
    }

    public static void init() {}
}
