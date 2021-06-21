package io.github.frqnny.mostructures.util;

import io.github.frqnny.mostructures.ConfiguredFeatures;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FeatureHelper {

    public static void placeStructure(ResourceLocation structureId, BlockPos pos, ISeedReader world, Random random) {
        Template structure = world.getLevel().getStructureManager().getOrCreate(structureId);
        Rotation blockRotation = Rotation.getRandom(random);
        PlacementSettings structurePlacementData = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(blockRotation).setIgnoreEntities(false).setChunkPosition(null);
        structure.placeInWorld(world, pos, structurePlacementData, random);
    }

    //Returns false if it can't generate, returns true if it can generate.
    public static boolean checkChunksForStructures(ISeedReader world, BlockPos pos) {
        List<IChunk> chunksToScan = new ArrayList<>(9);
        chunksToScan.add(world.getChunk(pos));
        chunksToScan.add(world.getChunk(pos.offset(16, 0, 16)));
        chunksToScan.add(world.getChunk(pos.offset(-16, 0, -16)));
        chunksToScan.add(world.getChunk(pos.offset(0, 0, 16)));
        chunksToScan.add(world.getChunk(pos.offset(16, 0, 0)));
        chunksToScan.add(world.getChunk(pos.offset(-16, 0, 0)));
        chunksToScan.add(world.getChunk(pos.offset(0, 0, -16)));
        chunksToScan.add(world.getChunk(pos.offset(16, 0, -16)));
        chunksToScan.add(world.getChunk(pos.offset(-16, 0, 16)));
        for (IChunk chunk : chunksToScan) {
            if (
                    !chunk.getReferencesForFeature(ConfiguredFeatures.BARN_HOUSE.feature).isEmpty()
                            || !chunk.getReferencesForFeature(ConfiguredFeatures.JUNGLE_PYRAMID.feature).isEmpty()
                            || !chunk.getReferencesForFeature(ConfiguredFeatures.VILLAGER_TOWER.feature).isEmpty()
                            || !chunk.getReferencesForFeature(MoStructures.ABANDONED_CHURCH).isEmpty()
                            || !chunk.getReferencesForFeature(ConfiguredFeatures.VILLAGER_MARKET.feature).isEmpty()
                            || !chunk.getReferencesForFeature(ConfiguredFeatures.PILLAGER_FACTORY.feature).isEmpty()
                            || !chunk.getReferencesForFeature(ConfiguredFeatures.TAVERN.feature).isEmpty()
                            || !chunk.getReferencesForFeature(ConfiguredFeatures.KILLER_BUNNY_CASTLE.feature).isEmpty()
            ) {
                return false;
            }
        }

        return true;
    }
}
