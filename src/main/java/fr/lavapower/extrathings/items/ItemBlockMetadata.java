package fr.lavapower.extrathings.items;

import fr.lavapower.extrathings.ExtraThings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetadata extends ItemBlock
{
    String[] unlocalizedNames;
    
    public ItemBlockMetadata(Block block, String[] unlocalizedNamesIn)
    {
        super(block);
        this.unlocalizedNames = unlocalizedNamesIn;
        setHasSubtypes(true);
        setMaxDamage(0);
    }
 
    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
 
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return ExtraThings.MODID + "." + unlocalizedNames[stack.getMetadata()];
    }
}
