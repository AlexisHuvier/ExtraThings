package fr.lavapower.extrathings;

import fr.lavapower.extrathings.blocks.ExtraThingsBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ExtraThingsTab extends CreativeTabs
{

    public ExtraThingsTab()
    {
        super(ExtraThings.MODID);
    }

    @Override
    public ItemStack getTabIconItem()
    {
    	return new ItemStack(ExtraThingsBlocks.COLOR_BLOCK);
    }
}
