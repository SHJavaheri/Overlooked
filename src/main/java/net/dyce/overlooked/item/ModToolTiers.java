package net.dyce.overlooked.item;

import net.dyce.overlooked.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier RESONITE = new ForgeTier(1700, 20, 4f, 20,
            ModTags.Blocks.NEEDS_RESONITE_TOOL, () -> Ingredient.of(ModItems.RESONITE.get()),
            ModTags.Blocks.INCORRECT_FOR_RESONITE_TOOL);
}
