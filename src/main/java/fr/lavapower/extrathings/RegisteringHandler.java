package fr.lavapower.extrathings;

import fr.lavapower.extrathings.blocks.ExtraThingsBlocks;
import fr.lavapower.extrathings.items.ExtraThingsItems;
import fr.lavapower.extrathings.tileentities.ExtraThingsTileEntities;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringHandler
{
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register <Block>event)
    {
        event.getRegistry().registerAll(ExtraThingsBlocks.COLOR_BLOCK,
                ExtraThingsBlocks.WHITE_STAIRS,
                ExtraThingsBlocks.LIGHT_GRAY_STAIRS,
                ExtraThingsBlocks.GRAY_STAIRS,
                ExtraThingsBlocks.BLACK_STAIRS,
                ExtraThingsBlocks.BROWN_STAIRS,
                ExtraThingsBlocks.RED_STAIRS,
                ExtraThingsBlocks.ORANGE_STAIRS,
                ExtraThingsBlocks.YELLOW_STAIRS,
                ExtraThingsBlocks.LIME_STAIRS,
                ExtraThingsBlocks.GREEN_STAIRS,
                ExtraThingsBlocks.CYAN_STAIRS,
                ExtraThingsBlocks.LIGHT_BLUE_STAIRS,
                ExtraThingsBlocks.BLUE_STAIRS,
                ExtraThingsBlocks.PURPLE_STAIRS,
                ExtraThingsBlocks.MAGENTA_STAIRS,
                ExtraThingsBlocks.PINK_STAIRS,
                ExtraThingsBlocks.TABLE,
                ExtraThingsBlocks.CHAIR,
                ExtraThingsBlocks.CUPBOARD);
        
        ExtraThingsTileEntities.registerTileEntities();
    }
    
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ExtraThingsItems.BLOCK_COLOR_BLOCK,
                ExtraThingsItems.BLOCK_WHITE_STAIRS,
                ExtraThingsItems.BLOCK_LIGHT_GRAY_STAIRS,
                ExtraThingsItems.BLOCK_GRAY_STAIRS,
                ExtraThingsItems.BLOCK_BLACK_STAIRS,
                ExtraThingsItems.BLOCK_BROWN_STAIRS,
                ExtraThingsItems.BLOCK_RED_STAIRS,
                ExtraThingsItems.BLOCK_ORANGE_STAIRS,
                ExtraThingsItems.BLOCK_YELLOW_STAIRS,
                ExtraThingsItems.BLOCK_LIME_STAIRS,
                ExtraThingsItems.BLOCK_GREEN_STAIRS,
                ExtraThingsItems.BLOCK_CYAN_STAIRS,
                ExtraThingsItems.BLOCK_LIGHT_BLUE_STAIRS,
                ExtraThingsItems.BLOCK_BLUE_STAIRS,
                ExtraThingsItems.BLOCK_PURPLE_STAIRS,
                ExtraThingsItems.BLOCK_MAGENTA_STAIRS,
                ExtraThingsItems.BLOCK_PINK_STAIRS,
                ExtraThingsItems.BLOCK_TABLE,
                ExtraThingsItems.BLOCK_CHAIR,
                ExtraThingsItems.BLOCK_CUPBOARD);
    }
}
