package io.github.lyem_one.init;

import io.github.lyem_one.list.FoodList;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import io.github.lyem_one.LykAdventime;

public class InitItem {

    public static final Item FIRE_FOOD;
    public static final Item INFLAMED_STONE;

    static {
        // Création de l'identifier
        Identifier id = Identifier.of("lyk-adventime", "fire_food");
        LykAdventime.LOGGER.info("Registering FIRE_FOOD with model: " + id);

        // Création de la clé de registre
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Configuration des paramètres de l'item
        Item.Settings settings = new Item.Settings().food(FoodList.FIRE_FOOD_PROPERTIES, FoodList.FIRE_FOOD_COMPONANT).maxCount(8)
                .registryKey(key); // Associe la clé au Settings

        // Enregistrement de l'item
        FIRE_FOOD = Registry.register(Registries.ITEM, key, new Item(settings));

    }

    static {
        // Création de l'identifier
        Identifier id = Identifier.of("lyk-adventime", "inflamed_stone");
        LykAdventime.LOGGER.info("Registering INFLAMED_STONE with model: " + id);

        // Création de la clé de registre
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Configuration des paramètres de l'item
        Item.Settings settings = new Item.Settings().maxCount(64)
                .registryKey(key); // Associe la clé au Settings

        // Enregistrement de l'item
        INFLAMED_STONE = Registry.register(Registries.ITEM, key, new Item(settings));
    }

    // Fonction pour s'assurer que les items sont chargés (appelée dans onInitialize)
    public static void load() {
        LykAdventime.LOGGER.info("Items enregistrés avec RegistryKey !");
    }
}

