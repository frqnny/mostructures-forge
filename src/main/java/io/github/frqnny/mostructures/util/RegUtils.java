package io.github.frqnny.mostructures.util;

import com.google.common.collect.ImmutableList;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessorList;

import java.util.function.Supplier;

public class RegUtils {
    public static Supplier<JigsawPattern> pool(JigsawPattern pool) {
        return () -> pool;
    }

    public static StructureProcessorList registerStructureProcessor(String id, ImmutableList<StructureProcessor> processorList) {
        ResourceLocation identifier = MoStructures.id(id);
        StructureProcessorList structureProcessorList = new StructureProcessorList(processorList);
        return WorldGenRegistries.register(WorldGenRegistries.PROCESSOR_LIST, identifier, structureProcessorList);
    }

}
