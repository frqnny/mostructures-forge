package io.github.frqnny.mostructures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.frqnny.mostructures.ConfiguredFeatures;
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

public class VillagerTowerGenerator {
    public static final JigsawPattern DEFAULT_STARTING_POOL;
    public static final JigsawPattern SAVANNA_STARTING_POOL;
    public static final JigsawPattern DESERT_STARTING_POOL;
    public static final ResourceLocation SAVANNA_BASE_PLATES = MoStructures.id("villager/savanna_plates");
    public static final ResourceLocation DESERT_BASE_PLATES = MoStructures.id("villager/desert_plates");
    private static final ResourceLocation BASE_PLATES = MoStructures.id("villager/tower_plates");
    private static final ResourceLocation TOWERS = MoStructures.id("villager/towers");
    private static final ResourceLocation SAVANNA_TOWERS = MoStructures.id("villager/savanna_towers");
    private static final ResourceLocation DESERT_TOWERS = MoStructures.id("villager/desert_towers");
    private static final ResourceLocation FEATURE_PLATES = MoStructures.id("villager/feature_plates");
    private static final ResourceLocation FEATURES = MoStructures.id("villager/features");

    static {
        DEFAULT_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        BASE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":villager/tower_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        SAVANNA_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        SAVANNA_BASE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":villager/savanna_tower_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        DESERT_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        DESERT_BASE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":villager/desert_tower_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        TOWERS,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>((JigsawPiece.legacy(MoStructures.MODID + ":villager/tower_1", MoStructures.VILLAGER_TOWER_LIST)), 1),
                                new Pair<>((JigsawPiece.legacy(MoStructures.MODID + ":villager/tower_2", MoStructures.VILLAGER_TOWER_LIST)), 1),
                                new Pair<>((JigsawPiece.legacy(MoStructures.MODID + ":villager/tower_3", MoStructures.VILLAGER_TOWER_LIST)), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        SAVANNA_TOWERS,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>((JigsawPiece.legacy(MoStructures.MODID + ":villager/savanna_tower_1", MoStructures.VILLAGER_TOWER_LIST)), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        DESERT_TOWERS,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>((JigsawPiece.legacy(MoStructures.MODID + ":villager/desert_tower_1", MoStructures.VILLAGER_TOWER_LIST)), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":villager/feature_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":villager/iron_golem"), 1),
                                new Pair<>(JigsawPiece.feature(ConfiguredFeatures.VILLAGER_SPAWN), 3),
                                new Pair<>(JigsawPiece.empty(), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );

    }


    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}