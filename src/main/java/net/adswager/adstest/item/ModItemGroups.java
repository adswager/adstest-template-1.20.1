package net.adswager.adstest.item;

import net.adswager.adstest.AdsTest;
import net.adswager.adstest.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(AdsTest.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.COAL_CHUNK);

                        entries.add(ModItems.RUBY_SWORD);
                        entries.add(ModItems.RUBY_SHOVEL);
                        entries.add(ModItems.RUBY_PICKAXE);
                        entries.add(ModItems.RUBY_AXE);
                        entries.add(ModItems.RUBY_HOE);

                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);

                        entries.add(ModItems.RUBY_HELMET);
                        entries.add(ModItems.RUBY_CHESTPLATE);
                        entries.add(ModItems.RUBY_LEGGINGS);
                        entries.add(ModItems.RUBY_BOOTS);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.CORN_SEEDS);

                        entries.add(ModItems.COW_SEEDS);
                        entries.add(ModItems.SHEEP_SEEDS);

                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);
                        entries.add(ModItems.RUBY_STAFF);

                        entries.add(ModBlocks.RUBY_WALL);
                        entries.add(ModBlocks.RUBY_STAIRS);
                        entries.add(ModBlocks.RUBY_BUTTON);
                        entries.add(ModBlocks.RUBY_FENCE);
                        entries.add(ModBlocks.RUBY_FENCE_GATE);
                        entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                        entries.add(ModBlocks.RUBY_DOOR);
                        entries.add(ModBlocks.RUBY_TRAPDOOR);
                        entries.add(ModBlocks.RUBY_SLAB);
                    }).build());
    public static void registerItemGroups(){
        AdsTest.LOGGER.info("Registering Item Groups" +AdsTest.MOD_ID);
    }
}
