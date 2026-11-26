package argent_matter.gcyr.common.recipe.condition;

import argent_matter.gcyr.api.capability.GCYRCapabilityHelper;
import argent_matter.gcyr.api.capability.IDysonSystem;
import argent_matter.gcyr.common.data.recipe.GCYRRecipeConditions;

import com.gregtechceu.gtceu.api.machine.trait.recipe.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;

import com.mojang.serialization.MapCodec;

import lombok.NoArgsConstructor;

import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class DysonSphereCondition extends RecipeCondition<DysonSphereCondition> {

    public static final MapCodec<DysonSphereCondition> CODEC = RecipeCondition.simpleCodec(DysonSphereCondition::new);
    public final static DysonSphereCondition INSTANCE = new DysonSphereCondition();

    public DysonSphereCondition(boolean isReverse) {
        super(isReverse);
    }

    @Override
    public RecipeConditionType<DysonSphereCondition> getType() {
        return GCYRRecipeConditions.DYSON_SPHERE.value();
    }

    @Override
    public Component getTooltips() {
        return Component.translatable(
                isReverse ? "gcyr.condition.requires_dyson_sphere.false" : "gcyr.condition.requires_dyson_sphere.true");
    }

    @Override
    public boolean testCondition(@NotNull GTRecipe recipe, @NotNull RecipeLogic recipeLogic) {
        Level level = recipeLogic.getLevel();
        if (!level.isClientSide) {
            IDysonSystem system = GCYRCapabilityHelper.getDysonSystem((ServerLevel) level);
            if (system == null) return false;
            return system.isDysonSphereActive() && !system.activeDysonSphere().isCollapsed();
        }
        return false;
    }

    @Override
    public DysonSphereCondition createTemplate() {
        return new DysonSphereCondition();
    }
}
