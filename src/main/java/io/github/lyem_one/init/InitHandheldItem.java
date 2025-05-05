package io.github.lyem_one.init;
import io.github.lyem_one.LykAdventime;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class InitHandheldItem {

    // Déclaration de l'item
    public static final Item FIRE_SWORD;
    public static final Item ICED_SWORD;

    static {
        // Création de l'identifier
        Identifier id = Identifier.of("lyk-adventime", "fire_sword");

        // Création de la clé de registre
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Configuration des paramètres de l'item
        Item.Settings settings = new Item.Settings().registryKey(key); // Associe la clé au Settings

        // Enregistrement de l'item
        FIRE_SWORD = Registry.register(Registries.ITEM, key, new ItemWithEffect.FireSwordFireinit(ToolMaterial.STONE, 3f, -2.3f, settings));

    }

    static {
        // Création de l'identifier
        Identifier id = Identifier.of("lyk-adventime", "iced_sword");

        // Création de la clé de registre
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);

        // Configuration des paramètres de l'item
        Item.Settings settings = new Item.Settings().registryKey(key); // Associe la clé au Settings

        // Enregistrement de l'item
        ICED_SWORD = Registry.register(Registries.ITEM, key, new ItemWithEffect.IcedSwordInit(ToolMaterial.STONE, 3f, -2.3f, settings));

    }

    // Fonction pour s'assurer que les items sont chargés (appelée dans onInitialize)
    public static void load() {
        LykAdventime.LOGGER.info("Items enregistrés avec RegistryKey !");
    }
}