package io.github.frqnny.mostructures.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MoStructuresConfig {
    public final ConfigHelper.ConfigValueListener<Boolean> abandonedChurch;
    public final ConfigHelper.ConfigValueListener<Integer> abandonedChurch_separation;
    public final ConfigHelper.ConfigValueListener<Integer> abandonedChurch_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> airBalloon;
    public final ConfigHelper.ConfigValueListener<Integer> airBalloon_separation;
    public final ConfigHelper.ConfigValueListener<Integer> airBalloon_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> barnHouse;
    public final ConfigHelper.ConfigValueListener<Integer> barnHouse_separation;
    public final ConfigHelper.ConfigValueListener<Integer> barnHouse_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> bigPyramid;
    public final ConfigHelper.ConfigValueListener<Integer> bigPyramid_separation;
    public final ConfigHelper.ConfigValueListener<Integer> bigPyramid_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> tavern;
    public final ConfigHelper.ConfigValueListener<Integer> tavern_separation;
    public final ConfigHelper.ConfigValueListener<Integer> tavern_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> iceTower;
    public final ConfigHelper.ConfigValueListener<Integer> iceTower_separation;
    public final ConfigHelper.ConfigValueListener<Integer> iceTower_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> junglePyramid;
    public final ConfigHelper.ConfigValueListener<Integer> junglePyramid_separation;
    public final ConfigHelper.ConfigValueListener<Integer> junglePyramid_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> killerBunnyCastle;
    public final ConfigHelper.ConfigValueListener<Integer> killerBunnyCastle_separation;
    public final ConfigHelper.ConfigValueListener<Integer> killerBunnyCastle_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> lighthouse;
    public final ConfigHelper.ConfigValueListener<Integer> lighthouse_separation;
    public final ConfigHelper.ConfigValueListener<Integer> lighthouse_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> moai;
    public final ConfigHelper.ConfigValueListener<Integer> moai_separation;
    public final ConfigHelper.ConfigValueListener<Integer> moai_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> pillagerFactory;
    public final ConfigHelper.ConfigValueListener<Integer> pillagerFactory_separation;
    public final ConfigHelper.ConfigValueListener<Integer> pillagerFactory_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> pirateShip;
    public final ConfigHelper.ConfigValueListener<Integer> pirateShip_separation;
    public final ConfigHelper.ConfigValueListener<Integer> pirateShip_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> theCastleInTheSky;
    public final ConfigHelper.ConfigValueListener<Integer> theCastleInTheSky_separation;
    public final ConfigHelper.ConfigValueListener<Integer> theCastleInTheSky_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> villagerMarket;
    public final ConfigHelper.ConfigValueListener<Integer> villagerMarket_separation;
    public final ConfigHelper.ConfigValueListener<Integer> villagerMarket_spacing;

    public final ConfigHelper.ConfigValueListener<Boolean> villagerTower;
    public final ConfigHelper.ConfigValueListener<Integer> villagerTower_separation;
    public final ConfigHelper.ConfigValueListener<Integer> villagerTower_spacing;

    public MoStructuresConfig(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber) {

        builder.push("Abandoned Church");
        abandonedChurch = booleanConfigValue(builder, subscriber, "Abandoned Church Activation", "abandonedChurch", true);
        abandonedChurch_separation = integerConfigValue(builder, subscriber, "Abandoned Church Separation", "abandonedChurch_separation", 14);
        abandonedChurch_spacing = integerConfigValue(builder, subscriber, "Abandoned Church Spacing", "abandonedChurch_spacing", 38);
        builder.pop();

        builder.push("Barn House");
        barnHouse = booleanConfigValue(builder, subscriber, "Barn House Activation", "barnHouse", true);
        barnHouse_separation = integerConfigValue(builder, subscriber, "Barn House Separation", "barnHouse_separation", 8);
        barnHouse_spacing = integerConfigValue(builder, subscriber, "Barn House Spacing", "barnHouse_spacing", 38);
        builder.pop();

        builder.push("Big Pyramid");
        bigPyramid = booleanConfigValue(builder, subscriber, "Big Pyramid Activation", "bigPyramid", true);
        bigPyramid_separation = integerConfigValue(builder, subscriber, "Big Pyramid Separation", "bigPyramid_separation", 5);
        bigPyramid_spacing = integerConfigValue(builder, subscriber, "Big Pyramid Spacing", "bigPyramid_spacing", 25);
        builder.pop();

        builder.push("Jungle Pyramid");
        junglePyramid = booleanConfigValue(builder, subscriber, "Jungle Pyramid Activation", "junglePyramid", true);
        junglePyramid_separation = integerConfigValue(builder, subscriber, "Jungle Pyramid Separation", "junglePyramid_separation", 5);
        junglePyramid_spacing = integerConfigValue(builder, subscriber, "Jungle Pyramid Spacing", "junglePyramid_spacing", 25);
        builder.pop();

        builder.push("The Castle In The Sky");
        theCastleInTheSky = booleanConfigValue(builder, subscriber, "The Castle In The Sky Activation", "theCastleInTheSky", true);
        theCastleInTheSky_separation = integerConfigValue(builder, subscriber, "The Castle In The Sky Separation", "theCastleInTheSky_separation", 8);
        theCastleInTheSky_spacing = integerConfigValue(builder, subscriber, "The Castle In The Sky Spacing", "theCastleInTheSky_spacing", 30);
        builder.pop();

        builder.push("Killer Bunny Castle");
        killerBunnyCastle = booleanConfigValue(builder, subscriber, "Killer Bunny Castle Activation", "killerBunnyCastle", true);
        killerBunnyCastle_separation = integerConfigValue(builder, subscriber, "Killer Bunny Castle Separation", "killerBunnyCastle_separation", 25);
        killerBunnyCastle_spacing = integerConfigValue(builder, subscriber, "Killer Bunny Castle Spacing", "killerBunnyCastle_spacing", 45);
        builder.pop();

        builder.push("Villager Tower");
        villagerTower = booleanConfigValue(builder, subscriber, "Villager Tower Activation", "villagerTower", true);
        villagerTower_separation = integerConfigValue(builder, subscriber, "Villager Tower Separation", "villagerTower_separation", 16);
        villagerTower_spacing = integerConfigValue(builder, subscriber, "Villager Tower Spacing", "villagerTower_spacing", 34);
        builder.pop();

        builder.push("Villager Market");
        villagerMarket = booleanConfigValue(builder, subscriber, "Villager Market Activation", "villagerMarket", true);
        villagerMarket_separation = integerConfigValue(builder, subscriber, "Villager Market Separation", "villagerMarket_separation", 16);
        villagerMarket_spacing = integerConfigValue(builder, subscriber, "Villager Market Spacing", "villagerMarket_spacing", 36);
        builder.pop();

        builder.push("Pillager Factory");
        pillagerFactory = booleanConfigValue(builder, subscriber, "Pillager Factory Activation", "pillagerFactory", true);
        pillagerFactory_separation = integerConfigValue(builder, subscriber, "Pillager Factory Separation", "pillagerFactory_separation", 16);
        pillagerFactory_spacing = integerConfigValue(builder, subscriber, "Pillager Factory Spacing", "pillagerFactory_spacing", 36);
        builder.pop();

        builder.push("Ice Tower");
        iceTower = booleanConfigValue(builder, subscriber, "Ice Tower Activation", "iceTower", true);
        iceTower_separation = integerConfigValue(builder, subscriber, "Ice Tower Separation", "iceTower_separation", 8);
        iceTower_spacing = integerConfigValue(builder, subscriber, "Ice Tower Spacing", "iceTower_spacing", 28);
        builder.pop();

        builder.push("Tavern");
        tavern = booleanConfigValue(builder, subscriber, "Tavern Activation", "tavern", true);
        tavern_separation = integerConfigValue(builder, subscriber, "Tavern Separation", "tavern_separation", 12);
        tavern_spacing = integerConfigValue(builder, subscriber, "Tavern Spacing", "tavern_spacing", 32);
        builder.pop();

        builder.push("Pirate Ship");
        pirateShip = booleanConfigValue(builder, subscriber, "Pirate Ship Activation", "pirateShip", true);
        pirateShip_separation = integerConfigValue(builder, subscriber, "Pirate Ship Separation", "pirateShip_separation", 16);
        pirateShip_spacing = integerConfigValue(builder, subscriber, "Pirate Ship Spacing", "pirateShip_spacing", 40);
        builder.pop();

        builder.push("Lighthouse");
        lighthouse = booleanConfigValue(builder, subscriber, "Lighthouse Activation", "lighthouse", true);
        lighthouse_separation = integerConfigValue(builder, subscriber, "Lighthouse Separation", "lighthouse_separation", 16);
        lighthouse_spacing = integerConfigValue(builder, subscriber, "Lighthouse Spacing", "lighthouse_spacing", 32);
        builder.pop();

        builder.push("Moai");
        moai = booleanConfigValue(builder, subscriber, "Moai Activation", "moai", true);
        moai_separation = integerConfigValue(builder, subscriber, "Moai Separation", "moai_separation", 2);
        moai_spacing = integerConfigValue(builder, subscriber, "Moai Spacing", "moai_spacing", 4);
        builder.pop();

        builder.push("Air Balloon");
        airBalloon = booleanConfigValue(builder, subscriber, "Air Balloon Activation", "airBalloon", true);
        airBalloon_separation = integerConfigValue(builder, subscriber, "Air Balloon Separation", "airBalloon_separation", 1);
        airBalloon_spacing = integerConfigValue(builder, subscriber, "Air Balloon Spacing", "airBalloon_spacing", 6);
        builder.pop();

        builder.build();

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
