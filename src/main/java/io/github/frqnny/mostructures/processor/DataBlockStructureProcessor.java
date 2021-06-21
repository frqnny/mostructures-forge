package io.github.frqnny.mostructures.processor;

import com.mojang.serialization.Codec;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.Nullable;

public class DataBlockStructureProcessor extends StructureProcessor {
    public static final Codec<DataBlockStructureProcessor> CODEC = Codec.unit(DataBlockStructureProcessor::new);


    @Nullable
    @Override
    public Template.BlockInfo processBlock(IWorldReader world, BlockPos pos, BlockPos blockPos, Template.BlockInfo structureBlockInfo, Template.BlockInfo structureBlockInfo2, PlacementSettings structurePlacementData) {
        BlockState state = structureBlockInfo.state;

        if (state.is(Blocks.STRUCTURE_BLOCK)) {
            String mode = structureBlockInfo.nbt.getString("mode");


            if (mode.contains("DATA")) {
                String metadata = structureBlockInfo.nbt.getString("metadata");
                BlockPos worldPos = structureBlockInfo.pos;

            }
        }
        return structureBlockInfo;
    }

    @Override
    protected IStructureProcessorType<?> getType() {
        return MoStructures.DATA_BLOCK_STRUCTURE_PROCESSOR;
    }
}
