package io.github.frqnny.mostructures;


import io.github.frqnny.mostructures.generator.*;
import io.github.frqnny.mostructures.util.RegUtils;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.VillageConfig;

public class ConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> VILLAGER_SPAWN = MoStructures.VILLAGER_SPAWN.get().configured(IFeatureConfig.NONE);

    public static final StructureFeature<VillageConfig, ?> BARN_HOUSE = MoStructures.BARN_HOUSE.get().configured(new VillageConfig(RegUtils.pool(BarnHouseGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> BIG_PYRAMID = MoStructures.BIG_PYRAMID.get().configured(new VillageConfig(RegUtils.pool(BigPyramidGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> JUNGLE_PYRAMID = MoStructures.JUNGLE_PYRAMID.get().configured(new VillageConfig(RegUtils.pool(JunglePyramidGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> THE_CASTLE_IN_THE_SKY = MoStructures.THE_CASTLE_IN_THE_SKY.get().configured(new VillageConfig(RegUtils.pool(TheCastleInTheSkyGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> VILLAGER_MARKET = MoStructures.VILLAGER_MARKET.get().configured(new VillageConfig(RegUtils.pool(VillagerMarketGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> PILLAGER_FACTORY = MoStructures.PILLAGER_FACTORY.get().configured(new VillageConfig(RegUtils.pool(PillagerFactoryGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> ICE_TOWER = MoStructures.ICE_TOWER.get().configured(new VillageConfig(RegUtils.pool(IceTowerGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> TAVERN = MoStructures.TAVERN.get().configured(new VillageConfig(RegUtils.pool(BoarHatTavernGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> KILLER_BUNNY_CASTLE = MoStructures.KILLER_BUNNY_CASTLE.get().configured(new VillageConfig(RegUtils.pool(KillerBunnyCastleGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> VILLAGER_TOWER = MoStructures.VILLAGER_TOWER.get().configured(new VillageConfig(RegUtils.pool(VillagerTowerGenerator.DEFAULT_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> SAVANNA_VILLAGER_TOWER = MoStructures.VILLAGER_TOWER.get().configured(new VillageConfig(RegUtils.pool(VillagerTowerGenerator.SAVANNA_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> PIRATE_SHIP = MoStructures.PIRATE_SHIP.get().configured(new VillageConfig(RegUtils.pool(PirateShipGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> LIGHTHOUSE = MoStructures.LIGHTHOUSE.get().configured(new VillageConfig(RegUtils.pool(LighthouseGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> AIR_BALLOON = MoStructures.AIR_BALLOON.get().configured(new VillageConfig(RegUtils.pool(AirBalloonGenerator.STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> MOAI = MoStructures.MOAI.get().configured(new VillageConfig(RegUtils.pool(MoaiGenerator.STARTING_POOL), 2));
    //public static final StructureFeature<VillageConfig, ?> VILLAGE_BAZAAR = MoStructures.VILLAGER_BAZAAR.get().configured(new VillageConfig(RegUtils.pool(VillageBazaarGenerator.STARTING_POOL), 2));
    //public static final StructureFeature<VillageConfig, ?> VOLCANIC_VENT = MoStructures.VOLCANIC_VENT.get().configured(IFeatureConfig.NONE);


    public static final StructureFeature<VillageConfig, ?> PLAINS_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.get().configured(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.PLAINS_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> SAVANNA_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.get().configured(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.SAVANNA_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> DESERT_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.get().configured(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.DESERT_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> SNOWY_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.get().configured(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.SNOWY_STARTING_POOL), 2));
    public static final StructureFeature<VillageConfig, ?> TAIGA_ABANDONED_CHURCH = MoStructures.ABANDONED_CHURCH.get().configured(new VillageConfig(RegUtils.pool(AbandonedChurchGenerator.TAIGA_STARTING_POOL), 2));


    public static void registerconfigureddFeatures() {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, MoStructures.id("configuredd_villager_feature"), VILLAGER_SPAWN);

        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_barnhouse"), BARN_HOUSE);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_pyramid"), BIG_PYRAMID);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_jungle_pyramid"), JUNGLE_PYRAMID);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_tcity"), THE_CASTLE_IN_THE_SKY);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_villager_tower"), VILLAGER_TOWER);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_savanna_village_tower"), SAVANNA_VILLAGER_TOWER);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_villager_market"), VILLAGER_MARKET);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_pillager_factory"), PILLAGER_FACTORY);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_plains_abandoned_church"), PLAINS_ABANDONED_CHURCH);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_savanna_abandoned_church"), SAVANNA_ABANDONED_CHURCH);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_desert_abandoned_church"), DESERT_ABANDONED_CHURCH);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_snowy_abandoned_church"), SNOWY_ABANDONED_CHURCH);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_taiga_abandoned_church"), TAIGA_ABANDONED_CHURCH);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_ice_tower"), ICE_TOWER);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_boar_hat_tavern"), TAVERN);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_killer_bunny_castle"), KILLER_BUNNY_CASTLE);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_pirate_ship"), PIRATE_SHIP);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_light_house"), LIGHTHOUSE);
        //Registry.register( WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_volcanic_vent"), VOLCANIC_VENT);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_moai"), MOAI);
        Registry.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_air_balloon"), AIR_BALLOON);
        //Registry.register( WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, MoStructures.id("configuredd_villager_bazaar"), VILLAGE_BAZAAR);
    }

}
