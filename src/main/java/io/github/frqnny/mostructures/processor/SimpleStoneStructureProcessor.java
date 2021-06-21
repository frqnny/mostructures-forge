package io.github.frqnny.mostructures.processor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.Template;

import javax.annotation.Nullable;
import java.util.Random;

public class SimpleStoneStructureProcessor extends StructureProcessor {
    public static final Codec<SimpleStoneStructureProcessor> CODEC = RecordCodecBuilder.create((proc) -> proc.group(
            Codec.FLOAT.fieldOf("mossiness").forGetter(processor -> processor.mossiness)
    ).apply(proc, SimpleStoneStructureProcessor::new));
    private final float mossiness;

    public SimpleStoneStructureProcessor(float mossiness) {
        this.mossiness = mossiness;
    }

    private static BlockState randomStairProperties(Random random, Block stairs) {
        return stairs.defaultBlockState().setValue(StairsBlock.FACING, Direction.Plane.HORIZONTAL.getRandomDirection(random)).setValue(StairsBlock.HALF, Half.values()[random.nextInt(Half.values().length)]);
    }

    private static BlockState randomState(Random random, BlockState[] states) {
        return states[random.nextInt(states.length)];
    }

    @Nullable
    public Template.BlockInfo processBlock(IWorldReader world, BlockPos pos, BlockPos blockPos, Template.BlockInfo structureBlockInfo, Template.BlockInfo structureBlockInfo2, PlacementSettings structurePlacementData) {

         Random random = structurePlacementData.getRandom(structureBlockInfo2.pos);
        BlockState blockState = structureBlockInfo2.state;
        BlockPos blockPos2 = structureBlockInfo2.pos;
        BlockState blockState2 = null;
        if (blockState.is(Blocks.STONE_BRICKS) || blockState.is(Blocks.STONE) || blockState.is(Blocks.CHISELED_STONE_BRICKS)) {
            blockState2 = this.processBlocks(random);
        }


        return blockState2 != null ? new Template.BlockInfo(blockPos2, blockState2, structureBlockInfo2.nbt) : structureBlockInfo2;
    }

    @Nullable
    private BlockState processBlocks(Random random) {
        if (random.nextFloat() >= 0.5F) {
            return null;
        } else {
            BlockState[] blockStates = new BlockState[]{Blocks.CRACKED_STONE_BRICKS.defaultBlockState(), randomStairProperties(random, Blocks.STONE_BRICK_STAIRS)};
            BlockState[] blockStates2 = new BlockState[]{Blocks.MOSSY_STONE_BRICKS.defaultBlockState(), randomStairProperties(random, Blocks.MOSSY_STONE_BRICK_STAIRS)};
            return this.process(random, blockStates, blockStates2);
        }
    }

    private BlockState process(Random random, BlockState[] regularStates, BlockState[] mossyStates) {
        return random.nextFloat() < this.mossiness ? randomState(random, mossyStates) : randomState(random, regularStates);
    }

    protected IStructureProcessorType<?> getType() {
        return MoStructures.SIMPLE_STONE;
    }


}