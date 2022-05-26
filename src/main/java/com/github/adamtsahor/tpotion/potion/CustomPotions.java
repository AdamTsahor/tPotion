package com.github.adamtsahor.tpotion.potion;

import com.github.adamtsahor.tpotion.effect.CustomEffects;
import com.github.adamtsahor.tpotion.tPotionMod;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class CustomPotions {

    public static Potion BASE_POTION;
    public static Potion RECALL_POTION;
    public static Potion WORMHOLE_POTION;
    public static Potion CHOIR_POTION;

    public static Potion registerPotion(String name){
        Identifier idn = new Identifier(tPotionMod.MOD_ID, name);
        return Registry.register(Registry.POTION,idn, new Potion());
    }
    public static Potion registerPotion(String name, StatusEffectInstance effectInstance){
        Identifier idn = new Identifier(tPotionMod.MOD_ID, name);
        return Registry.register(Registry.POTION,idn, new Potion(effectInstance));
    }

    public static void registerCustomPotions(){

        //REGISTER BASE_POTION
        BASE_POTION = registerPotion("tpotion_base");


        //Register RECALL_POTIION
        StatusEffectInstance RECALL_INSTANCE = new StatusEffectInstance(CustomEffects.RECALL,1,0);
        RECALL_POTION = registerPotion("tpotion_recall", RECALL_INSTANCE);

        //Register WARMHOLE_POTION
        StatusEffectInstance WORMHOLE_INSTANCE = new StatusEffectInstance(CustomEffects.WORMHOLE,1,0);
        WORMHOLE_POTION = registerPotion("tpotion_wormhole", WORMHOLE_INSTANCE);

        //Register CHOIR_POTION
        StatusEffectInstance CHOIR_INSTANCE = new StatusEffectInstance(CustomEffects.CHOIR,1,0);
        CHOIR_POTION = registerPotion("tpotion_choir",CHOIR_INSTANCE);
    }
}
