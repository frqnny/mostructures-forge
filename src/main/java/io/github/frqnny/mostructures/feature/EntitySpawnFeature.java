package io.github.frqnny.mostructures.feature;

import com.mojang.serialization.Codec;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Random;

public abstract class EntitySpawnFeature<FC extends IFeatureConfig> extends Feature<FC> {

    public EntitySpawnFeature(Codec<FC> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator p_241855_2_, Random p_241855_3_, BlockPos pos, FC config) {
        Entity entity = getEntity(world, pos, config);
        world.getLevel().tryAddFreshEntityWithPassengers(entity);
        return true;
    }

    public abstract Entity getEntity(ISeedReader world, BlockPos pos, FC config);
}
