package fr.lavapower.extrathings.blocks;

import fr.lavapower.extrathings.ExtraThings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ExtraThingsBlocks
{
    public static final Block COLOR_BLOCK = new ColorBlock(Material.ROCK);
    public static final Block WHITE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "white_stairs");
    public static final Block LIGHT_GRAY_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "light_gray_stairs");
    public static final Block GRAY_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "gray_stairs");
    public static final Block BLACK_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "black_stairs");
    public static final Block BROWN_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "brown_stairs");
    public static final Block RED_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "red_stairs");
    public static final Block ORANGE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "orange_stairs");
    public static final Block YELLOW_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "yellow_stairs");
    public static final Block LIME_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "lime_stairs");
    public static final Block GREEN_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "green_stairs");
    public static final Block CYAN_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "cyan_stairs");
    public static final Block LIGHT_BLUE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "light_blue_stairs");
    public static final Block BLUE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "blue_stairs");
    public static final Block PURPLE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "purple_stairs");
    public static final Block MAGENTA_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "magenta_stairs");
    public static final Block PINK_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "pink_stairs");
    public static final Block TABLE = new TableBlock(Material.WOOD);
    public static final Block CHAIR = new ChairBlock(Material.WOOD);
    public static final Block CUPBOARD = new CupboardBlock(Material.WOOD);
    
    public static void setBlockName(Block block, String name)
    {
        block.setRegistryName(ExtraThings.MODID, name).setUnlocalizedName(ExtraThings.MODID + "." + name);
    }
}
