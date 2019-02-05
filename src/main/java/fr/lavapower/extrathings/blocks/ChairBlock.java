package fr.lavapower.extrathings.blocks;

import java.util.List;

import fr.lavapower.extrathings.entities.EntityBlockSittable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

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

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return sitPlayer(worldIn, pos, playerIn, 1.0F);
    }

    /**
     * Call this in onBlockActivated
     *
     * @param world
     * @param pos
     * @param player
     * @param entityY
     * @return
     */
    public static boolean sitPlayer(World world, BlockPos pos, EntityPlayer player, float entityY)
    {
        return sitPlayer(world, pos, player, 0.5F, entityY-0.75F, 0.5F);
    }

    /**
     * Call this in onBlockActivated
     *
     * @param world
     * @param pos
     * @param player
     * @param entityX
     * @param entityY
     * @param entityZ
     * @return
     */
    public static boolean sitPlayer(World world, BlockPos pos, EntityPlayer player, float entityX, float entityY, float entityZ)
    {
        if(!world.isRemote)
        {
            List<EntityBlockSittable> listEMB = world.getEntitiesWithinAABB(EntityBlockSittable.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1.0D, pos.getY() + 1.0D, pos.getZ() + 1.0D).expand(1.0D, 1.0D, 1.0D));
            for(EntityBlockSittable entitytocheck : listEMB)
            {
                if((entitytocheck.blockPosX == pos.getX()) && (entitytocheck.blockPosY == pos.getY()) && (entitytocheck.blockPosZ == pos.getZ()))
                {
                    entitytocheck.interact(player);
                    return true;
                }
            }

            EntityBlockSittable entity = new EntityBlockSittable(world, pos, pos.getX() + entityX, pos.getY() + entityY, pos.getZ() + entityZ);
            world.spawnEntity(entity);
            entity.interact(player);
        }
        return true;
    }
}