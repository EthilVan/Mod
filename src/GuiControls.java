package net.minecraft.src;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;

public class GuiControls extends GuiScreen
{
	private GuiScreen parentScreen;
	private GameSettings options;
	private GuiListControls guiListControls;

	public GuiControls(GuiScreen guiscreen, GameSettings gamesettings)
	{
		parentScreen = guiscreen;
		options = gamesettings;
	}

	private int func_20080_j()
	{
		return width / 2 - 155;
	}

	public void initGui()
	{
		StringTranslate stringtranslate = StringTranslate.getInstance();

		guiListControls = new GuiListControls(parentScreen.mc, this, options);

		buttonList.add(new GuiButton(-200, width / 2 - 100, height / 6 + 168, stringtranslate.translateKey("gui.done")));
	}

	protected void actionPerformed(GuiButton guibutton){
		if(guibutton.id == -200){
			mc.displayGuiScreen(parentScreen);
		}
	}

	protected void mouseClicked(int mouseX, int mouseY, int button) {
		guiListControls.mouseClicked(mouseX, mouseY, button);
		super.mouseClicked(mouseX, mouseY, button);
	}

	protected void mouseMovedOrUp(int mouseX, int mouseY, int button) {
		guiListControls.mouseMovedOrUp(mouseX, mouseY, button);
		super.mouseMovedOrUp(mouseX, mouseY, button);
	}

	protected void keyTyped(char key, int keyId) {
		guiListControls.keyTyped(key, keyId);
		super.keyTyped(key, keyId);
	}

	public void handleMouseInput() {
		int amount = Mouse.getEventDWheel();
		if(amount != 0) {
			guiListControls.mouseScrolled(amount);
		}
		super.handleMouseInput();
	}

	public void drawScreen(int i, int j, float f){
		drawDefaultBackground();
		guiListControls.drawScreen(i, j, f);

		super.drawScreen(i, j, f);

	}
}