package io.github.frqnny.mostructures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

public class BarnHouseGenerator {
    public static final JigsawPattern STARTING_POOL;
    private static final ResourceLocation BASE_PLATES = MoStructures.id("barn_house/base_plates");
    private static final ResourceLocation BARNHOUSE = MoStructures.id("barn_house/barnhouses");
    private static final ResourceLocation FEATURE_PLATES = MoStructures.id("barn_house/feature_plates");
    private static final ResourceLocation FEATURES = MoStructures.id("barn_house/features");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        BASE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/base_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        BARNHOUSE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/barnhouse_1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/barnhouse_2"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/barnhouse_3"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/barnhouse_4"), 1)

                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );

        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/feature_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":barn_house/feature_cart"), 1),
                                new Pair<>(JigsawPiece.legacy("pillager_outpost/feature_logs"), 1),
                                new Pair<>(JigsawPiece.empty(), 5)),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );

    }


    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}