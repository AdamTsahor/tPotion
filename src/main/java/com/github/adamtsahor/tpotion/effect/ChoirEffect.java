package com.github.adamtsahor.tpotion.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.ThreadLocalRandom;


public class ChoirEffect extends StatusEffect {
    public ChoirEffect(StatusEffectCategory statusEffectCategory, int colour){
        super(statusEffectCategory, colour);
    }
    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {

        if (!pLivingEntity.world.isClient()) {
            if(pLivingEntity.isPlayer()){
                PlayerEntity player = (PlayerEntity) pLivingEntity;
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                World world = serverPlayer.getWorld();

                double x = serverPlayer.getX();
                double y = serverPlayer.getY();
                double z = serverPlayer.getZ();

                boolean isValidTarget = false;

                do{ // repeat until valid teleportation target is found
                    int min = 1;
                    int max = 256; //16 chunks
                    int x_rand = ThreadLocalRandom.current().nextInt((int)x + min, (int)x + max+1);
                    int z_rand = ThreadLocalRandom.current().nextInt((int)z + min, (int)z + max+1);

                    min = -64;
                    max = 320;
                    int y_rand = ThreadLocalRandom.current().nextInt(min, max+1);
                    BlockPos target_pos = new BlockPos(x_rand,y_rand,z_rand);
                    BlockPos target_ceiling = target_pos.up();
                    BlockPos target_floor = target_pos.down();
                    boolean hasFloor = !world.getBlockState(target_floor).isAir();
                    boolean isEmpty  = world.getBlockState(target_pos).isAir();
                    if(isEmpty && hasFloor){
                        isValidTarget = true;
                        x = target_pos.getX();
                        y = target_pos.getY();
                        z = target_pos.getZ();
                    }
                } while (!isValidTarget);
                serverPlayer.requestTeleport(x,y,z);


            }
        }
        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}
