package io.github.frqnny.mostructures.generator;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.frqnny.mostructures.MoStructures;
import io.github.frqnny.mostructures.util.RegUtils;
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
import net.minecraft.world.gen.feature.template.IntegrityProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

public class TheCastleInTheSkyGenerator {
    public static final ResourceLocation SW_STARTING_PIECE = MoStructures.id("castle/sw_piece");
    public static final ResourceLocation MIDDLE_PIECES = MoStructures.id("castle/middle_pieces");
    public static final ResourceLocation NE_FINAL_PIECE = MoStructures.id("castle/ne_piece");

    public static final JigsawPattern STARTING_POOL;

    public static final StructureProcessorList TCINS_ROT = RegUtils.registerStructureProcessor("tcins_rot", ImmutableList.of(new IntegrityProcessor(0.25F)));

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        SW_STARTING_PIECE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.list(ImmutableList.of(
                                        JigsawPiece.single(MoStructures.MODID + ":castle/sw"),
                                        JigsawPiece.single(MoStructures.MODID + ":castle/sw_overgrown",
                                                TCINS_ROT))),
                                        1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        MIDDLE_PIECES,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.list(ImmutableList.of(
                                        JigsawPiece.single(MoStructures.MODID + ":castle/se"),
                                        JigsawPiece.single(MoStructures.MODID + ":castle/se_overgrown",
                                                TCINS_ROT))),
                                        1),
                                new Pair<>(JigsawPiece.list(ImmutableList.of(
                                        JigsawPiece.single(MoStructures.MODID + ":castle/nw"),
                                        JigsawPiece.single(MoStructures.MODID + ":castle/nw_overgrown",
                                                TCINS_ROT))),
                                        1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
        JigsawPatternRegistry.register(
                new JigsawPattern(
                        NE_FINAL_PIECE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                new Pair<>(JigsawPiece.list(ImmutableList.of(
                                        JigsawPiece.legacy(MoStructures.MODID + ":castle/ne"),
                                        JigsawPiece.legacy(MoStructures.MODID + ":castle/ne_overgrown",
                                                TCINS_ROT))),
                                        1)
                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }

    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}
