package io.github.frqnny.mostructures;

import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoStructures {
    public static final DeferredRegister<Structure<?>> STRUCTURE_FEATURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, ForgeMod.MODID);

    public static void register() {

    }

    public static void putStructures(final BiomeLoadingEvent event) {

    }
}
