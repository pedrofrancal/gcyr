package argent_matter.gcyr.client;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.client.dimension.ClientModSkies;
import argent_matter.gcyr.client.particle.DysonBeamParticle;
import argent_matter.gcyr.common.data.client.GCYRParticles;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = GCYR.MOD_ID, value = Dist.CLIENT)
public class ClientEventListener {

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(GCYRParticles.DYSON_BEAM, DysonBeamParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerDimensionEffects(RegisterDimensionSpecialEffectsEvent event) {
        for (var entry : ClientModSkies.DIMENSION_SPECIAL_EFFECTS.entrySet()) {
            event.register(entry.getKey(), entry.getValue());
        }
    }
}
