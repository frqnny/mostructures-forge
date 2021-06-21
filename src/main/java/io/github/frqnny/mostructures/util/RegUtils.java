package io.github.frqnny.mostructures.util;

import com.google.common.collect.ImmutableList;
import io.github.frqnny.mostructures.MoStructures;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessorList;

import java.util.function.Supplier;

public class RegUtils {
    public static Supplier<JigsawPattern> pool(JigsawPattern pool) {
        return () -> pool;
    }

    /*
    public static void addToBiome(Identifier id, Predicate<BiomeSelectionContext> selectorPredicate, Consumer<BiomeModificationContext> biomeAdditionConsumer) {
        BiomeModifications.create(id).add(ModificationPhase.ADDITIONS, selectorPredicate, biomeAdditionConsumer);
    }



    public static void addStructure(BiomeModificationContext context, ConfiguredStructureFeature<?, ?> feature) {
        context.getGenerationSettings().addBuiltInStructure(feature);
    }


    public static Predicate<BiomeSelectionContext> booleanToPredicate(boolean bol) {
        return (context) -> bol;
    }


     */
    public static StructureProcessorList registerStructureProcessor(String id, ImmutableList<StructureProcessor> processorList) {
        Identifier identifier = MoStructures.id(id);
        StructureProcessorList structureProcessorList = new StructureProcessorList(processorList);
        return BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST, identifier, structureProcessorList);
    }

    /*
    public static Predicate<BiomeSelectionContext> getNoHillsPredicate() {
        return (context) -> !context.getBiomeKey().getValue().getPath().contains("hill") && !context.getBiomeKey().getValue().getPath().contains("mountain");
    }

     */

    public static StructureProcessorList registerStructureProcessorList(String id, ImmutableList<StructureProcessor> processorList) {
        Identifier identifier = MoStructures.id(id);
        StructureProcessorList structureProcessorList = new StructureProcessorList(processorList);
        return BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_PROCESSOR_LIST, identifier, structureProcessorList);
    }
}
