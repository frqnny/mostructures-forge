package io.github.frqnny.mostructures.structure;

import io.github.frqnny.mostructures.MoStructures;
import io.github.frqnny.mostructures.generator.AirBalloonGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class AirBalloonStructure extends SpacedStructure<VillageConfig> {
    public static final ResourceLocation ID = MoStructures.id("air_balloon");

    public AirBalloonStructure() {
        super(VillageConfig.CODEC);
    }

    @Override
    public Structure.IStartFactory<VillageConfig> getStartFactory() {
        return AirBalloonStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> feature, int chunkX, int chunkZ, MutableBoundingBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void generatePieces(DynamicRegistries registry, ChunkGenerator chunkGenerator, TemplateManager structureManager, int x, int z, Biome biome, VillageConfig config) {
            AirBalloonGenerator.init();
            int yToAdd = Math.max(random.nextInt(100), 45);
            JigsawManager.addPieces(registry, config, AbstractVillagePiece::new, chunkGenerator, structureManager, new BlockPos(x * 16, yToAdd, z << 4), pieces, random, true, true);
            this.calculateBoundingBox();
        }
    }


}