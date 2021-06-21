package io.github.frqnny.mostructures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;

public class LighthouseGenerator {
    public static final JigsawPattern STARTING_POOL;
    public static final ResourceLocation LIGHTHOUSES = MoStructures.id("lighthouse/towers");
    public static final ResourceLocation BASE = MoStructures.id("lighthouse/base");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        LIGHTHOUSES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.single(MoStructures.MODID + ":lighthouse/lighthouse_1"), 1)

                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        BASE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.single(MoStructures.MODID + ":lighthouse/base", MoStructures.PIRATE_SHIP_LIST), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );


    }

    public static void init() {

    }
}