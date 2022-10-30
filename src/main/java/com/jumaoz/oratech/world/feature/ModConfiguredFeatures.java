package com.jumaoz.oratech.world.feature;

import com.jumaoz.oratech.OraTech;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_IRIDIUM_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,OraTech.IRIDIUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,OraTech.DEEPSTALTE_IRIDIUM_ORE.getDefaultState())
    );
    public static final List<OreFeatureConfig.Target> OVERWORLD_TIN_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,OraTech.TIN_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,OraTech.DEEPSTALE_TIN_ORE.getDefaultState())
    );
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> IRIDIUM_ORE =
            ConfiguredFeatures.register("iridium_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_IRIDIUM_ORE, 3));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TIN_ORE =
            ConfiguredFeatures.register("tin_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_TIN_ORE, 9));
    public static void registerConfiguredFeatures(){
        OraTech.LOGGER.debug("Registering the ConfiguredFeatures");
    }
}
