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

public class VillageBazaarGenerator {
    public static final JigsawPattern STARTING_POOL;
    public static final ResourceLocation START = MoStructures.id("bazaar/ring");
    public static final ResourceLocation CENTER_PIECE = MoStructures.id("bazaar/center_piece");
    public static final ResourceLocation HOUSE_9X = MoStructures.id("bazaar/house_nine");
    public static final ResourceLocation PATH = MoStructures.id("bazaar/path");
    public static final ResourceLocation VILLAGER = MoStructures.id("bazaar/villager");


    static {
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        START,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/ring_1"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        CENTER_PIECE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/center_piece_1"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        HOUSE_9X,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_1"), 2),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_2"), 3),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_3"), 2),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_4"), 2),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_5"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_6"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_7"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/house9x_8"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        PATH,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/path"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.TERRAIN_MATCHING
                )
        );

        JigsawPatternRegistry.register(
                new JigsawPattern(
                        VILLAGER,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":bazaar/villager"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }

    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}