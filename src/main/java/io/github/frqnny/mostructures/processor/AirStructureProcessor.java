package io.github.frqnny.mostructures.processor;

import com.mojang.serialization.Codec;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.Nullable;

public class AirStructureProcessor extends StructureProcessor {
    public static final Codec<AirStructureProcessor> CODEC = Codec.unit(AirStructureProcessor::new);

    @Nullable
    @Override
    public Template.BlockInfo processBlock(IWorldReader world, BlockPos pos, BlockPos blockPos, Template.BlockInfo structureBlockInfo, Template.BlockInfo structureBlockInfo2, PlacementSettings structurePlacementData) {
        if (structureBlockInfo2.state.isAir()) {
            world.getChunk(structureBlockInfo2.pos).setBlockState(structureBlockInfo2.pos, structureBlockInfo2.state, false);
        }
        return structureBlockInfo2;
    }

    @Override
    protected IStructureProcessorType<?> getType() {
        return MoStructures.AIR_STRUCTURE_PROCESSOR;
    }
}