package net.archasmiel.thaumcraft.item.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemRegister{
    public static final Item ALUMENTUM = registerItem("alumentum",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"alumentum","item"));
    public static final Item AMBER = registerItem("amber",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"amber","item"));
    public static final Item BATH_SALTS = registerItem("bath_salts",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"bath_salts","item"));
    public static final Item BAUBLE_AMULET = registerItem("bauble_amulet",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bauble_amulet","item"));
    public static final Item BAUBLE_BELT = registerItem("bauble_belt",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bauble_belt","item"));
    public static final Item BAUBLE_RING = registerItem("bauble_ring",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bauble_ring","item"));
    public static final Item BAUBLE_RING_IRON = registerItem("bauble_ring_iron",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bauble_ring_iron","item"));
    public static final Item BOOTSTRAVELER = registerItem("bootstraveler",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bootstraveler","item"));
    public static final Item BOTTLE_TAINT = registerItem("bottle_taint",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bottle_taint","item"));
    public static final Item BRAIN = registerItem("brain",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"brain","item"));
    public static final Item BUCKET_DEATH = registerItem("bucket_death",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bucket_death","item"));
    public static final Item BUCKET_PURE = registerItem("bucket_pure",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bucket_pure","item"));
    public static final Item CHARM = registerItem("charm",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"charm","item"));
    public static final Item BONEBOW = registerItem("bonebow",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"bonebow","item"));
    public static final Item CLOTH = registerItem("cloth",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"cloth","item"));
    public static final Item CLOTHBOOTS = registerItem("clothboots",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"clothboots","item"));
    public static final Item CLOTHBOOTSOVER = registerItem("clothbootsover",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"clothbootsover","item"));
    public static final Item CLOTHCHEST = registerItem("clothchest",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"clothchest","item"));
    public static final Item CLOTHCHEATOVER = registerItem("clothchestover",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"clothchestover","item"));
    public static final Item CLOTHLEGS = registerItem("clothlegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"clothlegs","item"));
    public static final Item CLOTHLEGSOVER = registerItem("clothlegsover",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"clothlegsover","item"));
    public static final Item CLUSTERCINNABAR = registerItem("clustercinnabar",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clustercinnabar","item"));
    public static final Item CLUSTERCOPPER = registerItem("clustercopper",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clustercopper","item"));
    public static final Item CLUSTERGOLD = registerItem("clustergold",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clustergold","item"));
    public static final Item CLUSTERIRON = registerItem("clusteriron",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clusteriron","item"));
    public static final Item CLUSTERLEAD = registerItem("clusterlead",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clusterlead","item"));
    public static final Item CLUSTERSILVER = registerItem("clustersilver",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clustersilver","item"));
    public static final Item CLUSTERTIN = registerItem("clustertin",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"clustertin","item"));
    public static final Item COIN = registerItem("coin",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"coin","item"));
    public static final Item CRIMSON_BLADE = registerItem("crimson_blade",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"crimson_blade","item"));
    public static final Item CRIMSON_RITES = registerItem("crimson_rites",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"crimson_rites","item"));
    public static final Item CRYSTALESSENCE = registerItem("crystalessence",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"crystalessence","item"));
    public static final Item CULTISTBOOTS = registerItem("cultistboots",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistboots","item"));
    public static final Item CULTISTPLATECHEST = registerItem("cultistplatechest",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistplatechest","item"));
    public static final Item CULTISTPLATEHELM = registerItem("cultistplatehelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistplatehelm","item"));
    public static final Item CULTISTPLATELEADERCHEST = registerItem("cultistplateleaderchest",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistplateleaderchest","item"));
    public static final Item CULTSTPLATELEADERHELM = registerItem("cultistplateleaderhelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistplateleaderhelm","item"));
    public static final Item CULTISTPLATELEADERLEGS = registerItem("cultistplateleaderlegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistplateleaderlegs","item"));
    public static final Item CULTISTPLATELEGS = registerItem("cultistplatelegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistplatelegs","item"));
    public static final Item CULTISTROBECHEST = registerItem("cultistrobechest",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistrobechest","item"));
    public static final Item CULTISTROBEHELM = registerItem("cultistrobehelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistrobehelm","item"));
    public static final Item CULTISTROBELEGS = registerItem("cultistrobelegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"cultistrobelegs","item"));
    public static final Item DISCOVERY = registerItem("discovery",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"discovery","item"));
    public static final Item DUST = registerItem("dust",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item EL_ARROW_AIR = registerItem("el_arrow_air",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"el_arrow_air","item"));
    public static final Item EL_ARROW_EATRH = registerItem("el_arrow_earth",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"el_arrow_earth","item"));
    public static final Item EL_ARROW_ENTROPY = registerItem("el_arrow_entropy",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"el_arrow_entropy","item"));
    public static final Item EL_ARROW_FIRE = registerItem("el_arrow_fire",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"el_arrow_fire","item"));
    public static final Item EL_ARROW_ORDER = registerItem("el_arrow_order",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"el_arrow_order","item"));
    public static final Item EL_ARROW_WATER = registerItem("el_arrow_water",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"el_arrow_water","item"));
    public static final Item ELDRITCH_OBJECT = registerItem("eldritch_object",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"eldritch_object","item"));
    public static final Item ELDRITCH_OBJECT_2 = registerItem("eldritch_object_2",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"eldritch_object_2","item"));
    public static final Item ELDRITCH_OBJECT_3 = registerItem("eldritch_object_3",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"eldritch_object_3","item"));
    public static final Item ELEMENTALAXE = registerItem("elementalaxe",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"elementalaxe","item"));
    public static final Item ELEMENTALHOE = registerItem("elementalhoe",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"elementalhoe","item"));
    public static final Item ELEMENTALPICK = registerItem("elementalpick",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"elementalpick","item"));
    public static final Item ELEMENTALSHOVEL = registerItem("elementalshovel",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"elementalshovel","item"));
    public static final Item ELEMENTALSWORD = registerItem("elementalsword",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"elementalsword","item"));
    public static final Item ESSENCE = registerItem("essence",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"essence","item"));
    public static final Item FILTER = registerItem("filter",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"filter","item"));
    public static final Item FOCUS = registerItem("focus",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus","item"));
    public static final Item FOCUS_EXCAVATION = registerItem("focus_excavation",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_excavation","item"));
    public static final Item FOCUS_FIRE = registerItem("focus_fire",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_fire","item"));
    public static final Item FOCUS_FROST = registerItem("focus_frost",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_frost","item"));
    public static final Item FOCUS_HELLBAT = registerItem("focus_hellbat",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_hellbat","item"));
    public static final Item FOCUS_HELLBAT_ORN = registerItem("focus_hellbat_orn",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_hellbat_orn","item"));
    public static final Item FOCUS_PECH = registerItem("focus_pech",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_pech","item"));
    public static final Item FOCUS_PECH_DEPTH = registerItem("focus_pech_depth",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_pech_depth","item"));
    public static final Item FOCUS_PORTABLEHOLE = registerItem("focus_portablehole",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_portablehole","item"));
    public static final Item FOCUS_PORTABLEHOLE_DEPTH = registerItem("focus_portablehole_depth",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_portablehole_depth","item"));
    public static final Item FOCUS_PRIMAL = registerItem("focus_primal",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_primal","item"));
    public static final Item FOCUS_PRIMAL_DEPTH = registerItem("focus_primal_depth",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_primal_depth","item"));
    public static final Item FOCUS_REVERSAL = registerItem("focus_reversal",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_reversal","item"));
    public static final Item FOCUS_SHOCK = registerItem("focus_shock",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_shock","item"));
    public static final Item FOCUS_TRADE = registerItem("focus_trade",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_trade","item"));
    public static final Item FOCUS_TRADE_ORN = registerItem("focus_trade_orn",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_trade_orn","item"));
    public static final Item FOCUS_WARDING = registerItem("focus_warding",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_warding","item"));
    public static final Item FOCUS_WARDING_DEPTH = registerItem("focus_warding_depth",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_warding_depth","item"));
    public static final Item FOCUS_WARDING_ORN = registerItem("focus_warding_orn",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_warding_orn","item"));
    public static final Item FOCUS_WHATEVER_ORN = registerItem("focus_whatever_orn",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_whatever_orn","item"));
    public static final Item FOCUS_POUCH = registerItem("focus_pouch",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_pouch","item"));
    public static final Item FOCUS_POUCH_BAUBLE = registerItem("focus_pouch_bauble",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"focus_pouch_bauble","item"));
    public static final Item GOGGLESREVEALING = registerItem("gogglesrevealing",
            new ModItemGeneration(new FabricItemSettings().maxCount(1),"gogglesrevealing","item"));
    public static final Item GOLEM_CLAY = registerItem("golem_clay",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_clay","item"));
    public static final Item GOLEM_CORE_BLANK = registerItem("golem_core_blank",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_blank","item"));
    public static final Item GOLEM_CORE_BODYGUARD = registerItem("golem_core_bodyguard",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_bodyguard","item"));
    public static final Item GOLEM_CORE_BUTCHER = registerItem("golem_core_butcher",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_butcher","item"));
    public static final Item GOLEM_CORE_EMPTY = registerItem("golem_core_empty",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_empty","item"));
    public static final Item GOLEM_CORE_ESSENTIA = registerItem("golem_core_essentia",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_essentia","item"));
    public static final Item GOLEM_CORE_FILL = registerItem("golem_core_fill",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_fill","item"));
    public static final Item GOLEM_CORE_FISH = registerItem("golem_core_fish",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_fish","item"));
    public static final Item GOLEM_CORE_GATHER = registerItem("golem_core_gather",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_gather","item"));
    public static final Item GOLEM_CORE_GUARD = registerItem("golem_core_guard",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_guard","item"));
    public static final Item GOLEM_CORE_HARVEST = registerItem("golem_core_harvest",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_harvest","item"));
    public static final Item GOLEM_CORE_LIQUID = registerItem("golem_core_liquid",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_liquid","item"));
    public static final Item GOLEM_CORE_LUMBER = registerItem("golem_core_lumber",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_lumber","item"));
    public static final Item GOLEM_CORE_PATROL = registerItem("golem_core_patrol",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_patrol","item"));
    public static final Item GOLEM_CORE_SORTING = registerItem("golem_core_sorting",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_sorting","item"));
    public static final Item GOLEM_CORE_USE = registerItem("golem_core_use",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_core_use","item"));
    public static final Item GOLEM_FLESH = registerItem("golem_flesh",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_flesh","item"));
    public static final Item GOLEM_IRON = registerItem("golem_iron",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_iron","item"));
    public static final Item GOLEM_OVER_ADV = registerItem("golem_over_adv",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_over_adv","item"));
    public static final Item GOLEM_OVER_CORE = registerItem("golem_over_core",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_over_core","item"));
    public static final Item GOLEM_STONE = registerItem("golem_stone",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_stone","item"));
    public static final Item GOLEM_STRAW = registerItem("golem_straw",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_straw","item"));
    public static final Item GOLEM_TALLOW = registerItem("golem_tallow",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_tallow","item"));
    public static final Item GOLEM_THAUMIUM = registerItem("golem_thaumium",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_thaumium","item"));
    public static final Item GOLEM_UPGRADE_AIR = registerItem("golem_upgrade_air",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_air","item"));
    public static final Item GOLEM_UPGRADE_EARTH = registerItem("golem_upgrade_earth",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_earth","item"));
    public static final Item GOLEM_UPGRADE_EMPTY = registerItem("golem_upgrade_empty",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_empty","item"));
    public static final Item GOLEM_UPGRADE_ENTROPY = registerItem("golem_upgrade_entropy",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_entropy","item"));
    public static final Item GOLEM_UPGRADE_FIRE = registerItem("golem_upgrade_fire",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_fire","item"));
    public static final Item GOLEM_UPGRADE_ORDER = registerItem("golem_upgrade_order",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_order","item"));
    public static final Item GOLEM_UPGRADE_WATER = registerItem("golem_upgrade_water",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_upgrade_water","item"));
    public static final Item GOLEM_WOOD = registerItem("golem_wood",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golem_wood","item"));
    public static final Item GOLEMDECOARMOR = registerItem("golemdecoarmor",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecoarmor","item"));
    public static final Item GOLEMDECOBOWTIE = registerItem("golemdecobowtie",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecobowtie","item"));
    public static final Item GOLEMDECODART = registerItem("golemdecodart",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecodart","item"));
    public static final Item GOLEMDECOFEZ = registerItem("golemdecofez",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecofez","item"));
    public static final Item GOLEMDECOGLASSES = registerItem("golemdecoglasses",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecoglasses","item"));
    public static final Item GOLEMDECOMACE = registerItem("golemdecomace",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecomace","item"));
    public static final Item GOLEMDECOTOPHAT = registerItem("golemdecotophat",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecotophat","item"));
    public static final Item GOLEMDECOVISOR = registerItem("golemdecovisor",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"golemdecovisor","item"));
    public static final Item HOVERGIRDLE = registerItem("hovergirdle",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"hovergirdle","item"));
    public static final Item HOVERHARNESS = registerItem("hoverharness",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"hoverharness","item"));
    public static final Item INKWELL = registerItem("inkwell",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"inkwell","item"));
    public static final Item IRONBELL = registerItem("ironbell",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"ironbell","item"));
    public static final Item KEYGOLD = registerItem("keygold",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"keygold","item"));
    public static final Item KEYIRON = registerItem("keyiron",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"keyiron","item"));
    public static final Item KNOWLEDGEFRAGMENT = registerItem("knowledgefragment",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"knowledgefragment","item"));
    public static final Item LABEL = registerItem("label",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"label","item"));
    public static final Item LABEL_OVER = registerItem("label_over",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"label_over","item"));
    public static final Item LIGHTNINGRING = registerItem("lightningring",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"lightningring","item"));
    public static final Item LIGHTNINGRINGV = registerItem("lightningringv",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"lightningringv","item"));
    public static final Item LOOTBAG = registerItem("lootbag",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"lootbag","item"));
    public static final Item LOOTBAGRARE = registerItem("lootbagrare",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"lootbagrare","item"));
    public static final Item LOOTBAGUNC = registerItem("lootbagunc",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"lootbagunc","item"));
    public static final Item MANA_BEAN = registerItem("mana_bean",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"mana_bean","item"));
    public static final Item MIRRORFRAME = registerItem("mirrorframe",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"mirrorframe","item"));
    public static final Item MIRRORFRAME2 = registerItem("mirrorframe2",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"mirrorframe2","item"));
    public static final Item MIRRORGLASS = registerItem("mirrorglass",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"mirrorglass","item"));
    public static final Item MIRRORHAND = registerItem("mirrorhand",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"mirrorhand","item"));
    public static final Item NITOR = registerItem("nitor",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nitor","item"));
    public static final Item NUGGETBEEF = registerItem("nuggetbeef",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetbeef","item"));
    public static final Item NUGGETCHICKEN = registerItem("nuggetchicken",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetchicken","item"));
    public static final Item NUGGETCOPPER = registerItem("nuggetcopper",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetcopper","item"));
    public static final Item NUGGETFISH = registerItem("nuggetfish",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item NUGGETIRON = registerItem("nuggetiron",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetiron","item"));
    public static final Item NUGGETLEAD = registerItem("nuggetlead",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetlead","item"));
    public static final Item NUGGETPORK = registerItem("nuggetpork",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetpork","item"));
    public static final Item NUGGETQUICKSILVER = registerItem("nuggetquicksilver",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetquicksilver","item"));
    public static final Item NUGGETSILVER = registerItem("nuggetsilver",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetsilver","item"));
    public static final Item NUGGETTHAUMIUM = registerItem("nuggetthaumium",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetthaumium","item"));
    public static final Item NUGGETTIN = registerItem("nuggettin",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggettin","item"));
    public static final Item NUGGETVOID = registerItem("nuggetvoid",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"nuggetvoid","item"));
    public static final Item OB_PLACER = registerItem("ob_placer",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"ob_placer","item"));
    public static final Item PHIAL = registerItem("phial",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"phial","item"));
    public static final Item PHIALOVERLAY = registerItem("phialoverlay",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"phialoverlay","item"));
    public static final Item PRIMAL_CRUSHER = registerItem("primal_crusher",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"primal_crusher","item"));
    public static final Item QUICKSILVER = registerItem("quicksilver",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"quicksilver","item"));
    public static final Item RESEARCHNOTES = registerItem("researchnotes",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"researchnotes","item"));
    public static final Item RESEARCHNOTESOVERLAY = registerItem("researchnotesoverlay",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"researchnotesoverlay","item"));
    public static final Item RESONATOR = registerItem("resonator",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"resonator","item"));
    public static final Item RUNIC_AMULET = registerItem("runic_amulet",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_amulet","item"));
    public static final Item RUNIC_AMULET_EMERGENCY = registerItem("runic_amulet_emergency",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_amulet_emergency","item"));
    public static final Item RUNIC_GIRDLE = registerItem("runic_girdle",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_girdle","item"));
    public static final Item RUNIC_GIRDLE_KINETIC = registerItem("runic_girdle_kinetic",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_girdle_kinetic","item"));
    public static final Item RUNIC_RING = registerItem("runic_ring",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_ring","item"));
    public static final Item RUNIC_RING_CHARGED = registerItem("runic_ring_charged",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_ring_charged","item"));
    public static final Item RUNIC_RING_LESSER = registerItem("runic_ring_lesser",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_ring_lesser","item"));
    public static final Item RUNIC_RING_REGEN = registerItem("runic_ring_regen",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"runic_ring_regen","item"));
    public static final Item SANITYCHECKER = registerItem("sanitychecker",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"sanitychecker","item"));
    public static final Item SHARD = registerItem("shard",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"shard","item"));
    public static final Item SHARD_BALANCED = registerItem("shard_balanced",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"shard_balanced","item"));
    public static final Item SINISTER_STONE = registerItem("sinister_stone",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"sinister_stone","item"));
    public static final Item SINISTER_STONE_ACTIVE = registerItem("sinister_stone_active",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"sinister_stone_active","item"));
    public static final Item SOAP = registerItem("soap",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"soap","item"));
    public static final Item STAFF_ROD_BLAZE = registerItem("staff_rod_blaze",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item STAFF_ROD_BONE = registerItem("staff_rod_bone",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item STAFF_ROD_GREATWOOD = registerItem("staff_rod_greatwood",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_greatwood","item"));
    public static final Item STAFF_ROD_ICE = registerItem("staff_rod_ice",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_ice","item"));
    public static final Item STAFF_ROD_OBSIDIAN = registerItem("staff_rod_obsidian",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_obsidian","item"));
    public static final Item STAFF_ROD_PRIMAL = registerItem("staff_rod_primal",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_primal","item"));
    public static final Item STAFF_ROD_QUARTZ = registerItem("staff_rod_quartz",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_quartz","item"));
    public static final Item STAFF_ROD_REED = registerItem("staff_rod_reed",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_reed","item"));
    public static final Item STAFF_ROD_SILVERWOOD = registerItem("staff_rod_silverwood",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"staff_rod_silverwood","item"));
    public static final Item TAINT_SLIME = registerItem("taint_slime",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"taint_slime","item"));
    public static final Item TAINT_TENDRIL = registerItem("taint_tendril",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"taint_tendril","item"));
    public static final Item TALLOW = registerItem("tallow",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"tallow","item"));
    public static final Item THAUMIUMAXE = registerItem("thaumiumaxe",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumaxe","item"));
    public static final Item THAUMIUMBOOTS = registerItem("thaumiumboots",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumboots","item"));
    public static final Item THAUMIUMCHEST = registerItem("thaumiumchest",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item THAUMIUMFORTRESSCHEST = registerItem("thaumiumfortresschest",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumfortresschest","item"));
    public static final Item THAUMIUMFORTRESSHELM = registerItem("thaumiumfortresshelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumfortresshelm","item"));
    public static final Item THAUMIUMFORTRESSLEGS = registerItem("thaumiumfortresslegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumfortresslegs","item"));
    public static final Item THAUMIUMHELM = registerItem("thaumiumhelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumhelm","item"));
    public static final Item THAUMIUMHOE = registerItem("thaumiumhoe",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumhoe","item"));
    public static final Item THAUMIUMINGOT = registerItem("thaumiumingot",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumingot","item"));
    public static final Item THAUMIUMLEGS = registerItem("thaumiumlegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumlegs","item"));
    public static final Item THAUMIUMPICK = registerItem("thaumiumpick",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumpick","item"));
    public static final Item THAUMIUMSHOVEL = registerItem("thaumiumshovel",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumshovel","item"));
    public static final Item THAUMIUMSWORD = registerItem("thaumiumsword",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumiumsword","item"));
    public static final Item THAUMONOMICON = registerItem("thaumonomicon",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumonomicon","item"));
    public static final Item THAUMONOMICONCHEAT = registerItem("thaumonomiconcheat",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"thaumonomiconcheat","item"));
    public static final Item TRIPLETREAT = registerItem("tripletreat",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"tripletreat","item"));
    public static final Item VIS_AMULET = registerItem("vis_amulet",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"vis_amulet","item"));
    public static final Item VIS_AMULET_LESSER = registerItem("vis_amulet_lesser",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"vis_amulet_lesser","item"));
    public static final Item VOIDAXE = registerItem("voidaxe",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidaxe","item"));
    public static final Item VOIDBOOTS = registerItem("voidboots",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item VOIDCHEST = registerItem("voidchest",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidchest","item"));
    public static final Item VOIDHELM = registerItem("voidhelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidhelm","item"));
    public static final Item VOIDHOE = registerItem("voidhoe",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidhoe","item"));
    public static final Item VOIDINGOT = registerItem("voidingot",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidingot","item"));
    public static final Item VOIDLEGS = registerItem("voidlegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidlegs","item"));
    public static final Item VOIDPICK = registerItem("voidpick",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidpick","item"));
    public static final Item VOIDROBECHEST = registerItem("voidrobechest",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidrobechest","item"));
    public static final Item VOIDROBECHESTOVER = registerItem("voidrobechestover",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidrobechestover","item"));
    public static final Item VOIDROBEHELM = registerItem("voidrobehelm",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidrobehelm","item"));
    public static final Item VOIDROBELEGS = registerItem("voidrobelegs",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidrobelegs","item"));
    public static final Item VOIDROBELEGSOVER = registerItem("voidrobelegsover",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidrobelegsover","item"));
    public static final Item VOIDSEED = registerItem("voidseed",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidseed","item"));
    public static final Item VOIDSHOVEL = registerItem("voidshovel",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidshovel","item"));
    public static final Item VOIDSWORD = registerItem("voidsword",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"voidsword","item"));
    public static final Item WAND_CAP_COPPER = registerItem("wand_cap_copper",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_copper","item"));
    public static final Item WAND_CAP_GOLD = registerItem("wand_cap_gold",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_gold","item"));
    public static final Item WAND_CAP_IRON = registerItem("wand_cap_iron",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_iron","item"));
    public static final Item WAND_CAP_SILVER = registerItem("wand_cap_silver",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"dust","item"));
    public static final Item WAND_CAP_SILVER_INERT = registerItem("wand_cap_silver_inert",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_silver_inert","item"));
    public static final Item WAND_CAP_THAUMIUM = registerItem("wand_cap_thaumium",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_thaumium","item"));
    public static final Item WAND_CAP_THAUMIUM_INERT = registerItem("wand_cap_thaumium_inert",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_thaumium_inert","item"));
    public static final Item WAND_CAP_VOID = registerItem("wand_cap_void",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_void","item"));
    public static final Item WAND_CAP_VOID_INERT = registerItem("wand_cap_void_inert",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_cap_void_inert","item"));
    public static final Item WAND_ROD_BLAZE = registerItem("wand_rod_blaze",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_blaze","item"));
    public static final Item WAND_ROD_BONE = registerItem("wand_rod_bone",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_bone","item"));
    public static final Item WAND_ROD_GREATWOOD = registerItem("wand_rod_greatwood",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_greatwood","item"));
    public static final Item WAND_ROD_ICE = registerItem("wand_rod_ice",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_ice","item"));
    public static final Item WAND_ROD_OBSIDIAN = registerItem("wand_rod_obsidian",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_obsidian","item"));
    public static final Item WAND_ROD_QUARTZ = registerItem("wand_rod_quartz",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_quartz","item"));
    public static final Item WAND_ROD_REED = registerItem("wand_rod_reed",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_reed","item"));
    public static final Item WAND_ROD_SILVERWOOD = registerItem("wand_rod_silverwood",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wand_rod_silverwood","item"));
    public static final Item WISPESSENCE = registerItem("wispessence",
            new ModItemGeneration(new FabricItemSettings().maxCount(64),"wispessence","item"));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Thaumcraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Thaumcraft.LOGGER.debug("Registering Mod Items for " + Thaumcraft.MOD_ID);
    }
}