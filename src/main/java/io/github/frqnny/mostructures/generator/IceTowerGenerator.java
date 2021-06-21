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

public class IceTowerGenerator {
    public static final ResourceLocation BASE = MoStructures.id("ice_tower/base");

    public static final JigsawPattern STARTING_POOL;

    static {
        STARTING_POOL = JigsawPatternRegistry.register(
                new JigsawPattern(
                        BASE,
                        new ResourceLocation("empty"),
                        ImmutableList.of(
                                //new Pair<>(StructurePoolElement.method_30426(MoStructures.MODID + ":ice_tower/base_1", MoStructures.ICE_TOWER_LIST), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":ice_tower/base_2", MoStructures.ICE_TOWER_LIST), 1),
                                new Pair<>(JigsawPiece.legacy(MoStructures.MODID + ":ice_tower/base_3", MoStructures.ICE_TOWER_LIST), 1)

                        ),
                        JigsawPattern.PlacementBehaviour.RIGID
                )
        );
    }


    public static void addPieces(DynamicRegistries registry, VillageConfig config, ChunkGenerator chunkGenerator, TemplateManager structureManager, BlockPos pos, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }
}
