package fr.lavapower.extrathings.blocks;

import fr.lavapower.extrathings.ExtraThings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class ColorBlock extends Block
{
    public static final String NAME = "color_block";
    public static final PropertyEnum<ColorBlock.EnumType> VARIANT = PropertyEnum.<ColorBlock.EnumType>create("variant", ColorBlock.EnumType.class);

    public ColorBlock(Material materialIn)
    {
        super(materialIn);
        ExtraThingsBlocks.setBlockName(this, NAME);
        setResistance(5.0F);
        setHardness(3.0F);
        setCreativeTab(ExtraThings.creativeTab);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, ColorBlock.EnumType.WHITE));
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return state.getValue(VARIANT).getMetadata();
    }
    
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList <ItemStack>list)
    {
        for (ColorBlock.EnumType type : ColorBlock.EnumType.values())
        {
            list.add(new ItemStack(this, 1, type.getMetadata()));
        }
    }
 
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, ColorBlock.EnumType.byMetadata(meta));
    }
 
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((ColorBlock.EnumType)state.getValue(VARIANT)).getMetadata();
    }
 
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }
 
    public static enum EnumType implements IStringSerializable
    {
        WHITE(0, "white", "color_block"),
        LIGHT_GRAY(1, "light_gray", "color_block_v1"),
        GRAY(2, "gray", "color_block_v2"),
        BLACK(3, "black", "color_block_v3"),
        BROWN(4, "brown", "color_block_v4"),
        RED(5, "red", "color_block_v5"),
        ORANGE(6, "orange", "color_block_v6"),
        YELLOW(7, "yellow", "color_block_v7"),
        LIME(8, "lime", "color_block_v8"),
        GREEN(9, "green", "color_block_v9"),
        CYAN(10, "cyan", "color_block_v10"),
        LIGHT_BLUE(11, "light_blue", "color_block_v11"),
        BLUE(12, "blue", "color_block_v12"),
        PURPLE(13, "purple", "color_block_v13"),
        MAGENTA(14, "magenta", "color_block_v14"),
        PINK(15, "pink", "color_block_v15");
 
        private static final ColorBlock.EnumType[] META_LOOKUP = new ColorBlock.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
 
        private EnumType(int metaIn, String nameIn, String unlocalizedIn)
        {
            this.meta = metaIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedIn;
        }
 
        public static String[] getUnlocalizedNames()
        {
            String[] names = new String[values().length];
            
            for (int i = 0; i < META_LOOKUP.length; i++)
                names[i] = META_LOOKUP[i].unlocalizedName;
         
            return names;
        }
 
        public int getMetadata()
        {
            return this.meta;
        }
 
        public static ColorBlock.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }
         
            return META_LOOKUP[meta];
        }
 
        public String toString()
        {
            return this.name;
        }
 
        @Override
        public String getName()
        {
            return this.name;
        }
        
        static
        {
            for (ColorBlock.EnumType type : values())
            {
                META_LOOKUP[type.getMetadata()] = type;
            }
        }
    }
    
}
