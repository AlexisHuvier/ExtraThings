package fr.lavapower.extrathings.blocks;

import fr.lavapower.extrathings.ExtraThings;
import fr.lavapower.extrathings.utils.DummyBlockProperty;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

public abstract class SimpleBlockSlab extends BlockSlab
{
    public static final DummyBlockProperty DUMMY_VARIANT = DummyBlockProperty.create("dummy");

    public SimpleBlockSlab(Material materialIn, String name)
    {
        super(materialIn);
        setResistance(5.0F);
        setHardness(3.0F);
        setCreativeTab(ExtraThings.creativeTab);
        ExtraThingsBlocks.setBlockName(this, name);
        IBlockState state = this.blockState.getBaseState();
        if (!this.isDouble())
            state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
        setDefaultState(state);
        this.useNeighborBrightness = true;
    }

    @Override
    public String getUnlocalizedName(int meta)
    {
        // TODO Auto-generated method stub
        return this.getUnlocalizedName();
    }

    /**
     * Only use if your block has multiple types, i.e {@link ChipTypes}. If
     * yours does not then just use what I put
     */
    @Override
    public IProperty<?> getVariantProperty() {
        return DUMMY_VARIANT;
    }

    /**
     * Only use if your block has multiple types, i.e {@link ChipTypes}. If
     * yours does not then just use what I put
     */
    @Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return false;
    }

    /**
     * Make it so that meta data won't work with our block
     */
    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    /**
     * Gets the state from the meta data so our block saves correctly
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        if (!this.isDouble())
            return this.getDefaultState().withProperty(HALF,
                    EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
        return this.getDefaultState();
    }

    /**
     * Gets the meta from the state so it will save correctly
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        if (this.isDouble())
            return 0;
        return ((EnumBlockHalf) state.getValue(HALF)).ordinal() + 1;
    }

    /**
     * Register it so that your block has its own half. MUST DO!!
     */
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { HALF, DUMMY_VARIANT });
    }


}
