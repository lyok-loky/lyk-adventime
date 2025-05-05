package io.github.lyem_one.list;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

import java.util.List;



public class FoodList {

    public static final ConsumableComponent FIRE_FOOD_COMPONANT;
    public static final FoodComponent FIRE_FOOD_PROPERTIES;

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    static {
        // Propriétés nutritionnelles
        FIRE_FOOD_PROPERTIES = new FoodComponent.Builder()
                .nutrition(7) // Valeur nutritive
                .saturationModifier(0.3F) // Saturation fournie
                .alwaysEdible() // Mangeable même sans faim
                .build();
        FIRE_FOOD_COMPONANT = food()
                .consumeEffect(new ApplyEffectsConsumeEffect(List.of(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 30 * 20, 1))))
                .build();
    }
}
