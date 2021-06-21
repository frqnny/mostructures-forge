package io.github.frqnny.mostructures.structure;

import io.github.frqnny.mostructures.MoStructures;
import io.github.frqnny.mostructures.generator.BarnHouseGenerator;
import io.github.frqnny.mostructures.generator.BigPyramidGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class BigPyramidStructure extends SpacedStructure<VillageConfig> {
    public static final ResourceLocation ID = MoStructures.id("big_pyramid");

    public BigPyramidStructure() {
        super(VillageConfig.CODEC);
    }

    @Override
    public Structure.IStartFactory<VillageConfig> getStartFactory() {
        return BarnHouseStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> feature, int chunkX, int chunkZ, MutableBoundingBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void generatePieces(DynamicRegistries registryManager, ChunkGenerator chunkGenerator, TemplateManager structureManager, int x, int z, Biome biome, VillageConfig config) {
            BigPyramidGenerator.addPieces(registryManager, config, chunkGenerator, structureManager, new BlockPos(x << 4, 0, z << 4), pieces, random);
            this.calculateBoundingBox();
        }
    }
}