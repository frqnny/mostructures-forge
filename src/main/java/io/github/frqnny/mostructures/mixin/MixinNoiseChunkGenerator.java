package io.github.frqnny.mostructures.mixin;

import io.github.frqnny.mostructures.ConfiguredFeatures;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(NoiseChunkGenerator.class)
public class MixinNoiseChunkGenerator {

    @Inject(at = @At("HEAD"), method = "getMobsAt", cancellable = true)
    public void injectSpawnList(Biome biome, StructureManager accessor, EntityClassification group, BlockPos pos, CallbackInfoReturnable<List<MobSpawnInfo.Spawners>> info) {
        if (accessor.getStructureAt(pos, false, ConfiguredFeatures.PILLAGER_FACTORY.feature).isValid()) {
            if (group == EntityClassification.MONSTER) {
                info.setReturnValue(Structure.PILLAGER_OUTPOST.getDefaultSpawnList());
            }
        }
        if (accessor.getStructureAt(pos, false, ConfiguredFeatures.ICE_TOWER.feature).isValid()) {
            if (group == EntityClassification.MONSTER) {
                info.setReturnValue(MoStructures.ICE_TOWER.getMonsterSpawns());
            }
        }
    }
}
