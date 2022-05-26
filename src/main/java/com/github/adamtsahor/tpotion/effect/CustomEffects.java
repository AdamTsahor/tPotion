package com.github.adamtsahor.tpotion.effect;

import com.github.adamtsahor.tpotion.tPotionMod;
import jdk.jshell.Snippet;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class CustomEffects {
    public static StatusEffect RECALL;
    public static StatusEffect WORMHOLE;
    public static StatusEffect CHOIR;
    public static StatusEffect registerStatusEffect(String name, StatusEffect effect){
        Identifier idn = new Identifier(tPotionMod.MOD_ID, name);
        return Registry.register(Registry.STATUS_EFFECT,idn, effect);
    }

    public static void registerCustomEffects(){
        RECALL = registerStatusEffect("recall", new RecallEffect(StatusEffectCategory.NEUTRAL, 3124687));
        WORMHOLE = registerStatusEffect("wormhole", new WormholeEffect(StatusEffectCategory.NEUTRAL, 15801));
        CHOIR = registerStatusEffect("choir",new ChoirEffect(StatusEffectCategory.NEUTRAL,8335775));
    }
}