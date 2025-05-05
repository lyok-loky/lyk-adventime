package io.github.lyem_one.init;

import io.github.lyem_one.LykAdventime;
import io.github.lyem_one.init.InitHandheldItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;

public class ItemWithEffect {

    // Classe interne
    public static class FireSwordFireinit extends SwordItem {
        public FireSwordFireinit(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            // Enflamme la cible
            target.setOnFireFor(5); // Enflamme pendant 5 secondes
            target.removeStatusEffect(StatusEffects.SLOWNESS);
            // Vous pouvez ajouter des effets supplémentaires ici
            // stack.damage(1, attacker, (entity) -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

            return super.postHit(stack, target, attacker);
        }
    }

    public static class IcedSwordInit extends SwordItem {
        public IcedSwordInit(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            // gêle la cible
            // Si l'entité est en feu, on éteint le feu immédiatement
            if (target.isOnFire()) {
                target.extinguish();
            }

            double x = target.getX();
            double y = target.getY();
            double z = target.getZ();

            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 100));
            World world = target.getWorld();
            for (int i = 0; i < 20; i++) { // Génère 20 particules
                world.addParticle(ParticleTypes.SNOWFLAKE, x, y, z, 0.5, 0.5, 0.1);
                System.out.println("x: " + x + ", y: " + y + ", z: " + z);
                LykAdventime.LOGGER.info("x: " + x + ", y: " + y + ", z: " + z);
            }
            // Vous pouvez ajouter des effets supplémentaires ici
            // stack.damage(1, attacker, (entity) -> entity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

            return super.postHit(stack, target, attacker);
        }
    }
}
