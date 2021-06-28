package io.github.frqnny.mostructures.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MoStructuresConfig {
    public ConfigHelper.ConfigValueListener<Boolean> abandonedChurch;
    public ConfigHelper.ConfigValueListener<Integer> abandonedChurch_separation;
    public ConfigHelper.ConfigValueListener<Integer> abandonedChurch_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> airBalloon;
    public ConfigHelper.ConfigValueListener<Integer> airBalloon_separation;
    public ConfigHelper.ConfigValueListener<Integer> airBalloon_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> barnHouse;
    public ConfigHelper.ConfigValueListener<Integer> barnHouse_separation;
    public ConfigHelper.ConfigValueListener<Integer> barnHouse_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> bigPyramid;
    public ConfigHelper.ConfigValueListener<Integer> bigPyramid_separation;
    public ConfigHelper.ConfigValueListener<Integer> bigPyramid_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> tavern;
    public ConfigHelper.ConfigValueListener<Integer> tavern_separation;
    public ConfigHelper.ConfigValueListener<Integer> tavern_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> iceTower;
    public ConfigHelper.ConfigValueListener<Integer> iceTower_separation;
    public ConfigHelper.ConfigValueListener<Integer> iceTower_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> junglePyramid;
    public ConfigHelper.ConfigValueListener<Integer> junglePyramid_separation;
    public ConfigHelper.ConfigValueListener<Integer> junglePyramid_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> killerBunnyCastle;
    public ConfigHelper.ConfigValueListener<Integer> killerBunnyCastle_separation;
    public ConfigHelper.ConfigValueListener<Integer> killerBunnyCastle_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> lighthouse;
    public ConfigHelper.ConfigValueListener<Integer> lighthouse_separation;
    public ConfigHelper.ConfigValueListener<Integer> lighthouse_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> moai;
    public ConfigHelper.ConfigValueListener<Integer> moai_separation;
    public ConfigHelper.ConfigValueListener<Integer> moai_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> pillagerFactory;
    public ConfigHelper.ConfigValueListener<Integer> pillagerFactory_separation;
    public ConfigHelper.ConfigValueListener<Integer> pillagerFactory_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> pirateShip;
    public ConfigHelper.ConfigValueListener<Integer> pirateShip_separation;
    public ConfigHelper.ConfigValueListener<Integer> pirateShip_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> theCastleInTheSky;
    public ConfigHelper.ConfigValueListener<Integer> theCastleInTheSky_separation;
    public ConfigHelper.ConfigValueListener<Integer> theCastleInTheSky_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> villagerMarket;
    public ConfigHelper.ConfigValueListener<Integer> villagerMarket_separation;
    public ConfigHelper.ConfigValueListener<Integer> villagerMarket_spacing;

    public ConfigHelper.ConfigValueListener<Boolean> villagerTower;
    public ConfigHelper.ConfigValueListener<Integer> villagerTower_separation;
    public ConfigHelper.ConfigValueListener<Integer> villagerTower_spacing;

    public MoStructuresConfig(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber) {
        builder.push("Welcome to Mo' Structures Config! You can turn off structures and edit gen values here.");
        builder.push("Abandoned Church Generator");
        abandonedChurch = booleanConfigValue(builder, subscriber, "Abandoned Church Activation", "abandonedChurch", true);
        abandonedChurch_separation = integerConfigValue(builder, subscriber, "Abandoned Church Separation", "abandonedChurch_separation", 14);
        abandonedChurch_spacing = integerConfigValue(builder, subscriber, "Abandoned Church Spacing","abandonedChurch_spacing", 38);

        barnHouse = booleanConfigValue(builder, subscriber, "Barn House Activation", "barnHouse", true);
        barnHouse_separation = integerConfigValue(builder, subscriber, "Barn House Separation", "barnHouse_separation", 8);
        barnHouse_spacing = integerConfigValue(builder, subscriber, "Barn House Spacing","barnHouse_spacing", 38);

        bigPyramid = booleanConfigValue(builder, subscriber, "Big Pyramid Activation", "bigPyramid", true);
        bigPyramid_separation = integerConfigValue(builder, subscriber, "Big Pyramid Separation", "bigPyramid_separation", 5);
        bigPyramid_spacing = integerConfigValue(builder, subscriber, "Big Pyramid Spacing","bigPyramid_spacing", 25);

        junglePyramid = booleanConfigValue(builder, subscriber, "Jungle Pyramid Activation", "junglePyramid", true);
        junglePyramid_separation = integerConfigValue(builder, subscriber, "Jungle Pyramid Separation", "junglePyramid_separation", 5);
        junglePyramid_spacing = integerConfigValue(builder, subscriber, "Jungle Pyramid Spacing","junglePyramid_spacing", 25);

        theCastleInTheSky = booleanConfigValue(builder, subscriber, "The Castle In The Sky Activation", "theCastleInTheSky", true);
        theCastleInTheSky_separation = integerConfigValue(builder, subscriber, "The Castle In The Sky Separation", "theCastleInTheSky_separation", 8);
        theCastleInTheSky_spacing = integerConfigValue(builder, subscriber, "The Castle In The Sky Spacing","theCastleInTheSky_spacing", 30);

        killerBunnyCastle = booleanConfigValue(builder, subscriber, "Killer Bunny Castle Activation", "killerBunnyCastle", true);
        killerBunnyCastle_separation = integerConfigValue(builder, subscriber, "Killer Bunny Castle Separation", "killerBunnyCastle_separation", 25);
        killerBunnyCastle_spacing = integerConfigValue(builder, subscriber, "Killer Bunny Castle Spacing","killerBunnyCastle_spacing", 45);

        villagerTower = booleanConfigValue(builder, subscriber, "Abandoned Church Activation", "villagerTower", true);
        villagerTower_separation = integerConfigValue(builder, subscriber, "Villager Tower Separation", "villagerTower_separation", 16);
        villagerTower_spacing = integerConfigValue(builder, subscriber, "Villager Tower Spacing","villagerTower_spacing", 34);

        villagerMarket = booleanConfigValue(builder, subscriber, "Villager Market Activation", "villagerMarket", true);
        villagerMarket_separation = integerConfigValue(builder, subscriber, "Villager Market Separation", "villagerMarket_separation", 16);
        villagerMarket_spacing = integerConfigValue(builder, subscriber, "Villager Market Spacing","villagerMarket_spacing", 36);

        pillagerFactory = booleanConfigValue(builder, subscriber, "Pillager Factory Activation", "pillagerFactory", true);
        pillagerFactory_separation = integerConfigValue(builder, subscriber, "Pillager Factory Separation", "pillagerFactory_separation", 16);
        pillagerFactory_spacing = integerConfigValue(builder, subscriber, "Pillager Factory Spacing","pillagerFactory_spacing", 36);

        iceTower = booleanConfigValue(builder, subscriber, "Ice Tower Activation", "iceTower", true);
        iceTower_separation = integerConfigValue(builder, subscriber, "Ice Tower Separation", "iceTower_separation", 8);
        iceTower_spacing = integerConfigValue(builder, subscriber, "Ice Tower Spacing","iceTower_spacing", 28);

        tavern = booleanConfigValue(builder, subscriber, "Tavern Activation", "tavern", true);
        tavern_separation = integerConfigValue(builder, subscriber, "Tavern Separation", "tavern_separation", 12);
        tavern_spacing = integerConfigValue(builder, subscriber, "Tavern Spacing","tavern_spacing", 32);

        pirateShip = booleanConfigValue(builder, subscriber, "Pirate Ship Activation", "pirateShip", true);
        pirateShip_separation = integerConfigValue(builder, subscriber, "Pirate Ship Separation", "pirateShip_separation", 16);
        pirateShip_spacing = integerConfigValue(builder, subscriber, "Pirate Ship Spacing","pirateShip_spacing", 40);

        lighthouse = booleanConfigValue(builder, subscriber, "Lighthouse Activation", "lighthouse", true);
        lighthouse_separation = integerConfigValue(builder, subscriber, "Lighthouse Separation", "lighthouse_separation", 16);
        lighthouse_spacing = integerConfigValue(builder, subscriber, "Lighthouse Spacing","lighthouse_spacing", 32);

        moai = booleanConfigValue(builder, subscriber, "Moai Activation", "moai", true);
        moai_separation = integerConfigValue(builder, subscriber, "Moai Separation", "moai_separation", 2);
        moai_spacing = integerConfigValue(builder, subscriber, "Moai Spacing","moai_spacing", 4);

        airBalloon = booleanConfigValue(builder, subscriber, "Air Balloon Activation", "airBalloon", true);
        airBalloon_separation = integerConfigValue(builder, subscriber, "Air Balloon Separation", "airBalloon_separation", 1);
        airBalloon_spacing = integerConfigValue(builder, subscriber, "Air Balloon Spacing","airBalloon_spacing", 6);



    }



    public static ConfigHelper.ConfigValueListener<Boolean> booleanConfigValue(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber, String comment, String name, boolean value) {
        return subscriber.subscribe(builder
                .comment(comment)
                .define(name, value)
        );
    }

    public static ConfigHelper.ConfigValueListener<Integer> integerConfigValue(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber, String comment, String name, int value) {
        return subscriber.subscribe(builder
                .comment(comment)
                .define(name, value)
        );
    }
}
