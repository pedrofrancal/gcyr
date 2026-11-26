package argent_matter.gcyr.api.registries;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.api.space.satellite.SatelliteType;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class GCYRRegistries {

    public static final GTRegistrate REGISTRATE = GTRegistrate.create(GCYR.MOD_ID);

    public static final class Keys {

        public static final ResourceKey<Registry<SatelliteType<?>>> SATELLITE = ResourceKey
                .createRegistryKey(GCYR.id("satellite"));
    }

    public static final Registry<SatelliteType<?>> SATELLITES = new RegistryBuilder<>(Keys.SATELLITE)
            .sync(true)
            .create();

    public static void init(IEventBus modBus) {
        modBus.addListener(NewRegistryEvent.class, event -> event.register(SATELLITES));
    }
}
