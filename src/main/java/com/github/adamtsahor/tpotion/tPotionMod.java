package com.github.adamtsahor.tpotion;

import com.github.adamtsahor.tpotion.effect.CustomEffects;
import com.github.adamtsahor.tpotion.mixin.BrewingRecipeRegistryMixin;
import com.github.adamtsahor.tpotion.potion.CustomPotions;
import com.github.adamtsahor.tpotion.recipe.CustomBrews;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;  //the definition of the com.github.adamtsahor.tpotion.potion class
import net.minecraft.potion.Potions; //the list of all potions
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class tPotionMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "tpotion";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	//public static final Potion TPOTION_BASE = new Potion();
	//public static final Potion TPOTION_RECALL = new Potion();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		CustomEffects.registerCustomEffects();
		CustomPotions.registerCustomPotions();
		CustomBrews.registerCustomBrews();

		//Registry.register(Registry.POTION, new Identifier(MOD_ID , "tpotion_base"), TPOTION_BASE);
		//Registry.register(Registry.POTION, new Identifier(MOD_ID , "tpotion_recall"), TPOTION_RECALL);
		//BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.WATER, Items.WARPED_FUNGUS, CustomPotions.RECALL_POTION);



	}
}
