package argent_matter.gcyr;

import argent_matter.gcyr.api.registries.GCYRRegistries;
import argent_matter.gcyr.common.data.*;
import argent_matter.gcyr.common.data.block.GCYRBlocks;
import argent_matter.gcyr.common.data.client.*;
import argent_matter.gcyr.common.data.dimension.*;
import argent_matter.gcyr.common.data.entity.*;
import argent_matter.gcyr.common.data.item.*;
import argent_matter.gcyr.common.data.machine.GCYRMachines;
import argent_matter.gcyr.common.data.material.GCYRMaterials;
import argent_matter.gcyr.common.data.network.GCYRNetworking;
import argent_matter.gcyr.common.data.recipe.*;
import argent_matter.gcyr.common.data.worldgen.GCYRChunkGenerators;
import argent_matter.gcyr.common.worldgen.GCYRWorldGenLayers;
import argent_matter.gcyr.config.GCYRConfig;
import argent_matter.gcyr.data.GCYRDatagen;

import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(GCYR.MOD_ID)
public class GCYR {

    public static final String MOD_ID = "gcyr",
            NAME = "Gregicality Rocketry";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public GCYR(IEventBus modBus, ModContainer container) {
        modBus.register(this);

        GCYRRegistries.init(modBus);
        GCYRChunkGenerators.register(modBus);
        GCYRRecipeTypes.register(modBus);
        GCYRRecipeSerializers.register(modBus);
        GCYREntityDataSerializers.register(modBus);
        GCYRNetworking.init(modBus);
        GCYRSatellites.init(modBus);

        init();

        if (FMLEnvironment.dist.isClient()) {
            GCYRClient.init(modBus);
        }
    }

    public static void init() {
        GCYRConfig.init();

        GCYRCreativeModeTabs.init();
        // GT content registered through GCYR's GTRegistrate (order matters for creative tabs)
        GCYRMaterials.init();
        GCYRSoundEntries.init();
        GCYRWorldGenLayers.init();
        GCYRRecipeConditions.init();
        GCYRGTRecipeTypes.init();
        GCYRDimensionMarkers.init();
        GCYRTagPrefixes.init();

        GCYREntities.init();
        GCYRBlocks.init();
        GCYRItems.init();
        GCYRMenus.init();
        GCYRMachines.init();

        GCYRDatagen.init();
        GCYRParticles.init();
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @SubscribeEvent
    public void modifyMaterials(PostMaterialEvent event) {
        GCYRMaterials.modifyMaterials();
    }
}
