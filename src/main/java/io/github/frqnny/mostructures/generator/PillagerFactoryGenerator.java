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

public class PillagerFactoryGenerator {
    public static final JigsawPattern STARTING_POOL;
    private static final ResourceLocation BASE = MoStructures.id("factory/base");
    private static final ResourceLocation FEATURE_PLATES = MoStructures.id("factory/feature_plates");
    private static final ResourceLocation FEATURES = MoStructures.id("factory/features");
    private static final ResourceLocation RAVAGER = MoStructures.id("factory/ravager");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        BASE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/base"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/feature_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/quarry"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/logs"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/lamp"), 2),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/jail_golem"), 3),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/jail_villager"), 2),
                                new Pair<>(JigsawPiece.empty(), 6)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        RAVAGER,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":factory/ravager"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }

    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}
