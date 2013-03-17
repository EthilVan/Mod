package fr.ethilvan.client;

import net.minecraftforge.client.MinecraftForgeClient;
import fr.ethilvan.common.CommonProxy;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings(){
		MinecraftForgeClient.preloadTexture(this.texture);
	}
}
