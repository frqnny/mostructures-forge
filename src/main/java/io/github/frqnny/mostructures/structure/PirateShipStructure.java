package io.github.frqnny.mostructures.structure;

import io.github.frqnny.mostructures.MoStructures;
import io.github.frqnny.mostructures.generator.PirateShipGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class PirateShipStructure extends SpacedStructure<VillageConfig> {
    public static final ResourceLocation ID = MoStructures.id("pirateship");

    public PirateShipStructure() {
        super(VillageConfig.CODEC);
    }


    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long worldSeed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, VillageConfig featureConfig) {
        return chunkGenerator.getBaseHeight(chunkX << 4, chunkZ << 4, Heightmap.Type.OCEAN_FLOOR_WG) < 50;
    }

    @Override
    public Structure.IStartFactory<VillageConfig> getStartFactory() {
        return LighthouseStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> feature, int chunkX, int chunkZ, MutableBoundingBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void generatePieces(DynamicRegistries registry, ChunkGenerator chunkGenerator, TemplateManager structureManager, int x, int z, Biome biome, VillageConfig config) {
            PirateShipGenerator.addPieces(registry, config, chunkGenerator, structureManager, new BlockPos(x * 16, 0, z << 4), pieces, random);
            this.calculateBoundingBox();
        }
    }


}