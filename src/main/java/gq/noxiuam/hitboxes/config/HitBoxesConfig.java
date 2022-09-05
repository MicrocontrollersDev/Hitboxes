package gq.noxiuam.hitboxes.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import gq.noxiuam.hitboxes.HitBoxes;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;

public class HitBoxesConfig extends cc.polyfrost.oneconfig.config.Config {

    @Page(
            name = "Player Hitbox",
            location = PageLocation.TOP
    )
    public HitboxConfiguration playerHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "Mob Hitbox",
            location = PageLocation.TOP
    )
    public HitboxConfiguration mobHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "Item Hitbox",
            location = PageLocation.TOP
    )
    public HitboxConfiguration itemHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "XP Orb Hitbox",
            location = PageLocation.TOP
    )
    public HitboxConfiguration xpOrbHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "Projectile Hitbox",
            location = PageLocation.TOP
    )
    public HitboxConfiguration projectileHitboxConfig = new HitboxConfiguration();

    public HitBoxesConfig() {
        super(new Mod(HitBoxes.NAME, ModType.UTIL_QOL), HitBoxes.MODID + ".json");
        initialize();

        setupConditions();
    }

    /**
     * Finds a hitbox configuration based on an Entity.
     *
     * @param entity - The entity to find configurations for.
     */
    public HitboxConfiguration getEntityType(Entity entity) {

        if (entity instanceof AbstractClientPlayer) {
            return this.playerHitboxConfig;
        } else if (entity instanceof EntityItem) {
            return this.itemHitboxConfig;
        } else if (entity instanceof EntityXPOrb) {
            return this.xpOrbHitboxConfig;
        } else if (entity instanceof EntityThrowable || entity instanceof EntityArrow) {
            return this.projectileHitboxConfig;
        }

        return this.mobHitboxConfig;
    }

    /**
     * Sets the mod conditions, this will later be setup differently so that it is more efficient, this is it for now though.
     */
    private void setupConditions() {
        // player
        addDependency("Player Hitbox.showOutline", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitbox.dashedHitbox", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitbox.showEyeHeight", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitbox.showLookVector", () -> playerHitboxConfig.showHitbox);

        addDependency("Player Hitbox.outlineThickness", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitbox.eyeHeightThickness", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitbox.lookVectorThickness", () -> playerHitboxConfig.showHitbox);

        addDependency("Player Hitbox.outlineColor", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showOutline);
        addDependency("Player Hitbox.eyeHeightColor", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showEyeHeight);
        addDependency("Player Hitbox.lookVectorColor", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showLookVector);
        addDependency("Player Hitbox.lookVectorDistance", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showLookVector);

        // mob
        addDependency("Mob Hitbox.showOutline", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitbox.dashedHitbox", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitbox.showEyeHeight", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitbox.showLookVector", () -> mobHitboxConfig.showHitbox);

        addDependency("Mob Hitbox.outlineThickness", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitbox.eyeHeightThickness", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitbox.lookVectorThickness", () -> mobHitboxConfig.showHitbox);

        addDependency("Mob Hitbox.outlineColor", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showOutline);
        addDependency("Mob Hitbox.eyeHeightColor", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showEyeHeight);
        addDependency("Mob Hitbox.lookVectorColor", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showLookVector);
        addDependency("Mob Hitbox.lookVectorDistance", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showLookVector);

        // item
        addDependency("Item Hitbox.showOutline", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitbox.dashedHitbox", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitbox.showEyeHeight", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitbox.showLookVector", () -> itemHitboxConfig.showHitbox);

        addDependency("Item Hitbox.outlineThickness", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitbox.eyeHeightThickness", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitbox.lookVectorThickness", () -> itemHitboxConfig.showHitbox);

        addDependency("Item Hitbox.outlineColor", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showOutline);
        addDependency("Item Hitbox.eyeHeightColor", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showEyeHeight);
        addDependency("Item Hitbox.lookVectorColor", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showLookVector);
        addDependency("Item Hitbox.lookVectorDistance", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showLookVector);

        // xp
        addDependency("XP Orb Hitbox.showOutline", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitbox.dashedHitbox", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitbox.showEyeHeight", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitbox.showLookVector", () -> xpOrbHitboxConfig.showHitbox);

        addDependency("XP Orb Hitbox.outlineThickness", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitbox.eyeHeightThickness", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitbox.lookVectorThickness", () -> xpOrbHitboxConfig.showHitbox);

        addDependency("XP Orb Hitbox.outlineColor", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showOutline);
        addDependency("XP Orb Hitbox.eyeHeightColor", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showEyeHeight);
        addDependency("XP Orb Hitbox.lookVectorColor", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showLookVector);
        addDependency("XP Orb Hitbox.lookVectorDistance", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showLookVector);

        // projectile
        addDependency("Projectile Hitbox.showOutline", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitbox.dashedHitbox", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitbox.showEyeHeight", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitbox.showLookVector", () -> projectileHitboxConfig.showHitbox);

        addDependency("Projectile Hitbox.outlineThickness", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitbox.eyeHeightThickness", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitbox.lookVectorThickness", () -> projectileHitboxConfig.showHitbox);

        addDependency("Projectile Hitbox.outlineColor", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showOutline);
        addDependency("Projectile Hitbox.eyeHeightColor", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showEyeHeight);
        addDependency("Projectile Hitbox.lookVectorColor", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showLookVector);
        addDependency("Projectile Hitbox.lookVectorDistance", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showLookVector);
    }

    public static class HitboxConfiguration {

        @Switch(
                name = "Show Hitbox",
                subcategory = "General Options"
        )
        public boolean showHitbox = true;

        @Switch(
                name = "Dashed",
                subcategory = "General Options"
        )
        public boolean dashedHitbox = false;

        @Switch(
                name = "Hitbox Outline",
                subcategory = "General Options"
        )
        public boolean showOutline = true;

        @Switch(
                name = "Eye Height",
                subcategory = "General Options"
        )
        public boolean showEyeHeight = true;

        @Switch(
                name = "Look Vector",
                subcategory = "General Options"
        )
        public boolean showLookVector = true;

        @Slider(
                name = "Outline Thickness",
                subcategory = "General Options",
                min = 1,
                max = 5
        )
        public float outlineThickness = 2;

        @Slider(
                name = "Eye Height Thickness",
                subcategory = "General Options",
                min = 1,
                max = 5
        )
        public float eyeHeightThickness = 2;

        @Slider(
                name = "Look Vector Thickness",
                subcategory = "General Options",
                min = 1,
                max = 5
        )
        public float lookVectorThickness = 2;

        @Slider(
                name = "Look Vector Distance Multiplier",
                subcategory = "General Options",
                min = 2,
                max = 5
        )
        public float lookVectorDistance = 2;

        @Color(
                name = "Hitbox Outline Color",
                subcategory = "Color Options",
                size = 2
        )
        public OneColor outlineColor = new OneColor(-1);

        @Color(
                name = "Eye Height Color",
                subcategory = "Color Options",
                size = 2
        )
        public OneColor eyeHeightColor = new OneColor(0xFFFF0000);

        @Color(
                name = "Look Vector Color",
                subcategory = "Color Options",
                size = 2
        )
        public OneColor lookVectorColor = new OneColor(0xFF0000FF);

    }

}

