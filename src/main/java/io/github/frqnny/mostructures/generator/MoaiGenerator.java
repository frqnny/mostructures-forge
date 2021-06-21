package io.github.frqnny.mostructures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;

public class MoaiGenerator {
    public static final JigsawPattern STARTING_POOL;
    public static final ResourceLocation MOAI = MoStructures.id("moai");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        MOAI,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":moai/villager_moai"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );


    }

    public static void init() {

    }
}
