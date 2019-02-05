package fr.lavapower.extrathings;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT, modid = ExtraThings.MODID)
public class ExtraThingsEventsClient
{
    public static final Minecraft MC = Minecraft.getMinecraft();
    
    @SubscribeEvent
    public static void renderGameOverlayPre(RenderGameOverlayEvent.Pre event)
    {

    }

    @SubscribeEvent
    public static void renderGameOverlayPost(RenderGameOverlayEvent.Post event)
    {
        if(event.getType().equals(ElementType.ALL)) 
        {
            String fps = MC.debug.split(" ")[0];
            MC.fontRenderer.drawString("FPS : "+fps, 10, 10, Color.WHITE.getRGB());
        }
    }
}
