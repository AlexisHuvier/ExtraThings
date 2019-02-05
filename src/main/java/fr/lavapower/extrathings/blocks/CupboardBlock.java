package fr.lavapower.extrathings.blocks;

import javax.annotation.Nullable;

import fr.lavapower.extrathings.tileentities.TileEntityCupboard;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;

public class CupboardBlock extends SimpleOrientableBlock
{
    public static final String NAME = "cupboard_block";
    public final BlockChest.Type chestType = BlockChest.Type.BASIC;

    public CupboardBlock(Material materialIn)
    {
        super(materialIn, NAME);
        setLightOpacity(1);
        this.hasTileEntity = true;
    }

    @Override
    public boolean hasTileEntity(final IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(final World world, final IBlockState state)
    {
        return new TileEntityCupboard();
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

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if(tileentity instanceof IInventory)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ILockableContainer ilockablecontainer = this.getLockableContainer(worldIn, pos);

            if(ilockablecontainer != null)
            {
                playerIn.displayGUIChest(ilockablecontainer);
            }

            return true;
        }
    }

    @Nullable
    public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
    {
        return this.getContainer(worldIn, pos, false);
    }

    @Nullable
    public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if(!(tileentity instanceof TileEntityCupboard))
        {
            return null;
        }
        else
        {
            ILockableContainer ilockablecontainer = (TileEntityCupboard)tileentity;

            for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                BlockPos blockpos = pos.offset(enumfacing);
                Block block = worldIn.getBlockState(blockpos).getBlock();

                if(block == this)
                {

                    TileEntity tileentity1 = worldIn.getTileEntity(blockpos);

                    if(tileentity1 instanceof TileEntityCupboard)
                    {
                        if(enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
                        {
                            ilockablecontainer = new InventoryLargeChest("container.chestDouble", ilockablecontainer, (TileEntityCupboard)tileentity1);
                        }
                        else
                        {
                            ilockablecontainer = new InventoryLargeChest("container.chestDouble", (TileEntityCupboard)tileentity1, ilockablecontainer);
                        }
                    }
                }
            }

            return ilockablecontainer;
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityCupboard();
    }

}
