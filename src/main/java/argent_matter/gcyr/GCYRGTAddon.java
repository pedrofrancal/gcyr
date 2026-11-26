package argent_matter.gcyr;

import argent_matter.gcyr.api.registries.GCYRRegistries;
import argent_matter.gcyr.common.data.recipe.GCYRRecipes;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.minecraft.data.recipes.RecipeOutput;

/**
 * GTM 8 addon entrypoint. Content (materials, tag prefixes, sounds, worldgen layers, recipe types, ...) is registered
 * directly through {@link GCYRRegistries#REGISTRATE} from {@link GCYR#init()}; ore veins are datagen'd via
 * {@link argent_matter.gcyr.common.worldgen.GCYROres#bootstrap}.
 */
@GTAddon(GCYR.MOD_ID)
public class GCYRGTAddon implements IGTAddon {

    @Override
    public GTRegistrate getRegistrate() {
        return GCYRRegistries.REGISTRATE;
    }

    @Override
    public void addRecipes(RecipeOutput provider) {
        GCYRRecipes.init(provider);
    }
}
