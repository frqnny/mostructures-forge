package io.github.frqnny.mostructures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.github.frqnny.mostructures.config.MoStructuresConfig;
import io.github.frqnny.mostructures.feature.VillagerEntityFeature;
import io.github.frqnny.mostructures.processor.*;
import io.github.frqnny.mostructures.structure.*;
import io.github.frqnny.mostructures.util.RegUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

public class MoStructures {
    public static final String MODID = "mostructures";
    public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, MODID);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MODID);
    public static final RegistryObject<Feature<NoFeatureConfig>> VILLAGER_SPAWN = FEATURES.register(VillagerEntityFeature.ID.getPath(), VillagerEntityFeature::new);
    public static final RegistryObject<Structure<VillageConfig>> BARN_HOUSE = STRUCTURES.register(BarnHouseStructure.ID.getPath(), BarnHouseStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> BIG_PYRAMID = STRUCTURES.register(BigPyramidStructure.ID.getPath(), BigPyramidStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> JUNGLE_PYRAMID = STRUCTURES.register(JunglePyramidStructure.ID.getPath(), JunglePyramidStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> THE_CASTLE_IN_THE_SKY = STRUCTURES.register(TheCastleInTheSkyStructure.ID.getPath(), TheCastleInTheSkyStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> VILLAGER_TOWER = STRUCTURES.register(VillagerTowerStructure.ID.getPath(), VillagerTowerStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> VILLAGER_MARKET = STRUCTURES.register(VillagerMarketStructure.ID.getPath(), VillagerMarketStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> PILLAGER_FACTORY = STRUCTURES.register(PillagerFactoryStructure.ID.getPath(), PillagerFactoryStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> ABANDONED_CHURCH = STRUCTURES.register(AbandonedChurchStructure.ID.getPath(), AbandonedChurchStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> ICE_TOWER = STRUCTURES.register(IceTowerStructure.ID.getPath(), IceTowerStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> TAVERN = STRUCTURES.register(TavernStructure.ID.getPath(), TavernStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> KILLER_BUNNY_CASTLE = STRUCTURES.register(KillerBunnyCastleStructure.ID.getPath(), KillerBunnyCastleStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> PIRATE_SHIP = STRUCTURES.register(PirateShipStructure.ID.getPath(), PirateShipStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> LIGHTHOUSE = STRUCTURES.register(LighthouseStructure.ID.getPath(), LighthouseStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> MOAI = STRUCTURES.register(MoaiStructure.ID.getPath(), MoaiStructure::new);
    public static final RegistryObject<Structure<VillageConfig>> AIR_BALLOON = STRUCTURES.register(AirBalloonStructure.ID.getPath(), AirBalloonStructure::new);
    public static final IStructureProcessorType<SimpleStoneStructureProcessor> SIMPLE_STONE = IStructureProcessorType.register("jungle_rot_processor", SimpleStoneStructureProcessor.CODEC);
    public static final IStructureProcessorType<SimpleCobblestoneProcessor> SIMPLE_COBBLESTONE = IStructureProcessorType.register("simple_cobblestone", SimpleCobblestoneProcessor.CODEC);
    public static final IStructureProcessorType<DataBlockStructureProcessor> DATA_BLOCK_STRUCTURE_PROCESSOR = IStructureProcessorType.register("data_block_structure_processor", DataBlockStructureProcessor.CODEC);
    public static final IStructureProcessorType<AirStructureProcessor> AIR_STRUCTURE_PROCESSOR = IStructureProcessorType.register("air_structure_processor", AirStructureProcessor.CODEC);
    public static final IStructureProcessorType<RemoveWaterloggedProcessor> REMOVE_WATERLOGGED = IStructureProcessorType.register("remove_waterlog_processor", RemoveWaterloggedProcessor.CODEC);
    public static final StructureProcessorList JUNGLE_ROT_LIST = RegUtils.registerStructureProcessor("jungle_rot", ImmutableList.of(
            new SimpleStoneStructureProcessor(0.15F)
    ));
    public static final StructureProcessorList ICE_TOWER_LIST = RegUtils.registerStructureProcessor("ice_tower_rot", ImmutableList.of(
            new SimpleStoneStructureProcessor(0)
    ));
    public static final StructureProcessorList VILLAGER_TOWER_LIST = RegUtils.registerStructureProcessor("villager_tower_rot", ImmutableList.of(
            new SimpleCobblestoneProcessor(0.15F)
    ));
    public static final StructureProcessorList PIRATE_SHIP_LIST = RegUtils.registerStructureProcessor("simple_air_keep_list", ImmutableList.of(
            new AirStructureProcessor(),
            new RemoveWaterloggedProcessor()
    ));
    public static MoStructuresConfig CONFIG;

    public static void register() {
        setupMapSpacingAndLand(BARN_HOUSE.get(), CONFIG.barnHouse_separation.get(), CONFIG.barnHouse_spacing.get(), 165757306, true);
        setupMapSpacingAndLand(BIG_PYRAMID.get(), CONFIG.bigPyramid_separation.get(), CONFIG.bigPyramid_spacing.get(), 239284294, true);
        setupMapSpacingAndLand(JUNGLE_PYRAMID.get(), CONFIG.junglePyramid_separation.get(), CONFIG.junglePyramid_spacing.get(), 312178642, true);
        setupMapSpacingAndLand(THE_CASTLE_IN_THE_SKY.get(), CONFIG.theCastleInTheSky_separation.get(), CONFIG.theCastleInTheSky_spacing.get(), 423494938, false);
        setupMapSpacingAndLand(VILLAGER_TOWER.get(), CONFIG.villagerTower_separation.get(), CONFIG.villagerTower_spacing.get(), 550292492, true);
        setupMapSpacingAndLand(ABANDONED_CHURCH.get(), CONFIG.abandonedChurch_separation.get(), CONFIG.abandonedChurch_spacing.get(), 669968400, true);
        setupMapSpacingAndLand(VILLAGER_MARKET.get(), CONFIG.villagerMarket_separation.get(), CONFIG.villagerMarket_spacing.get(), 784939542, true);
        setupMapSpacingAndLand(PILLAGER_FACTORY.get(), CONFIG.pillagerFactory_separation.get(), CONFIG.villagerMarket_spacing.get(), 839204924, true);
        setupMapSpacingAndLand(ICE_TOWER.get(), CONFIG.iceTower_separation.get(), CONFIG.iceTower_spacing.get(), 964058305, true);
        setupMapSpacingAndLand(TAVERN.get(), CONFIG.tavern_separation.get(), CONFIG.tavern_spacing.get(), 19296726, true);
        setupMapSpacingAndLand(KILLER_BUNNY_CASTLE.get(), CONFIG.killerBunnyCastle_separation.get(), CONFIG.killerBunnyCastle_spacing.get(), 29573969, true);
        setupMapSpacingAndLand(PIRATE_SHIP.get(), CONFIG.pirateShip_separation.get(), CONFIG.pirateShip_spacing.get(), 583957395, false);
        setupMapSpacingAndLand(LIGHTHOUSE.get(), CONFIG.lighthouse_separation.get(), CONFIG.lighthouse_spacing.get(), 29502322, false);
        setupMapSpacingAndLand(AIR_BALLOON.get(), CONFIG.airBalloon_separation.get(), CONFIG.airBalloon_spacing.get(), 12994829, false);
        setupMapSpacingAndLand(MOAI.get(), CONFIG.moai_separation.get(), CONFIG.moai_spacing.get(), 22494869, false);

    }

    public static void putStructures(final BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();

        switch (category) {
            case PLAINS:
                add(event, ConfiguredFeatures.KILLER_BUNNY_CASTLE, CONFIG.killerBunnyCastle.get());
                add(event, ConfiguredFeatures.TAVERN, CONFIG.tavern.get());
                add(event, ConfiguredFeatures.PLAINS_ABANDONED_CHURCH, CONFIG.abandonedChurch.get());
                add(event, ConfiguredFeatures.PILLAGER_FACTORY, CONFIG.pillagerFactory.get());
                add(event, ConfiguredFeatures.VILLAGER_MARKET, CONFIG.villagerMarket.get());
                add(event, ConfiguredFeatures.VILLAGER_TOWER, CONFIG.villagerTower.get());
                add(event, ConfiguredFeatures.BARN_HOUSE, CONFIG.barnHouse.get());
            case SAVANNA:
                add(event, ConfiguredFeatures.KILLER_BUNNY_CASTLE, CONFIG.killerBunnyCastle.get());
                add(event, ConfiguredFeatures.SAVANNA_ABANDONED_CHURCH, CONFIG.abandonedChurch.get());
                add(event, ConfiguredFeatures.VILLAGER_MARKET, CONFIG.villagerMarket.get());
                add(event, ConfiguredFeatures.SAVANNA_VILLAGER_TOWER, CONFIG.villagerTower.get());
                add(event, ConfiguredFeatures.BARN_HOUSE, CONFIG.barnHouse.get());
            case FOREST:
                add(event, ConfiguredFeatures.KILLER_BUNNY_CASTLE, CONFIG.killerBunnyCastle.get());
                add(event, ConfiguredFeatures.TAVERN, CONFIG.tavern.get());
                add(event, ConfiguredFeatures.VILLAGER_MARKET, CONFIG.villagerMarket.get());
                add(event, ConfiguredFeatures.VILLAGER_TOWER, CONFIG.villagerTower.get());
            case BEACH:
                add(event, ConfiguredFeatures.AIR_BALLOON, CONFIG.airBalloon.get());
                add(event, ConfiguredFeatures.MOAI, CONFIG.moai.get());
                add(event, ConfiguredFeatures.LIGHTHOUSE, CONFIG.lighthouse.get());
                add(event, ConfiguredFeatures.THE_CASTLE_IN_THE_SKY, CONFIG.theCastleInTheSky.get());
            case ICY:
                add(event, ConfiguredFeatures.ICE_TOWER, CONFIG.iceTower.get());
                add(event, ConfiguredFeatures.SNOWY_ABANDONED_CHURCH, CONFIG.abandonedChurch.get());
                add(event, ConfiguredFeatures.PILLAGER_FACTORY, CONFIG.pillagerFactory.get());
            case TAIGA:
                add(event, ConfiguredFeatures.TAIGA_ABANDONED_CHURCH, CONFIG.abandonedChurch.get());
                add(event, ConfiguredFeatures.PILLAGER_FACTORY, CONFIG.pillagerFactory.get());
            case OCEAN:
                add(event, ConfiguredFeatures.PIRATE_SHIP, CONFIG.pirateShip.get());
            case DESERT:
                add(event, ConfiguredFeatures.DESERT_ABANDONED_CHURCH, CONFIG.abandonedChurch.get());
                add(event, ConfiguredFeatures.BIG_PYRAMID, CONFIG.bigPyramid.get());

            case JUNGLE:
                add(event, ConfiguredFeatures.JUNGLE_PYRAMID, CONFIG.junglePyramid.get());

        }
    }

    public static void add(final BiomeLoadingEvent e, StructureFeature<?, ?> s, boolean config) {
        if (config) {
            e.getGeneration().getStructures().add(Lazy.of(() -> s));
        }
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, int separation, int spacing, int salt, boolean transformSurroundingLand) {
        setupMapSpacingAndLand(structure, new StructureSeparationSettings(separation, spacing, salt), transformSurroundingLand);
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {

        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);


        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<Structure<?>>builder()
                            .addAll(Structure.NOISE_AFFECTING_FEATURES)
                            .add(structure)
                            .build();
        }


        DimensionStructuresSettings.DEFAULTS =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.DEFAULTS)
                        .put(structure, structureSeparationSettings)
                        .build();

        WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();


            if (structureMap instanceof ImmutableMap) {
                Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureSeparationSettings);
                settings.getValue().structureSettings().structureConfig = tempMap;
            } else {
                structureMap.put(structure, structureSeparationSettings);
            }
        });
    }

    public static ResourceLocation id(String namespace) {
        return new ResourceLocation(MODID, namespace);
    }
}
