package io.github.frqnny.mostructures.mixin;

import io.github.frqnny.mostructures.util.FeatureHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.LakesFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@SuppressWarnings("unused")
@Mixin(LakesFeature.class)
public class LakeFeatureMixin {

    @Inject(at = @At("HEAD"), method = "place", cancellable = true)
    public void structures_fixLake(ISeedReader world, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos pos, BlockStateFeatureConfig config, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(FeatureHelper.checkChunksForStructures(world, pos));
    }
}