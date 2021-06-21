package io.github.frqnny.mostructures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;

public class AirBalloonGenerator {
    public static final JigsawPattern STARTING_POOL;
    public static final ResourceLocation AIR_BALLOONS = MoStructures.id("air_balloons");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        AIR_BALLOONS,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon2"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon3"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon4"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon5"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon6"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":air/airballoon7"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }

    public static void init() {

    }
}