package fr.lavapower.extrathings;

import org.apache.logging.log4j.Logger;

import fr.lavapower.extrathings.commands.CommandInfoExtraThings;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

@Mod(modid = ExtraThings.MODID, name = "Extra Things", version = "1.0", acceptedMinecraftVersions = "[1.12.2]", certificateFingerprint = "d73f57e017bdb28a9abc1d4150827f8063540ab2")
public class ExtraThings
{
    public static final String MODID = "extrathings";
    @Instance(ExtraThings.MODID)
    public static ExtraThings instance;
    @SidedProxy(clientSide = "fr.lavapower.extrathings.ExtraThingsClient", serverSide = "fr.lavapower.extrathings.ExtraThingsServer")
    public static ExtraThingsCommon proxy;

    public static Logger logger;
    public static final ExtraThingsTab creativeTab = new ExtraThingsTab();

    public ExtraThings()
    {
        MinecraftForge.EVENT_BUS.register(new RegisteringHandler());
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new CommandInfoExtraThings());
    }
    
    @EventHandler
    public void onFMLFingerPrintViolation(FMLFingerprintViolationEvent event)
    {
        System.out.println("Modification de la signature.");
        Minecraft.getMinecraft().shutdown();
    }
}
