package io.github.frqnny.mostructures.feature;

import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class VillagerEntityFeature extends EntitySpawnFeature<NoFeatureConfig> {
    public static final ResourceLocation ID = MoStructures.id("villager_entity");

    public VillagerEntityFeature() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public Entity getEntity(ISeedReader world, BlockPos pos, NoFeatureConfig config) {

        VillagerEntity villager = new VillagerEntity(EntityType.VILLAGER, world.getLevel(), VillagerType.byBiome(world.getBiomeName(pos)));
        villager.setPos(pos.getX(), pos.getY(), pos.getZ());
        return villager;
    }
}
