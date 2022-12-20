package net.archasmiel.thaumcraft.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.block.ModBlockRegister;
import net.archasmiel.thaumcraft.item.item.ModItemRegister;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroupSet {
    public static void createItemGroup(){
        final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier(Thaumcraft.MOD_ID, "item_group"))
                .icon(() -> new ItemStack(ModItemRegister.GOGGLESREVEALING))
                .entries((enabledFeatures, entries, operatorEnabled) -> {
                    entries.add(ModItemRegister.TESTWAND);
                    entries.add(ModBlockRegister.ARCANE_WORKBENCH);
                    entries.add(ModItemRegister.ALUMENTUM);
                    entries.add(ModItemRegister.AMBER);
                    entries.add(ModItemRegister.BATH_SALTS);
                    entries.add(ModItemRegister.BAUBLE_AMULET);
                    entries.add(ModItemRegister.BAUBLE_BELT);
                    entries.add(ModItemRegister.BAUBLE_RING);
                    entries.add(ModItemRegister.BAUBLE_RING_IRON);
                    entries.add(ModItemRegister.BOOTSTRAVELER);
                    entries.add(ModItemRegister.BRAIN);
                    entries.add(ModItemRegister.BOTTLE_TAINT);
                    entries.add(ModItemRegister.BUCKET_DEATH);
                    entries.add(ModItemRegister.BUCKET_PURE);
                    entries.add(ModItemRegister.CHARM);
                    entries.add(ModItemRegister.BONEBOW);
                    entries.add(ModItemRegister.CLOTH);
                    entries.add(ModItemRegister.CLOTHBOOTS);
                    entries.add(ModItemRegister.CLOTHBOOTSOVER);
                    entries.add(ModItemRegister.CLOTHCHEST);
                    entries.add(ModItemRegister.CLOTHCHEATOVER);
                    entries.add(ModItemRegister.CLOTHLEGS);
                    entries.add(ModItemRegister.CLOTHLEGSOVER);
                    entries.add(ModItemRegister.CLUSTERCINNABAR);
                    entries.add(ModItemRegister.CLUSTERCOPPER);
                    entries.add(ModItemRegister.CLUSTERGOLD);
                    entries.add(ModItemRegister.CLUSTERIRON);
                    entries.add(ModItemRegister.CLUSTERLEAD);
                    entries.add(ModItemRegister.CLUSTERSILVER);
                    entries.add(ModItemRegister.CLUSTERTIN);
                    entries.add(ModItemRegister.COIN);
                    entries.add(ModItemRegister.CRIMSON_BLADE);
                    entries.add(ModItemRegister.CRIMSON_RITES);
                    entries.add(ModItemRegister.CRYSTALESSENCE);
                    entries.add(ModItemRegister.CULTISTBOOTS);
                    entries.add(ModItemRegister.CULTISTPLATECHEST);
                    entries.add(ModItemRegister.CULTISTPLATEHELM);
                    entries.add(ModItemRegister.CULTISTPLATELEADERCHEST);
                    entries.add(ModItemRegister.CULTSTPLATELEADERHELM);
                    entries.add(ModItemRegister.CULTISTPLATELEADERLEGS);
                    entries.add(ModItemRegister.CULTISTPLATELEGS);
                    entries.add(ModItemRegister.CULTISTROBECHEST);
                    entries.add(ModItemRegister.CULTISTROBEHELM);
                    entries.add(ModItemRegister.CULTISTROBELEGS);
                    entries.add(ModItemRegister.DISCOVERY);
                    entries.add(ModItemRegister.DUST);
                    entries.add(ModItemRegister.EL_ARROW_AIR);
                    entries.add(ModItemRegister.EL_ARROW_EATRH);
                    entries.add(ModItemRegister.EL_ARROW_ENTROPY);
                    entries.add(ModItemRegister.EL_ARROW_FIRE);
                    entries.add(ModItemRegister.EL_ARROW_ORDER);
                    entries.add(ModItemRegister.EL_ARROW_WATER);
                    entries.add(ModItemRegister.ELDRITCH_OBJECT);
                    entries.add(ModItemRegister.ELDRITCH_OBJECT_2);
                    entries.add(ModItemRegister.ELDRITCH_OBJECT_3);
                    entries.add(ModItemRegister.ELEMENTALAXE);
                    entries.add(ModItemRegister.ELEMENTALHOE);
                    entries.add(ModItemRegister.ELEMENTALPICK);
                    entries.add(ModItemRegister.ELEMENTALSHOVEL);
                    entries.add(ModItemRegister.ELEMENTALSWORD);
                    entries.add(ModItemRegister.ESSENCE);
                    entries.add(ModItemRegister.FILTER);
                    entries.add(ModItemRegister.FOCUS);
                    entries.add(ModItemRegister.FOCUS_EXCAVATION);
                    entries.add(ModItemRegister.FOCUS_FIRE);
                    entries.add(ModItemRegister.FOCUS_FROST);
                    entries.add(ModItemRegister.FOCUS_HELLBAT);
                    entries.add(ModItemRegister.FOCUS_HELLBAT_ORN);
                    entries.add(ModItemRegister.FOCUS_PECH);
                    entries.add(ModItemRegister.FOCUS_PECH_DEPTH);
                    entries.add(ModItemRegister.FOCUS_PORTABLEHOLE);
                    entries.add(ModItemRegister.FOCUS_PORTABLEHOLE_DEPTH);
                    entries.add(ModItemRegister.FOCUS_PRIMAL);
                    entries.add(ModItemRegister.FOCUS_PRIMAL_DEPTH);
                    entries.add(ModItemRegister.FOCUS_REVERSAL);
                    entries.add(ModItemRegister.FOCUS_SHOCK);
                    entries.add(ModItemRegister.FOCUS_TRADE);
                    entries.add(ModItemRegister.FOCUS_TRADE_ORN);
                    entries.add(ModItemRegister.FOCUS_WARDING);
                    entries.add(ModItemRegister.FOCUS_WARDING_DEPTH);
                    entries.add(ModItemRegister.FOCUS_WARDING_ORN);
                    entries.add(ModItemRegister.FOCUS_WHATEVER_ORN);
                    entries.add(ModItemRegister.FOCUS_POUCH);
                    entries.add(ModItemRegister.FOCUS_POUCH_BAUBLE);
                    entries.add(ModItemRegister.GOGGLESREVEALING);
                    entries.add(ModItemRegister.GOLEM_CLAY);
                    entries.add(ModItemRegister.GOLEM_CORE_BLANK);
                    entries.add(ModItemRegister.GOLEM_CORE_BODYGUARD);
                    entries.add(ModItemRegister.GOLEM_CORE_BUTCHER);
                    entries.add(ModItemRegister.GOLEM_CORE_EMPTY);
                    entries.add(ModItemRegister.GOLEM_CORE_ESSENTIA);
                    entries.add(ModItemRegister.GOLEM_CORE_FILL);
                    entries.add(ModItemRegister.GOLEM_CORE_FISH);
                    entries.add(ModItemRegister.GOLEM_CORE_GATHER);
                    entries.add(ModItemRegister.GOLEM_CORE_GUARD);
                    entries.add(ModItemRegister.GOLEM_CORE_HARVEST);
                    entries.add(ModItemRegister.GOLEM_CORE_LIQUID);
                    entries.add(ModItemRegister.GOLEM_CORE_LUMBER);
                    entries.add(ModItemRegister.GOLEM_CORE_PATROL);
                    entries.add(ModItemRegister.GOLEM_CORE_SORTING);
                    entries.add(ModItemRegister.GOLEM_CORE_USE);
                    entries.add(ModItemRegister.GOLEM_FLESH);
                    entries.add(ModItemRegister.GOLEM_IRON);
                    entries.add(ModItemRegister.GOLEM_OVER_ADV);
                    entries.add(ModItemRegister.GOLEM_OVER_CORE);
                    entries.add(ModItemRegister.GOLEM_STONE);
                    entries.add(ModItemRegister.GOLEM_STRAW);
                    entries.add(ModItemRegister.GOLEM_TALLOW);
                    entries.add(ModItemRegister.GOLEM_THAUMIUM);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_AIR);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_EARTH);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_EMPTY);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_ENTROPY);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_FIRE);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_ORDER);
                    entries.add(ModItemRegister.GOLEM_UPGRADE_WATER);
                    entries.add(ModItemRegister.GOLEM_WOOD);
                    entries.add(ModItemRegister.GOLEMDECOARMOR);
                    entries.add(ModItemRegister.GOLEMDECOBOWTIE);
                    entries.add(ModItemRegister.GOLEMDECODART);
                    entries.add(ModItemRegister.GOLEMDECOFEZ);
                    entries.add(ModItemRegister.GOLEMDECOGLASSES);
                    entries.add(ModItemRegister.GOLEMDECOMACE);
                    entries.add(ModItemRegister.GOLEMDECOTOPHAT);
                    entries.add(ModItemRegister.GOLEMDECOVISOR);
                    entries.add(ModItemRegister.HOVERGIRDLE);
                    entries.add(ModItemRegister.HOVERHARNESS);
                    entries.add(ModItemRegister.INKWELL);
                    entries.add(ModItemRegister.IRONBELL);
                    entries.add(ModItemRegister.KEYGOLD);
                    entries.add(ModItemRegister.KEYIRON);
                    entries.add(ModItemRegister.KNOWLEDGEFRAGMENT);
                    entries.add(ModItemRegister.LABEL);
                    entries.add(ModItemRegister.LABEL_OVER);
                    entries.add(ModItemRegister.LIGHTNINGRING);
                    entries.add(ModItemRegister.LIGHTNINGRINGV);
                    entries.add(ModItemRegister.LOOTBAG);
                    entries.add(ModItemRegister.LOOTBAGRARE);
                    entries.add(ModItemRegister.LOOTBAGUNC);
                    entries.add(ModItemRegister.MANA_BEAN);
                    entries.add(ModItemRegister.MIRRORFRAME);
                    entries.add(ModItemRegister.MIRRORFRAME2);
                    entries.add(ModItemRegister.MIRRORGLASS);
                    entries.add(ModItemRegister.MIRRORHAND);
                    entries.add(ModItemRegister.NITOR);
                    entries.add(ModItemRegister.NUGGETBEEF);
                    entries.add(ModItemRegister.NUGGETCHICKEN);
                    entries.add(ModItemRegister.NUGGETCOPPER);
                    entries.add(ModItemRegister.NUGGETFISH);
                    entries.add(ModItemRegister.NUGGETIRON);
                    entries.add(ModItemRegister.NUGGETLEAD);
                    entries.add(ModItemRegister.NUGGETPORK);
                    entries.add(ModItemRegister.NUGGETQUICKSILVER);
                    entries.add(ModItemRegister.NUGGETSILVER);
                    entries.add(ModItemRegister.NUGGETTHAUMIUM);
                    entries.add(ModItemRegister.NUGGETTIN);
                    entries.add(ModItemRegister.NUGGETVOID);
                    entries.add(ModItemRegister.OB_PLACER);
                    entries.add(ModItemRegister.PHIAL);
                    entries.add(ModItemRegister.PHIALOVERLAY);
                    entries.add(ModItemRegister.PRIMAL_CRUSHER);
                    entries.add(ModItemRegister.QUICKSILVER);
                    entries.add(ModItemRegister.RESEARCHNOTES);
                    entries.add(ModItemRegister.RESEARCHNOTESOVERLAY);
                    entries.add(ModItemRegister.RESONATOR);
                    entries.add(ModItemRegister.RUNIC_AMULET);
                    entries.add(ModItemRegister.RUNIC_AMULET_EMERGENCY);
                    entries.add(ModItemRegister.RUNIC_GIRDLE);
                    entries.add(ModItemRegister.RUNIC_GIRDLE_KINETIC);
                    entries.add(ModItemRegister.RUNIC_RING);
                    entries.add(ModItemRegister.RUNIC_RING_CHARGED);
                    entries.add(ModItemRegister.RUNIC_RING_LESSER);
                    entries.add(ModItemRegister.RUNIC_RING_REGEN);
                    entries.add(ModItemRegister.SANITYCHECKER);
                    entries.add(ModItemRegister.SHARD);
                    entries.add(ModItemRegister.SHARD_BALANCED);
                    entries.add(ModItemRegister.SINISTER_STONE);
                    entries.add(ModItemRegister.SINISTER_STONE_ACTIVE);
                    entries.add(ModItemRegister.SOAP);
                    entries.add(ModItemRegister.STAFF_ROD_BLAZE);
                    entries.add(ModItemRegister.STAFF_ROD_BONE);
                    entries.add(ModItemRegister.STAFF_ROD_GREATWOOD);
                    entries.add(ModItemRegister.STAFF_ROD_ICE);
                    entries.add(ModItemRegister.STAFF_ROD_OBSIDIAN);
                    entries.add(ModItemRegister.STAFF_ROD_PRIMAL);
                    entries.add(ModItemRegister.STAFF_ROD_QUARTZ);
                    entries.add(ModItemRegister.STAFF_ROD_REED);
                    entries.add(ModItemRegister.STAFF_ROD_SILVERWOOD);
                    entries.add(ModItemRegister.TAINT_SLIME);
                    entries.add(ModItemRegister.TAINT_TENDRIL);
                    entries.add(ModItemRegister.TALLOW);
                    entries.add(ModItemRegister.THAUMIUMAXE);
                    entries.add(ModItemRegister.THAUMIUMBOOTS);
                    entries.add(ModItemRegister.THAUMIUMCHEST);
                    entries.add(ModItemRegister.THAUMIUMFORTRESSCHEST);
                    entries.add(ModItemRegister.THAUMIUMFORTRESSHELM);
                    entries.add(ModItemRegister.THAUMIUMFORTRESSLEGS);
                    entries.add(ModItemRegister.THAUMIUMHELM);
                    entries.add(ModItemRegister.THAUMIUMHOE);
                    entries.add(ModItemRegister.THAUMIUMINGOT);
                    entries.add(ModItemRegister.THAUMIUMLEGS);
                    entries.add(ModItemRegister.THAUMIUMPICK);
                    entries.add(ModItemRegister.THAUMIUMSHOVEL);
                    entries.add(ModItemRegister.THAUMIUMSWORD);
                    entries.add(ModItemRegister.THAUMONOMICON);
                    entries.add(ModItemRegister.THAUMONOMICONCHEAT);
                    entries.add(ModItemRegister.TRIPLETREAT);
                    entries.add(ModItemRegister.VIS_AMULET);
                    entries.add(ModItemRegister.VIS_AMULET_LESSER);
                    entries.add(ModItemRegister.VOIDAXE);
                    entries.add(ModItemRegister.VOIDBOOTS);
                    entries.add(ModItemRegister.VOIDCHEST);
                    entries.add(ModItemRegister.VOIDHELM);
                    entries.add(ModItemRegister.VOIDHOE);
                    entries.add(ModItemRegister.VOIDINGOT);
                    entries.add(ModItemRegister.VOIDLEGS);
                    entries.add(ModItemRegister.VOIDPICK);
                    entries.add(ModItemRegister.VOIDROBECHEST);
                    entries.add(ModItemRegister.VOIDROBECHESTOVER);
                    entries.add(ModItemRegister.VOIDROBEHELM);
                    entries.add(ModItemRegister.VOIDROBELEGS);
                    entries.add(ModItemRegister.VOIDROBELEGSOVER);
                    entries.add(ModItemRegister.VOIDSEED);
                    entries.add(ModItemRegister.VOIDSHOVEL);
                    entries.add(ModItemRegister.VOIDSWORD);
                    entries.add(ModItemRegister.WAND_CAP_COPPER);
                    entries.add(ModItemRegister.WAND_CAP_GOLD);
                    entries.add(ModItemRegister.WAND_CAP_IRON);
                    entries.add(ModItemRegister.WAND_CAP_SILVER);
                    entries.add(ModItemRegister.WAND_CAP_SILVER_INERT);
                    entries.add(ModItemRegister.WAND_CAP_THAUMIUM);
                    entries.add(ModItemRegister.WAND_CAP_THAUMIUM_INERT);
                    entries.add(ModItemRegister.WAND_CAP_VOID);
                    entries.add(ModItemRegister.WAND_CAP_VOID_INERT);
                    entries.add(ModItemRegister.WAND_ROD_BLAZE);
                    entries.add(ModItemRegister.WAND_ROD_BONE);
                    entries.add(ModItemRegister.WAND_ROD_GREATWOOD);
                    entries.add(ModItemRegister.WAND_ROD_ICE);
                    entries.add(ModItemRegister.WAND_ROD_OBSIDIAN);
                    entries.add(ModItemRegister.WAND_ROD_QUARTZ);
                    entries.add(ModItemRegister.WAND_ROD_REED);
                    entries.add(ModItemRegister.WAND_ROD_SILVERWOOD);
                    entries.add(ModItemRegister.WISPESSENCE);
                })
                .build();
    }
}