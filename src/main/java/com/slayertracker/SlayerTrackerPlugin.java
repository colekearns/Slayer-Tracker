package com.slayertracker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Slayer Tracker"
)
public class SlayerTrackerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SlayerTrackerConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Slayertracker started!");
		System.out.println("Hi Cole");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Slayertracker stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println(GameState.LOGGED_IN + " You have Logged in Successfully");
			System.out.println("----------------------------------------------------------------------------------");
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
		if (gameStateChanged.getGameState() == GameState.HOPPING) {
			System.out.println("----------------------------------------------------------------------------------");
					System.out.println(GameState.HOPPING + " You have changed world successfully");
					System.out.println("You have hopped to world:" + client.getWorld());
			}
			System.out.println("----------------------------------------------------------------------------------");
		}

	@Provides
	SlayerTrackerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SlayerTrackerConfig.class);
	}
}