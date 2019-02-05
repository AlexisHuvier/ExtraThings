package fr.lavapower.extrathings.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class ChairBlock extends SimpleOrientableBlock
{
    protected static final AxisAlignedBB[] AABB = {
            new AxisAlignedBB(0.125D, 0.0D, 0.1875D, 0.875D, 0.5D, 0.8125D), //South
            new AxisAlignedBB(0.1875D, 0.0D, 0.125D, 0.8125D, 0.5D, 0.875D), //West
            new AxisAlignedBB(0.125D, 0.0D, 0.1875D, 0.875D, 0.5D, 0.8125D), //North
            new AxisAlignedBB(0.1875D, 0.0D, 0.125D, 0.8125D, 0.5D, 0.875D)};//East
    
    public static final String NAME = "chair_block";
    
    public ChairBlock(Material materialIn)
    {
        super(materialIn, NAME);
        setLightOpacity(1);
    }
    
    // Pour désactiver le culling
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AABB[state.getValue(FACING).getHorizontalIndex()];
    }

}
