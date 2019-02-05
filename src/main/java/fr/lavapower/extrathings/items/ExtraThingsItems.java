package fr.lavapower.extrathings.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import fr.lavapower.extrathings.ExtraThings;
import fr.lavapower.extrathings.blocks.ColorBlock;
import fr.lavapower.extrathings.blocks.ExtraThingsBlocks;

@EventBusSubscriber(value = Side.CLIENT, modid = ExtraThings.MODID)
public class ExtraThingsItems
{
    public static final Item BLOCK_COLOR_BLOCK = new ItemBlockMetadata(ExtraThingsBlocks.COLOR_BLOCK, new String[]{"color_block",
            "color_block_v1",
            "color_block_v2",
            "color_block_v3",
            "color_block_v4",
            "color_block_v5",
            "color_block_v6",
            "color_block_v7",
            "color_block_v8",
            "color_block_v9",
            "color_block_v10",
            "color_block_v11",
            "color_block_v12",
            "color_block_v13",
            "color_block_v14",
            "color_block_v15"} ).setRegistryName(ExtraThingsBlocks.COLOR_BLOCK.getRegistryName());
    public static final Item BLOCK_WHITE_STAIRS = new ItemBlock(ExtraThingsBlocks.WHITE_STAIRS).setRegistryName(ExtraThingsBlocks.WHITE_STAIRS.getRegistryName());
    public static final Item BLOCK_LIGHT_GRAY_STAIRS = new ItemBlock(ExtraThingsBlocks.LIGHT_GRAY_STAIRS).setRegistryName(ExtraThingsBlocks.LIGHT_GRAY_STAIRS.getRegistryName());
    public static final Item BLOCK_GRAY_STAIRS = new ItemBlock(ExtraThingsBlocks.GRAY_STAIRS).setRegistryName(ExtraThingsBlocks.GRAY_STAIRS.getRegistryName());
    public static final Item BLOCK_BLACK_STAIRS = new ItemBlock(ExtraThingsBlocks.BLACK_STAIRS).setRegistryName(ExtraThingsBlocks.BLACK_STAIRS.getRegistryName());
    public static final Item BLOCK_BROWN_STAIRS = new ItemBlock(ExtraThingsBlocks.BROWN_STAIRS).setRegistryName(ExtraThingsBlocks.BROWN_STAIRS.getRegistryName());
    public static final Item BLOCK_RED_STAIRS = new ItemBlock(ExtraThingsBlocks.RED_STAIRS).setRegistryName(ExtraThingsBlocks.RED_STAIRS.getRegistryName());
    public static final Item BLOCK_ORANGE_STAIRS = new ItemBlock(ExtraThingsBlocks.ORANGE_STAIRS).setRegistryName(ExtraThingsBlocks.ORANGE_STAIRS.getRegistryName());
    public static final Item BLOCK_YELLOW_STAIRS = new ItemBlock(ExtraThingsBlocks.YELLOW_STAIRS).setRegistryName(ExtraThingsBlocks.YELLOW_STAIRS.getRegistryName());
    public static final Item BLOCK_LIME_STAIRS = new ItemBlock(ExtraThingsBlocks.LIME_STAIRS).setRegistryName(ExtraThingsBlocks.LIME_STAIRS.getRegistryName());
    public static final Item BLOCK_GREEN_STAIRS = new ItemBlock(ExtraThingsBlocks.GREEN_STAIRS).setRegistryName(ExtraThingsBlocks.GREEN_STAIRS.getRegistryName());
    public static final Item BLOCK_CYAN_STAIRS = new ItemBlock(ExtraThingsBlocks.CYAN_STAIRS).setRegistryName(ExtraThingsBlocks.CYAN_STAIRS.getRegistryName());
    public static final Item BLOCK_LIGHT_BLUE_STAIRS = new ItemBlock(ExtraThingsBlocks.LIGHT_BLUE_STAIRS).setRegistryName(ExtraThingsBlocks.LIGHT_BLUE_STAIRS.getRegistryName());
    public static final Item BLOCK_BLUE_STAIRS = new ItemBlock(ExtraThingsBlocks.BLUE_STAIRS).setRegistryName(ExtraThingsBlocks.BLUE_STAIRS.getRegistryName());
    public static final Item BLOCK_PURPLE_STAIRS = new ItemBlock(ExtraThingsBlocks.PURPLE_STAIRS).setRegistryName(ExtraThingsBlocks.PURPLE_STAIRS.getRegistryName());
    public static final Item BLOCK_MAGENTA_STAIRS = new ItemBlock(ExtraThingsBlocks.MAGENTA_STAIRS).setRegistryName(ExtraThingsBlocks.MAGENTA_STAIRS.getRegistryName());
    public static final Item BLOCK_PINK_STAIRS = new ItemBlock(ExtraThingsBlocks.PINK_STAIRS).setRegistryName(ExtraThingsBlocks.PINK_STAIRS.getRegistryName());
    public static final Item BLOCK_TABLE = new ItemBlock(ExtraThingsBlocks.TABLE).setRegistryName(ExtraThingsBlocks.TABLE.getRegistryName());
    public static final Item BLOCK_CHAIR = new ItemBlock(ExtraThingsBlocks.CHAIR).setRegistryName(ExtraThingsBlocks.CHAIR.getRegistryName());
    
    
    public static void setItemName(Item item, String name)
    {
        item.setRegistryName(ExtraThings.MODID, name).setUnlocalizedName(ExtraThings.MODID + "." + name);
    }
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event)
    {
        for (int i = 0; i < ColorBlock.EnumType.values().length; i++)
            registerModel(BLOCK_COLOR_BLOCK, i);
        registerModel(BLOCK_WHITE_STAIRS, 0);
        registerModel(BLOCK_LIGHT_GRAY_STAIRS, 0);
        registerModel(BLOCK_GRAY_STAIRS, 0);
        registerModel(BLOCK_BLACK_STAIRS, 0);
        registerModel(BLOCK_BROWN_STAIRS, 0);
        registerModel(BLOCK_RED_STAIRS, 0);
        registerModel(BLOCK_ORANGE_STAIRS, 0);
        registerModel(BLOCK_YELLOW_STAIRS, 0);
        registerModel(BLOCK_LIME_STAIRS, 0);
        registerModel(BLOCK_GREEN_STAIRS, 0);
        registerModel(BLOCK_CYAN_STAIRS, 0);
        registerModel(BLOCK_LIGHT_BLUE_STAIRS, 0);
        registerModel(BLOCK_BLUE_STAIRS, 0);
        registerModel(BLOCK_PURPLE_STAIRS, 0);
        registerModel(BLOCK_MAGENTA_STAIRS, 0);
        registerModel(BLOCK_PINK_STAIRS, 0);
        registerModel(BLOCK_TABLE, 0);
        registerModel(BLOCK_CHAIR, 0);
    }

    @SideOnly(Side.CLIENT)
    public static void registerModel(Item item, int metadata)
    {
        if (metadata < 0) metadata = 0;
        String resourceName = item.getUnlocalizedName().substring(5).replace('.', ':');
        if (metadata > 0) resourceName += "_v" + String.valueOf(metadata);

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(resourceName, "inventory"));
    }
}