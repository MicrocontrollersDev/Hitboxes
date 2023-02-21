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
            name = "Player Hitboxes",
            location = PageLocation.TOP
    )
    public HitboxConfiguration playerHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "Mob Hitboxes",
            location = PageLocation.TOP
    )
    public HitboxConfiguration mobHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "Item Hitboxes",
            location = PageLocation.TOP
    )
    public HitboxConfiguration itemHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "XP Orb Hitboxes",
            location = PageLocation.TOP
    )
    public HitboxConfiguration xpOrbHitboxConfig = new HitboxConfiguration();

    @Page(
            name = "Projectile Hitboxes",
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
        addDependency("Player Hitboxes.showOutline", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitboxes.dashedHitbox", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitboxes.showEyeHeight", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitboxes.showLookVector", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);

        addDependency("Player Hitboxes.outlineThickness", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitboxes.eyeHeightThickness", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);
        addDependency("Player Hitboxes.lookVectorThickness", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox);

        addDependency("Player Hitboxes.outlineColor", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showOutline);
        addDependency("Player Hitboxes.eyeHeightColor", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showEyeHeight);
        addDependency("Player Hitboxes.lookVectorColor", "playerHitboxConfig.showHitbox", () -> playerHitboxConfig.showHitbox && playerHitboxConfig.showLookVector);

        // mob
        addDependency("Mob Hitboxes.showOutline", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitboxes.dashedHitbox", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitboxes.showEyeHeight", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitboxes.showLookVector", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);

        addDependency("Mob Hitboxes.outlineThickness", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitboxes.eyeHeightThickness", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);
        addDependency("Mob Hitboxes.lookVectorThickness", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox);

        addDependency("Mob Hitboxes.outlineColor", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showOutline);
        addDependency("Mob Hitboxes.eyeHeightColor", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showEyeHeight);
        addDependency("Mob Hitboxes.lookVectorColor", "mobHitboxConfig.showHitbox", () -> mobHitboxConfig.showHitbox && mobHitboxConfig.showLookVector);

        // item
        addDependency("Item Hitboxes.showOutline", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitboxes.dashedHitbox", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitboxes.showEyeHeight", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitboxes.showLookVector", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);

        addDependency("Item Hitboxes.outlineThickness", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitboxes.eyeHeightThickness", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);
        addDependency("Item Hitboxes.lookVectorThickness", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox);

        addDependency("Item Hitboxes.outlineColor", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showOutline);
        addDependency("Item Hitboxes.eyeHeightColor", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showEyeHeight);
        addDependency("Item Hitboxes.lookVectorColor", "itemHitboxConfig.showHitbox", () -> itemHitboxConfig.showHitbox && itemHitboxConfig.showLookVector);

        // xp
        addDependency("XP Orb Hitboxes.showOutline", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitboxes.dashedHitbox", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitboxes.showEyeHeight", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitboxes.showLookVector", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);

        addDependency("XP Orb Hitboxes.outlineThickness", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitboxes.eyeHeightThickness", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);
        addDependency("XP Orb Hitboxes.lookVectorThickness", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox);

        addDependency("XP Orb Hitboxes.outlineColor", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showOutline);
        addDependency("XP Orb Hitboxes.eyeHeightColor", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showEyeHeight);
        addDependency("XP Orb Hitboxes.lookVectorColor", "xpOrbHitboxConfig.showHitbox", () -> xpOrbHitboxConfig.showHitbox && xpOrbHitboxConfig.showLookVector);

        // projectile
        addDependency("Projectile Hitboxes.showOutline", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitboxes.dashedHitbox", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitboxes.showEyeHeight", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitboxes.showLookVector", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);

        addDependency("Projectile Hitboxes.outlineThickness", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitboxes.eyeHeightThickness", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);
        addDependency("Projectile Hitboxes.lookVectorThickness", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox);

        addDependency("Projectile Hitboxes.outlineColor", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showOutline);
        addDependency("Projectile Hitboxes.eyeHeightColor", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showEyeHeight);
        addDependency("Projectile Hitboxes.lookVectorColor", "projectileHitboxConfig.showHitbox", () -> projectileHitboxConfig.showHitbox && projectileHitboxConfig.showLookVector);
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
