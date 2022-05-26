package com.github.adamtsahor.tpotion.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Util;

public class WormholeEffect extends StatusEffect {
    public WormholeEffect(StatusEffectCategory statusEffectCategory, int colour){
        super(statusEffectCategory, colour);
    }
    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {

        if (!pLivingEntity.world.isClient()) {
            if(pLivingEntity.isPlayer()){
                PlayerEntity player = (PlayerEntity) pLivingEntity;
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                String[] playerArray = serverPlayer.getServer().getPlayerNames();
                if(playerArray.length < 2 || playerArray==null){
                    player.sendMessage(new LiteralText("No valid target found!"), false);
                }
                else{
                    for (String name:playerArray) {
                        String playerName=player.getEntityName();
                        if(!name.equals(playerName)) {
                            player.sendSystemMessage(
                                    new LiteralText(name).setStyle(Style.EMPTY.withClickEvent(
                                            new ClickEvent(ClickEvent.Action.RUN_COMMAND,
                                                    "/tp @s " + name))), Util.NIL_UUID);
                        }
                    }
                }
                /*
                player.sendMessage(
                        new LiteralText("%s").setStyle(Style.EMPTY.withClickEvent(
                                new ClickEvent(ClickEvent.Action.RUN_COMMAND,
                                        "/tellraw @p [\"CRINGE\"]"))), false);

                 */
            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}