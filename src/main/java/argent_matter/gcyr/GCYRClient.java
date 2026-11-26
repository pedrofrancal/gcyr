package argent_matter.gcyr;

import argent_matter.gcyr.api.mui.theme.GCYRThemes;
import argent_matter.gcyr.api.space.planet.Galaxy;
import argent_matter.gcyr.api.space.planet.PlanetRing;
import argent_matter.gcyr.api.space.planet.PlanetSkyRenderer;
import argent_matter.gcyr.api.space.planet.SolarSystem;
import argent_matter.gcyr.common.gui.EntityOxygenHUD;
import argent_matter.gcyr.common.gui.RocketLandingHUD;
import argent_matter.gcyr.core.mixin.RegisterClientReloadListenersEventAccessor;
import argent_matter.gcyr.core.mixin.ReloadableResourceManagerAccessor;
import argent_matter.gcyr.data.loader.PlanetResources;

import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import com.mojang.blaze3d.vertex.VertexFormat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCYRClient {

    public static VertexFormat.Mode MODE_QUAD_STRIP = null;

    public static boolean isDysonSphereActive = false;

    public static boolean hasUpdatedPlanets = false;
    public static List<PlanetSkyRenderer> skyRenderers = new ArrayList<>();
    public static Map<ResourceLocation, ShaderInstance> skyShaders = new HashMap<>();
    public static List<SolarSystem> solarSystems = new ArrayList<>();
    public static List<PlanetRing> planetRings = new ArrayList<>();
    public static List<Galaxy> galaxies = new ArrayList<>();

    public static void init(IEventBus modBus) {
        // GCYRKeyMappings.init();

        modBus.register(GCYRClient.class);
    }

    @SubscribeEvent
    public static void registerThemes(FMLConstructModEvent event) {
        GCYRThemes.init();
    }

    @SubscribeEvent
    public static void registerGuiLayers(RegisterGuiLayersEvent event) {
        event.registerBelowAll(GCYR.id("oxygen_tank"), new EntityOxygenHUD());
        event.registerBelowAll(GCYR.id("rocket_landing"), new RocketLandingHUD());
    }

    @SubscribeEvent
    public static void registerClientReloadListeners(RegisterClientReloadListenersEvent event) {
        // insert the resource loader into the first index forcefully, so we can load our data before shaders are
        // loaded.
        ReloadableResourceManagerAccessor manager = (ReloadableResourceManagerAccessor) ((RegisterClientReloadListenersEventAccessor) event)
                .getResourceManager();
        manager.getListeners().add(0, PlanetResources.INSTANCE);
    }
}
