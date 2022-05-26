package com.github.adamtsahor.tpotion.effect;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.apache.logging.log4j.core.jmx.Server;


public class RecallEffect extends StatusEffect {
    public RecallEffect(StatusEffectCategory statusEffectCategory, int colour){
        super(statusEffectCategory, colour);
    }
    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {

        if (!pLivingEntity.world.isClient()) {
            if(pLivingEntity.isPlayer()){
                PlayerEntity player = (PlayerEntity) pLivingEntity;
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                BlockPos spawnPoint = serverPlayer.getSpawnPointPosition();
                RegistryKey<World> spawn_dim = serverPlayer.getSpawnPointDimension();
                RegistryKey<World> curr_dim = serverPlayer.world.getRegistryKey();

                double spawn_x;
                double spawn_y;
                double spawn_z;
                if(spawnPoint==null){
                    player.sendSystemMessage(new LiteralText("No spawn point found!"), Util.NIL_UUID);
                }
                else if (spawn_dim==curr_dim){
                    spawn_x = spawnPoint.getX();
                    spawn_y = spawnPoint.getY();
                    spawn_z = spawnPoint.getZ();
                    serverPlayer.requestTeleport(spawn_x,spawn_y,spawn_z);
                }
                else{
                    player.sendSystemMessage(new LiteralText("Your spawn point is in a different dimension!"), Util.NIL_UUID);
                }


            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
