package io.github.frqnny.mostructures.processor;

import com.mojang.serialization.Codec;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.Nullable;

//A more aggresive form of removal waterlloging
public class RemoveWaterloggedProcessor extends StructureProcessor {
    public static final Codec<RemoveWaterloggedProcessor> CODEC = Codec.unit(RemoveWaterloggedProcessor::new);


    @Nullable
    @Override
    public Template.BlockInfo processBlock(IWorldReader world, BlockPos pos, BlockPos blockPos, Template.BlockInfo structureBlockInfo, Template.BlockInfo structureBlockInfo2, PlacementSettings structurePlacementData) {

        ChunkPos currentChunkPos = new ChunkPos(structureBlockInfo2.pos);
        if (structureBlockInfo2.state.getBlock() instanceof IWaterLoggable) {
            IChunk currentChunk = world.getChunk(currentChunkPos.x, currentChunkPos.z);
            if (world.getFluidState(structureBlockInfo2.pos).is(FluidTags.WATER)) {
                currentChunk.setBlockState(structureBlockInfo2.pos, structureBlockInfo2.state, false);
            }

        }

        return structureBlockInfo2;
    }

    @Override
    protected IStructureProcessorType<?> getType() {
        return MoStructures.REMOVE_WATERLOGGED;
    }
}
