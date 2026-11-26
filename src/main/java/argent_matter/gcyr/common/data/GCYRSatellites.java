package argent_matter.gcyr.common.data;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.api.registries.GCYRRegistries;
import argent_matter.gcyr.api.space.satellite.Satellite;
import argent_matter.gcyr.api.space.satellite.SatelliteType;
import argent_matter.gcyr.common.satellite.*;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.LinkedHashMap;
import java.util.Map;

public class GCYRSatellites {

    private static final Map<String, SatelliteType<?>> TO_REGISTER = new LinkedHashMap<>();

    public static final SatelliteType<EmptySatellite> EMPTY = register("empty",
            new SatelliteType<>(EmptySatellite::new, EmptySatellite.CODEC));
    public static final SatelliteType<GpsSatellite> GPS = register("gps",
            new SatelliteType<>(GpsSatellite::new, GpsSatellite.CODEC));
    public static final SatelliteType<OreFinderSatellite> ORE_FINDER = register("ore_finder",
            new SatelliteType<>(OreFinderSatellite::new, OreFinderSatellite.CODEC));
    public static final SatelliteType<LaserSatellite> LASER = register("laser",
            new SatelliteType<>(LaserSatellite::new, LaserSatellite.CODEC));
    public static final SatelliteType<DysonSwarmSatellite> DYSON_SWARM = register("dyson_swarm",
            new SatelliteType<>(DysonSwarmSatellite::new, DysonSwarmSatellite.CODEC));

    public static <T extends Satellite> SatelliteType<T> register(String name, SatelliteType<T> satellite) {
        TO_REGISTER.put(name, satellite);
        return satellite;
    }

    public static void init(IEventBus modBus) {
        modBus.addListener(RegisterEvent.class, event -> event.register(GCYRRegistries.Keys.SATELLITE,
                helper -> TO_REGISTER.forEach((name, type) -> helper.register(GCYR.id(name), type))));
    }
}
