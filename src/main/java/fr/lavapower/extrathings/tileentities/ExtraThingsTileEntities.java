package fr.lavapower.extrathings.tileentities;

import fr.lavapower.extrathings.ExtraThings;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExtraThingsTileEntities
{
    public static void registerTileEntities() {
        registerTileEntity(TileEntityCupboard.class, "cupboard_block");
    }

    public static void registerTileEntity(final Class<? extends TileEntity> tileEntityClass, final String name) {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(ExtraThings.MODID, name));
    }
}
