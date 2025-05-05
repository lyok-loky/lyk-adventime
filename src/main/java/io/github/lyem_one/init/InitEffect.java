package io.github.lyem_one.init;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class InitEffect {
    public class BlueTintEffect extends StatusEffect {
        public BlueTintEffect() {
            super(StatusEffectCategory.NEUTRAL, 0x0000FF); // Couleur bleue (code hexadécimal)
        }

        //@Override
        public void applyEffectTick(LivingEntity entity, int amplifier) {
            // Ajoute ici la logique que tu veux appliquer
            // Exemple : ralentir l'entité ou déclencher un effet
        }

        @Override
        public boolean canApplyUpdateEffect(int duration, int amplifier) {
            return true; // Applique l'effet à chaque tick
        }
    }

}
