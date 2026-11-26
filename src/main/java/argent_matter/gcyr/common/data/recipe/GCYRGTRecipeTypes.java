package argent_matter.gcyr.common.data.recipe;

import argent_matter.gcyr.api.mui.drawable.GCYRGuiTextures;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.gui.ProgressBarTextureSet;
import com.gregtechceu.gtceu.api.registry.registrate.entry.GTRecipeTypeEntry;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;

import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ELECTRIC;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MULTIBLOCK;

public class GCYRGTRecipeTypes {

    public static final GTRecipeTypeEntry OXYGEN_SPREADER_RECIPES = REGISTRATE.recipeType("oxygen_spreader", ELECTRIC)
            .setMaxIOSize(1, 0, 1, 0).setEUIO(IO.IN)
            .UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_MACERATE))
            .setSound(GTSoundEntries.MOTOR)
            .register();

    public static final GTRecipeTypeEntry DYSON_ENERGY_RECIPES = REGISTRATE.recipeType("dyson_controller", MULTIBLOCK)
            .setMaxIOSize(8, 0, 0, 0).setEUIO(IO.BOTH)
            .UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_ARROW_MULTIPLE))
            .setSound(GTSoundEntries.PORTABLE_SCANNER)
            .register();

    public static final GTRecipeTypeEntry SPACE_ELEVATOR_RECIPES = REGISTRATE.recipeType("space_elevator", MULTIBLOCK)
            .setMaxIOSize(16, 1, 4, 0).setEUIO(IO.IN)
            .UI(builder -> builder.setProgressBar(new ProgressBarTextureSet(GCYRGuiTextures.PROGRESS_BAR_ROCKET)))
            .setSound(GTSoundEntries.PORTABLE_SCANNER)
            .register();

    public static void init() {}
}
