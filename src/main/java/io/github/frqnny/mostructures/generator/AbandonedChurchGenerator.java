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

public class AbandonedChurchGenerator {
    public static final ResourceLocation PLAINS_PLATE = MoStructures.id("abandoned/village/plates_plains");
    public static final ResourceLocation SAVANNA_PLATE = MoStructures.id("abandoned/village/plates_savanna");
    public static final ResourceLocation DESERT_PLATE = MoStructures.id("abandoned/village/plates_desert");
    public static final ResourceLocation SNOWY_PLATE = MoStructures.id("abandoned/village/plates_snowy");
    public static final ResourceLocation TAIGA_PLATE = MoStructures.id("abandoned/village/plates_taiga");

    public static final ResourceLocation CHURCHES_PLAINS = MoStructures.id("abandoned/village/churches_plains");
    public static final ResourceLocation CHURCHES_SAVANNA = MoStructures.id("abandoned/village/churches_savanna");
    public static final ResourceLocation CHURCHES_DESERT = MoStructures.id("abandoned/village/churches_desert");
    public static final ResourceLocation CHURCHES_SNOWY = MoStructures.id("abandoned/village/churches_snowy");
    public static final ResourceLocation CHURCHES_TAIGA = MoStructures.id("abandoned/village/churches_taiga");

    public static final JigsawPattern PLAINS_STARTING_POOL;
    public static final JigsawPattern SAVANNA_STARTING_POOL;
    public static final JigsawPattern DESERT_STARTING_POOL;
    public static final JigsawPattern SNOWY_STARTING_POOL;
    public static final JigsawPattern TAIGA_STARTING_POOL;

    static {
        PLAINS_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        PLAINS_PLATE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plate/plains"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        SAVANNA_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        SAVANNA_PLATE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plate/savanna"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        DESERT_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        DESERT_PLATE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plate/desert"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        SNOWY_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        SNOWY_PLATE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plate/snowy"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        TAIGA_STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        TAIGA_PLATE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plate/taiga"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        CHURCHES_PLAINS,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plains_temple1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/plains_temple2"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        CHURCHES_SAVANNA,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/savanna_temple1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/savanna_temple2"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        CHURCHES_DESERT,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/desert_temple1"), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/desert_temple2"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        CHURCHES_SNOWY,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/snowy_temple1"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        CHURCHES_TAIGA,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":abandoned/village/taiga_temple1"), 1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }

    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}