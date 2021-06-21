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

public class VillagerMarketGenerator {
    public static final JigsawPattern STARTING_POOL;
    public static final ResourceLocation MAIN = MoStructures.id("market/main");
    public static final ResourceLocation VILLAGER = MoStructures.id("market/villager");
    public static final ResourceLocation IRON_GOLEM = MoStructures.id("market/iron_golem");
    public static final ResourceLocation FEATURE_PLATES = MoStructures.id("market/feature_plate");
    public static final ResourceLocation FEATURES = MoStructures.id("market/features");

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        MAIN,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/main"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        VILLAGER,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/villager"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        IRON_GOLEM,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/iron_golem"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURE_PLATES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/feature_plate"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        FEATURES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/grill"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/cart_1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/cart_2"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/sign_post"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/weaponsmith"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":market/farmhouse"), 1),
                                new Pair<>(JigsawPiece.empty(), 6)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }

    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}
