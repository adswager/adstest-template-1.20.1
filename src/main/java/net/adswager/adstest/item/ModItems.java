package net.adswager.adstest.item;

import net.adswager.adstest.AdsTest;
import net.adswager.adstest.block.ModBlocks;
import net.adswager.adstest.item.custom.MetalDetectorItem;
import net.adswager.adstest.item.custom.ModArmorItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_CHUNK = registerItem("coal_chunk",
            new Item(new FabricItemSettings()));

    public static final Item RUBY_STAFF = registerItem("ruby_staff", new Item(new FabricItemSettings().maxCount(1)));


    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY,
            2, 2f, new FabricItemSettings()));
   public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterial.RUBY,
            7, 3f, new FabricItemSettings()));
   public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY,
            9, 1.5f, new FabricItemSettings()));
   public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY,
            2, 2f, new FabricItemSettings()));
   public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY,
            1, 0f, new FabricItemSettings()));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterial.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ArmorItem(ModArmorMaterial.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ArmorItem(ModArmorMaterial.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ArmorItem(ModArmorMaterial.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));

public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
        new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));

public static final Item CORN_SEEDS = registerItem("corn_seeds",
        new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));

public static final Item CORN = registerItem("corn",
        new Item( new FabricItemSettings().food(ModFoodComponents.CORN)));

public static final Item COW_SEEDS = registerItem("cow_seeds",
        new AliasedBlockItem(ModBlocks.COW_CROP, new FabricItemSettings()));
public static final Item SHEEP_SEEDS = registerItem("sheep_seeds",
        new AliasedBlockItem(ModBlocks.SHEEP_CROP, new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(AdsTest.MOD_ID, name), item);
    }
    public static void registerModItems(){
        AdsTest.LOGGER.info("Registering mod items for" + AdsTest.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}

