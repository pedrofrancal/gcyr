package argent_matter.gcyr.common.data.recipe;

import argent_matter.gcyr.common.recipe.condition.DysonSphereCondition;
import argent_matter.gcyr.common.recipe.condition.OrbitCondition;

import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.api.recipe.condition.RecipeConditionType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

import com.mojang.serialization.MapCodec;
import com.tterrag.registrate.util.entry.RegistryEntry;

import static argent_matter.gcyr.api.registries.GCYRRegistries.REGISTRATE;

public class GCYRRecipeConditions {

    public static final RegistryEntry<RecipeConditionType<?>, RecipeConditionType<DysonSphereCondition>> DYSON_SPHERE = register(
            "dyson_sphere", DysonSphereCondition::new, DysonSphereCondition.CODEC);
    public static final RegistryEntry<RecipeConditionType<?>, RecipeConditionType<OrbitCondition>> ORBIT = register(
            "orbit", OrbitCondition::new, OrbitCondition.CODEC);

    private static <T extends RecipeCondition<T>> RegistryEntry<RecipeConditionType<?>, RecipeConditionType<T>> register(
            String name, RecipeConditionType.ConditionFactory<T> factory, MapCodec<T> codec) {
        return REGISTRATE.simple(name, GTRegistries.Keys.RECIPE_CONDITION,
                () -> new RecipeConditionType<>(factory, codec));
    }

    public static void init() {}
}
