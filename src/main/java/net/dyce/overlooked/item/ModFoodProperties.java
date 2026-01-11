package net.dyce.overlooked.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RESONATING_APPLE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,400,2), 1.0F)
            .effect(new MobEffectInstance(MobEffects.NIGHT_VISION,1200), 1.0F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 80, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.SATURATION, 20, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 2), 1.0F)
            .alwaysEdible()
            .build();
}
