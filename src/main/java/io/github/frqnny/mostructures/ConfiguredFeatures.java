package io.github.frqnny.mostructures;


import io.github.frqnny.mostructures.generator.*;
import io.github.frqnny.mostructures.util.RegUtils;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class ConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> VILLAGER_SPAWN = MoStructures.VILLAGER_SPAWN
            .configure(FeatureConfig.DEFAULT);

    public static final StructureFeature<VillageConfig, ?> BARN_HOUSE = MoStructures.BARN_HOUSE.configure(new VillageConfig(RegUtils.pool(BarnHouseGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> BIG_PYRAMID = MoStructures.BIG_PYRAMID.configure(new VillageConfig(RegUtils.pool(BigPyramidGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> JUNGLE_PYRAMID = MoStructures.JUNGLE_PYRAMID.configure(new VillageConfig(RegUtils.pool(JunglePyramidGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> THE_CASTLE_IN_THE_SKY = MoStructures.THE_CASTLE_IN_THE_SKY.configure(new VillageConfig(RegUtils.pool(TheCastleInTheSkyGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> VILLAGER_MARKET = MoStructures.VILLAGER_MARKET.configure(new VillageConfig(RegUtils.pool(VillagerMarketGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> PILLAGER_FACTORY = MoStructures.PILLAGER_FACTORY.configure(new VillageConfig(RegUtils.pool(PillagerFactoryGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> ICE_TOWER = MoStructures.ICE_TOWER.configure(new VillageConfig(RegUtils.pool(IceTowerGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> TAVERN = MoStructures.TAVERN.configure(new VillageConfig(RegUtils.pool(BoarHatTavernGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> KILLER_BUNNY_CASTLE = MoStructures.KILLER_BUNNY_CASTLE.configure(new VillageConfig(RegUtils.pool(KillerBunnyCastleGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> VILLAGER_TOWER = MoStructures.VILLAGER_TOWER.configure(new VillageConfig(RegUtils.pool(VillagerTowerGenerator.DEFAULT_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> SAVANNA_VILLAGER_TOWER = MoStructures.VILLAGER_TOWER.configure(new VillageConfig(RegUtils.pool(VillagerTowerGenerator.SAVANNA_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> PIRATE_SHIP = MoStructures.PIRATE_SHIP.configure(new VillageConfig(RegUtils.pool(PirateShipGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> LIGHTHOUSE = MoStructures.LIGHTHOUSE.configure(new VillageConfig(RegUtils.pool(LighthouseGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> AIR_BALLOON = MoStructures.AIR_BALLOON.configure(new VillageConfig(RegUtils.pool(AirBalloonGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> MOAI = MoStructures.MOAI.configure(new VillageConfig(RegUtils.pool(MoaiGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> VILLAGE_BAZAAR = MoStructures.VILLAGER_BAZAAR.configure(new VillageConfig(RegUtils.pool(VillageBazaarGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> VOLCANIC_VENT = MoStructures.VOLCANIC_VENT.configure(IFeatureConfig.NONE);


    public static final StructureFeature<VillageConfig, ?> PLAINS_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.configure(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.PLAINS_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> SAVANNA_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.configure(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.SAVANNA_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> DESERT_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.configure(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.DESERT_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> SNOWY_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.configure(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.SNOWY_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> TAIGA_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.configure(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.TAIGA_STARTING_POOL), 2));


    public static void registerConfiguredFeatures() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, MoStructures.id("configured_villager_feature"), VILLAGER_SPAWN);

        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_barnhouse"), BARN_HOUSE);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_pyramid"), BIG_PYRAMID);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_jungle_pyramid"), JUNGLE_PYRAMID);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_tcity"), THE_CASTLE_IN_THE_SKY);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_villager_tower"), VILLAGER_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_savanna_village_tower"), SAVANNA_VILLAGER_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_villager_market"), VILLAGER_MARKET);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_pillager_factory"), PILLAGER_FACTORY);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_plains_abandoned_church"), PLAINS_ABANDONED_CHURCH);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_savanna_abandoned_church"), SAVANNA_ABANDONED_CHURCH);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_desert_abandoned_church"), DESERT_ABANDONED_CHURCH);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_snowy_abandoned_church"), SNOWY_ABANDONED_CHURCH);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_taiga_abandoned_church"), TAIGA_ABANDONED_CHURCH);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_ice_tower"), ICE_TOWER);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_boar_hat_tavern"), TAVERN);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_killer_bunny_castle"), KILLER_BUNNY_CASTLE);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_pirate_ship"), PIRATE_SHIP);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_light_house"), LIGHTHOUSE);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_volcanic_vent"), VOLCANIC_VENT);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_moai"), MOAI);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_air_balloon"), AIR_BALLOON);
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configured_villager_bazaar"), VILLAGE_BAZAAR);
    }

}
