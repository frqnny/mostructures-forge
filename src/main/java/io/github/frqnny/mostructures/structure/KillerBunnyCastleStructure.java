package io.github.frqnny.mostructures.structure;

import com.google.common.collect.ImmutableList;
import io.github.frqnny.mostructures.MoStructures;
import io.github.frqnny.mostructures.generator.IceTowerGenerator;
import io.github.frqnny.mostructures.generator.JunglePyramidGenerator;
import io.github.frqnny.mostructures.generator.KillerBunnyCastleGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

public class KillerBunnyCastleStructure extends SpacedStructure<VillageConfig> {
    public static final ResourceLocation ID = MoStructures.id("killer_bunny_castle");
    private static final List<MobSpawnInfo.Spawners> MONSTER_SPAWNS = ImmutableList.of(new MobSpawnInfo.Spawners(EntityType.STRAY, 1, 2, 2), new MobSpawnInfo.Spawners(EntityType.CREEPER, 1, 1, 1));

    public KillerBunnyCastleStructure() {
        super(VillageConfig.CODEC);
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return MONSTER_SPAWNS;
    }

    @Override
    public Structure.IStartFactory<VillageConfig> getStartFactory() {
        return KillerBunnyCastleStructure.Start::new;
    }

    public static class Start extends MarginedStructureStart<VillageConfig> {
        public Start(Structure<VillageConfig> feature, int chunkX, int chunkZ, MutableBoundingBox box, int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void generatePieces(DynamicRegistries registryManager, ChunkGenerator chunkGenerator, TemplateManager structureManager, int x, int z, Biome biome, VillageConfig config) {
            KillerBunnyCastleGenerator.addPieces(registryManager, config, chunkGenerator, structureManager, new BlockPos(x << 4, 0, z << 4), pieces, random);
            this.calculateBoundingBox();
        }
    }
}
