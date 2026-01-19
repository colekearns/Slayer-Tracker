package com.slayertracker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("slayertracker")
	public interface SlayerTrackerConfig extends Config
{
	// --- General Settings ---
	@ConfigSection(
			name = "General",
			description = "General panel visibility settings",
			position = 0,
			closedByDefault = false
	)
	String generalSettings = "generalSettings";

	@ConfigItem(
			keyName = "showSidePanel",
			name = "Show Side Panel",
			description = "Toggle option to show side panel.",
			section = generalSettings,
			position = 1
	)
	default boolean showSidePanel()
	{
		return true;
	}
}