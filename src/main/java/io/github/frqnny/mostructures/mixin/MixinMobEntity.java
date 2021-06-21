package io.github.frqnny.mostructures.mixin;

import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.IServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(MobEntity.class)
public class MixinMobEntity {

    @Inject(at = @At("TAIL"), method = "initialize", cancellable = true)
    public void rabbitPlsWork(IServerWorld world, IServerWorld difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT entityTag, CallbackInfoReturnable<ILivingEntityData> info) {

        if (((MobEntity) (Object) this) instanceof RabbitEntity && entityTag != null && entityTag.contains("RabbitType")) {
            ((RabbitEntity) (Object) this).setRabbitType(entityTag.getInt("RabbitType"));
        }
    }
}
