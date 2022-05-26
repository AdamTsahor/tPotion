package com.github.adamtsahor.tpotion.recipe;

import com.github.adamtsahor.tpotion.effect.CustomEffects;
import com.github.adamtsahor.tpotion.mixin.BrewingRecipeRegistryMixin;
import com.github.adamtsahor.tpotion.potion.CustomPotions;
import com.github.adamtsahor.tpotion.tPotionMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CustomBrews {

    public static void registerBrew(Potion before, Item ingredient, Potion after){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(before, ingredient, after);
    }

    public static void registerCustomBrews(){


        //REGISTER BASE_POTION Brew
        registerBrew(Potions.WATER, Items.WARPED_FUNGUS, CustomPotions.BASE_POTION);


        //Register RECALL_POTIION Brew
        registerBrew(CustomPotions.BASE_POTION, Items.WHITE_BED, CustomPotions.RECALL_POTION);

        //register WORMHOLE_POTION Brew
        registerBrew(CustomPotions.BASE_POTION, Items.ENDER_EYE, CustomPotions.WORMHOLE_POTION);

        //register CHOIR_POTION Brew
        registerBrew(CustomPotions.BASE_POTION, Items.POPPED_CHORUS_FRUIT, CustomPotions.CHOIR_POTION);
    }
}