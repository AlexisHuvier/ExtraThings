package fr.lavapower.extrathings.blocks;

import fr.lavapower.extrathings.ExtraThings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ExtraThingsBlocks
{
    public static final ColorBlock COLOR_BLOCK = new ColorBlock(Material.ROCK);
    public static final SimpleStairs WHITE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "white_stairs");
    public static final SimpleStairs LIGHT_GRAY_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "light_gray_stairs");
    public static final SimpleStairs GRAY_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "gray_stairs");
    public static final SimpleStairs BLACK_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "black_stairs");
    public static final SimpleStairs BROWN_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "brown_stairs");
    public static final SimpleStairs RED_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "red_stairs");
    public static final SimpleStairs ORANGE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "orange_stairs");
    public static final SimpleStairs YELLOW_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "yellow_stairs");
    public static final SimpleStairs LIME_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "lime_stairs");
    public static final SimpleStairs GREEN_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "green_stairs");
    public static final SimpleStairs CYAN_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "cyan_stairs");
    public static final SimpleStairs LIGHT_BLUE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "light_blue_stairs");
    public static final SimpleStairs BLUE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "blue_stairs");
    public static final SimpleStairs PURPLE_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "purple_stairs");
    public static final SimpleStairs MAGENTA_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "magenta_stairs");
    public static final SimpleStairs PINK_STAIRS = new SimpleStairs(COLOR_BLOCK.getDefaultState(), "pink_stairs");
    public static final TableBlock TABLE = new TableBlock(Material.WOOD);
    public static final ChairBlock CHAIR = new ChairBlock(Material.WOOD);
    public static final CupboardBlock CUPBOARD = new CupboardBlock(Material.WOOD);
    public static final TrashBlock TRASH = new TrashBlock(Material.IRON);
    
    public static void setBlockName(Block block, String name)
    {
        block.setRegistryName(ExtraThings.MODID, name).setUnlocalizedName(ExtraThings.MODID + "." + name);
    }
}
