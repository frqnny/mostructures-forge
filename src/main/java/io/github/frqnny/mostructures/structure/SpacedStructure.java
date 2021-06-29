package io.github.frqnny.mostructures.structure;

import com.mojang.serialization.Codec;
import io.github.frqnny.mostructures.ConfiguredFeatures;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.StructureSeparationSettings;

public abstract class SpacedStructure<C extends IFeatureConfig> extends Structure<C> {
    public SpacedStructure(Codec<C> codec) {
        super(codec);
    }

    @Override
    protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeProvider biomeSource, long worldSeed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, C featureConfig) {

        //cannot be near other specified structure
        StructureSeparationSettings structureConfigVillage = chunkGenerator.getSettings().getConfig(Structure.VILLAGE);
        StructureSeparationSettings configBarnHouse = chunkGenerator.getSettings().getConfig(ConfiguredFeatures.BARN_HOUSE.feature);
        StructureSeparationSettings configBigPyramid = chunkGenerator.getSettings().getConfig(ConfiguredFeatures.BIG_PYRAMID.feature);
        StructureSeparationSettings configJunglePyramid = chunkGenerator.getSettings().getConfig(ConfiguredFeatures.JUNGLE_PYRAMID.feature);
        StructureSeparationSettings configPillagerFactory = chunkGenerator.getSettings().getConfig(ConfiguredFeatures.PILLAGER_FACTORY.feature);
        StructureSeparationSettings configVillagerMarket = chunkGenerator.getSettings().getConfig(ConfiguredFeatures.VILLAGER_MARKET.feature);
        StructureSeparationSettings configVillagerTower = chunkGenerator.getSettings().getConfig(ConfiguredFeatures.VILLAGER_TOWER.feature);

        for (int k = chunkX - 6; k <= chunkX + 6; ++k) {
            for (int m = chunkZ - 6; m <= chunkZ + 6; ++m) {
                if (structureConfigVillage != null) {
                    ChunkPos possibleVillagePos = Structure.VILLAGE.getPotentialFeatureChunk(structureConfigVillage, worldSeed, chunkRandom, k, m);
                    if (k == possibleVillagePos.x && m == possibleVillagePos.z) {
                        return false;
                    }
                }
                if (configBarnHouse != null) {
                    ChunkPos possibleBarnhousePos = ConfiguredFeatures.BARN_HOUSE.feature.getPotentialFeatureChunk(configBarnHouse, worldSeed, chunkRandom, k, m);
                    if (k == possibleBarnhousePos.x && m == possibleBarnhousePos.z && !(this instanceof BarnHouseStructure)) {
                        return false;
                    }
                }
                if (configBigPyramid != null) {
                    ChunkPos possibleBigPyramidPos = ConfiguredFeatures.BIG_PYRAMID.feature.getPotentialFeatureChunk(configBigPyramid, worldSeed, chunkRandom, k, m);
                    if (k == possibleBigPyramidPos.x && m == possibleBigPyramidPos.z && !(this instanceof BigPyramidStructure)) {
                        return false;
                    }
                }
                if (configJunglePyramid != null) {
                    ChunkPos possibleJunglePyramidPos = ConfiguredFeatures.JUNGLE_PYRAMID.feature.getPotentialFeatureChunk(configJunglePyramid, worldSeed, chunkRandom, k, m);
                    if (k == possibleJunglePyramidPos.x && m == possibleJunglePyramidPos.z && !(this instanceof JunglePyramidStructure)) {
                        return false;
                    }
                }
                if (configPillagerFactory != null) {
                    ChunkPos possiblePillagerFactoryPos = ConfiguredFeatures.PILLAGER_FACTORY.feature.getPotentialFeatureChunk(configPillagerFactory, worldSeed, chunkRandom, k, m);
                    if (k == possiblePillagerFactoryPos.x && m == possiblePillagerFactoryPos.z && !(this instanceof PillagerFactoryStructure)) {
                        return false;
                    }
                }
                if (configVillagerMarket != null) {
                    ChunkPos possibleVillagerMarketPos = ConfiguredFeatures.VILLAGER_MARKET.feature.getPotentialFeatureChunk(configVillagerMarket, worldSeed, chunkRandom, k, m);
                    if (k == possibleVillagerMarketPos.x && m == possibleVillagerMarketPos.z && !(this instanceof VillagerMarketStructure)) {
                        return false;
                    }
                }
                if (configVillagerTower != null) {
                    ChunkPos possibleVillagerTowerPos = ConfiguredFeatures.VILLAGER_TOWER.feature.getPotentialFeatureChunk(configVillagerTower, worldSeed, chunkRandom, k, m);
                    if (k == possibleVillagerTowerPos.x && m == possibleVillagerTowerPos.z && !(this instanceof VillagerTowerStructure)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }
}
