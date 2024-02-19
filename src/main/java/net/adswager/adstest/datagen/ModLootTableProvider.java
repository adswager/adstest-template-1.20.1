package net.adswager.adstest.datagen;

import net.adswager.adstest.block.ModBlocks;
import net.adswager.adstest.block.custom.CornCropBlock;
import net.adswager.adstest.block.custom.CowCropBlock;
import net.adswager.adstest.block.custom.TomatoCropBlock;
import net.adswager.adstest.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {



        addDrop(ModBlocks.RUBY_BLOCK);
        addDrop(ModBlocks.RAW_RUBY_BLOCK);
        addDrop(ModBlocks.SOUND_BLOCK);
        addDrop(ModBlocks.RUBY_ORE, copperlikeOreDrops(ModBlocks.RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, copperlikeOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.NETHER_RUBY_ORE, copperlikeOreDrops(ModBlocks.NETHER_RUBY_ORE, ModItems.RAW_RUBY));
        addDrop(ModBlocks.END_STONE_RUBY_ORE, copperlikeOreDrops(ModBlocks.END_STONE_RUBY_ORE, ModItems.RAW_RUBY));

        addDrop(ModBlocks.RUBY_STAIRS);
        addDrop(ModBlocks.RUBY_TRAPDOOR);
        addDrop(ModBlocks.RUBY_WALL);
        addDrop(ModBlocks.RUBY_FENCE);
        addDrop(ModBlocks.RUBY_FENCE_GATE);
        addDrop(ModBlocks.RUBY_BUTTON);
        addDrop(ModBlocks.RUBY_PRESSURE_PLATE);

        addDrop(ModBlocks.RUBY_DOOR, doorDrops(ModBlocks.RUBY_DOOR));
        addDrop(ModBlocks.RUBY_SLAB, slabDrops(ModBlocks.RUBY_SLAB));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5));
        addDrop(ModBlocks.TOMATO_CROP, cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder));

        AnyOfLootCondition.Builder builder2 =
                BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 7))
                        .or(BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                                .exactMatch(CornCropBlock.AGE, 8)));

        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder2));

        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.COW_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CowCropBlock.AGE, 5));
        addDrop(ModBlocks.COW_CROP, cropDropsX(ModBlocks.COW_CROP, ModItems.COW_SEEDS, Items.LEATHER, Items.BEEF, builder3));

 BlockStatePropertyLootCondition.Builder builder4 = BlockStatePropertyLootCondition.builder(ModBlocks.SHEEP_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CowCropBlock.AGE, 5));
        addDrop(ModBlocks.SHEEP_CROP, cropDropsX(ModBlocks.SHEEP_CROP, ModItems.SHEEP_SEEDS, Items.WHITE_WOOL, Items.MUTTON, builder4));


    }

    private LootTable.Builder cropDropsX(Block crop, Item product,  Item product2, Item seeds, LootCondition.Builder condition) {
        return this.applyExplosionDecay(crop, LootTable.builder().pool(LootPool.builder()
                .with(((LeafEntry.Builder)ItemEntry.builder(product).conditionally(condition))
                        .alternatively(ItemEntry.builder(seeds)))).pool(LootPool.builder().conditionally(condition)
                .with(((LeafEntry.Builder)ItemEntry.builder(product2).conditionally(condition))
                .alternatively(ItemEntry.builder(seeds)))).pool(LootPool.builder().conditionally(condition) //line2
                .with((LootPoolEntry.Builder<?>)((Object)ItemEntry.builder(seeds)
                        .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        // If u want to add more just copy .with... ...line2 and change (productX) and in LootTable.builder in Item product just add next (eg. Item product3)
    }

    public LootTable.Builder copperlikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                        ((LeafEntry.Builder)
                                ItemEntry.builder(item)
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
