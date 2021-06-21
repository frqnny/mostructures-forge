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

public class BoarHatTavernGenerator {
    public static final JigsawPattern STARTING_POOL;
    private static final ResourceLocation BASE_PLATES = MoStructures.id("tavern/base_plates");
    private static final ResourceLocation TAVERNS = MoStructures.id("tavern/taverns");
    private static final ResourceLocation FEATURE_PLATES = MoStructures.id("tavern/feature_plates");
    private static final ResourceLocation FEATURES = MoStructures.id("tavern/features");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        BASE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":tavern/base_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        TAVERNS,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":tavern/tavern_1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":tavern/tavern_2"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":tavern/tavern_3"), 1)

                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );

        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":tavern/feature_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":tavern/campfire"), 1),
                                new Pair<>(JigsawPiece.empty(), 5)),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );

    }


    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}