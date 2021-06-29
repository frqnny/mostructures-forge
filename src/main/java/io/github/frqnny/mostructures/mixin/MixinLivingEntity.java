package io.github.frqnny.mostructures.mixin;

import io.github.frqnny.mostructures.util.ItemHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class MixinLivingEntity {


    @Inject(method = "die", at = @At("TAIL"))
    public void rabbitDrops(DamageSource source, CallbackInfo info) {
        if (((LivingEntity) (Object) this) instanceof RabbitEntity) {
            RabbitEntity rabbit = (RabbitEntity) (Object) this;
            if (rabbit.getRabbitType() == 99) {
                ItemStack diamonds = new ItemStack(Items.DIAMOND);
                diamonds.setCount(Math.max(8, rabbit.getRandom().nextInt(10)));
                ItemHelper.spawnStack(rabbit.level, rabbit.getX(), rabbit.getY() + 0.5, rabbit.getZ(), diamonds);

                ItemStack emeralds = new ItemStack(Items.EMERALD);
                emeralds.setCount(Math.max(10, rabbit.getRandom().nextInt(12)));
                ItemHelper.spawnStack(rabbit.level, rabbit.getX(), rabbit.getY() + 0.5, rabbit.getZ(), emeralds);

                ItemStack ironIngots = new ItemStack(Items.IRON_INGOT);
                ironIngots.setCount(Math.max(18, rabbit.getRandom().nextInt(20)));
                ItemHelper.spawnStack(rabbit.level, rabbit.getX(), rabbit.getY() + 0.5, rabbit.getZ(), ironIngots);
            }
        }
    }
}
