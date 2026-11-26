package argent_matter.gcyr.common.data.client;

import com.gregtechceu.gtceu.api.sound.SoundEntry;

import net.neoforged.neoforge.registries.DeferredHolder;

import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;

public class GCYRSoundEntries {

    public static final DeferredHolder<SoundEntry, SoundEntry> ROCKET = REGISTRATE.sound("rocket").register();

    public static void init() {}
}
