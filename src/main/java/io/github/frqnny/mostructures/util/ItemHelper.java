package io.github.frqnny.mostructures.util;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHelper {
    public static void spawnStack(World world, double x, double y, double z, ItemStack stack) {
        ItemEntity item = new ItemEntity(world, x, y, z, stack);
        item.setDefaultPickUpDelay();
        world.addFreshEntity(item);
    }

}
