package io.github.frqnny.mostructures.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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
import java.util.Random;

public class SimpleCobblestoneProcessor extends StructureProcessor {
    public static final Codec<SimpleCobblestoneProcessor> CODEC = RecordCodecBuilder.create((proc) -> proc.group(
            Codec.FLOAT.fieldOf("mossiness").forGetter(processor -> processor.mossiness)
    ).apply(proc, SimpleCobblestoneProcessor::new));
    private final float mossiness;

    public SimpleCobblestoneProcessor(float mossiness) {
        this.mossiness = mossiness;
    }

    @Nullable
    @Override
    public Template.BlockInfo processBlock(IWorldReader world, BlockPos pos, BlockPos blockPos, Template.BlockInfo structureBlockInfo, Template.BlockInfo structureBlockInfo2, PlacementSettings structurePlacementData) {
        Random random = structurePlacementData.getRandom(structureBlockInfo2.pos);
        BlockState blockState = structureBlockInfo2.state;
        BlockPos blockPos2 = structureBlockInfo2.pos;
        BlockState blockState2 = null;

        if (blockState.is(Blocks.COBBLESTONE)) {
            blockState2 = this.processBlocks(random);
        }

        return blockState2 != null ? new Template.BlockInfo(blockPos2, blockState2, structureBlockInfo2.nbt) : structureBlockInfo2;
    }

    @Override
    protected IStructureProcessorType<?> getType() {
        return MoStructures.SIMPLE_COBBLESTONE;
    }

    @Nullable
    private BlockState processBlocks(Random random) {
        if (random.nextFloat() >= 0.5F) {
            return null;
        } else {
            return random.nextFloat() < this.mossiness ? Blocks.COBBLESTONE.defaultBlockState() : Blocks.MOSSY_COBBLESTONE.defaultBlockState();

        }
    }
}
