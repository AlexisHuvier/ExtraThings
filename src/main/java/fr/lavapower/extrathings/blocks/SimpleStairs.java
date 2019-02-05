package fr.lavapower.extrathings.blocks;

import fr.lavapower.extrathings.ExtraThings;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class SimpleStairs extends BlockStairs
{
    public static String name_block = "not_defined";

    protected SimpleStairs(IBlockState modelState, String name)
    {
        super(modelState);
        name_block = name;
        ExtraThingsBlocks.setBlockName(this, name_block);
        setResistance(5.0F);
        setHardness(3.0F);
        setLightOpacity(1);
        setCreativeTab(ExtraThings.creativeTab);
    }

}
