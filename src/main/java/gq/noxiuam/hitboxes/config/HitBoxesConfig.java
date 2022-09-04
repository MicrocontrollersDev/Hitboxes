package gq.noxiuam.hitboxes.config;

import cc.polyfrost.oneconfig.config.annotations.Checkbox;
import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.core.OneColor;
import gq.noxiuam.hitboxes.HitBoxes;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;

public class HitBoxesConfig extends cc.polyfrost.oneconfig.config.Config {

    // player
    @Switch(name = "Player Hitbox", subcategory = "Player Hitbox Options")
    public boolean showPlayerHitbox = true;

    @Checkbox(name = "Dashed", subcategory = "Player Hitbox Options")
    public boolean dashedPlayerHitbox = false;

    @Switch(name = "Player Hitbox Outline", subcategory = "Player Hitbox Options")
    public boolean showPlayerOutline = true;

    @Color(name = "Player Hitbox Outline Color", subcategory = "Player Hitbox Options")
    public OneColor playerOutlineColor = new OneColor(-1);

    @Switch(name = "Player Eye Height", subcategory = "Player Hitbox Options")
    public boolean showPlayerEyeHeight = true;

    @Color(name = "Player Eye Height Color", subcategory = "Player Hitbox Options")
    public OneColor playerEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(name = "Player Look Vector", subcategory = "Player Hitbox Options")
    public boolean showPlayerLookVector = true;

    @Color(name = "Player Look Vector Color", subcategory = "Player Hitbox Options")
    public OneColor playerLookVectorColor = new OneColor(0xFF0000FF);

    // mob
    @Switch(name = "Mob Hitbox", subcategory = "Mob Hitbox Options")
    public boolean showMobHitbox = true;

    @Checkbox(name = "Dashed", subcategory = "Mob Hitbox Options")
    public boolean dashedMobHitbox = false;

    @Switch(name = "Mob Hitbox Outline", subcategory = "Mob Hitbox Options")
    public boolean showMobOutline = true;

    @Color(name = "Mob Outline Color", subcategory = "Mob Hitbox Options")
    public OneColor mobOutlineColor = new OneColor(-1);

    @Switch(name = "Mob Eye Height", subcategory = "Mob Hitbox Options")
    public boolean showMobEyeHeight = true;

    @Color(name = "Mob Eye Height Color", subcategory = "Mob Hitbox Options")
    public OneColor mobEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(name = "Mob Look Vector", subcategory = "Mob Hitbox Options")
    public boolean showMobLookVector = true;

    @Color(name = "Mob Look Vector Color", subcategory = "Mob Hitbox Options")
    public OneColor mobLookVectorColor = new OneColor(0xFF0000FF);

    // item
    @Switch(name = "Item Hitbox", subcategory = "Item Hitbox Options")
    public boolean showItemHitbox = false;

    @Checkbox(name = "Dashed", subcategory = "Item Hitbox Options")
    public boolean dashedItemHitbox = false;

    @Switch(name = "Item Hitbox Outline", subcategory = "Item Hitbox Options")
    public boolean showItemOutline = true;

    @Color(name = "Item Outline Color", subcategory = "Item Hitbox Options")
    public OneColor itemOutlineColor = new OneColor(-1);

    @Switch(name = "Item Eye Height", subcategory = "Item Hitbox Options")
    public boolean showItemEyeHeight = true;

    @Color(name = "Item Eye Height Color", subcategory = "Item Hitbox Options")
    public OneColor itemEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(name = "Item Look Vector", subcategory = "Item Hitbox Options")
    public boolean showItemLookVector = true;

    @Color(name = "Item Look Vector Color", subcategory = "Item Hitbox Options")
    public OneColor itemLookVectorColor = new OneColor(0xFF0000FF);

    // projectiles
    @Switch(name = "Projectile Hitbox", subcategory = "Projectile Hitbox Options")
    public boolean showProjectileHitbox = false;

    @Checkbox(name = "Dashed", subcategory = "Projectile Hitbox Options")
    public boolean dashedProjectileHitbox = false;

    @Switch(name = "Projectile Hitbox Outline", subcategory = "Projectile Hitbox Options")
    public boolean showProjectileOutline = true;

    @Color(name = "Projectile Outline Color", subcategory = "Projectile Hitbox Options")
    public OneColor projectileOutlineColor = new OneColor(-1);

    @Switch(name = "Projectile Eye Height", subcategory = "Projectile Hitbox Options")
    public boolean showProjectileEyeHeight = true;

    @Color(name = "Projectile Eye Height Color", subcategory = "Projectile Hitbox Options")
    public OneColor projectileEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(name = "Projectile Look Vector", subcategory = "Projectile Hitbox Options")
    public boolean showProjectileLookVector = true;

    @Color(name = "Projectile Look Vector Color", subcategory = "Projectile Hitbox Options")
    public OneColor projectileLookVectorColor = new OneColor(0xFF0000FF);

    // xp orb
    @Switch(name = "XP Orb Hitbox", subcategory = "XP Orb Hitbox Options")
    public boolean showXPOrbHitbox = false;

    @Checkbox(name = "Dashed", subcategory = "XP Orb Hitbox Options")
    public boolean dashedXPOrbHitbox = false;

    @Switch(name = "XP Orb Hitbox Outline", subcategory = "XP Orb Hitbox Options")
    public boolean showXPOrbOutline = true;

    @Color(name = "XP Orb Outline Color", subcategory = "XP Orb Hitbox Options")
    public OneColor xpOrbOutlineColor = new OneColor(-1);

    @Switch(name = "XP Orb Eye Height", subcategory = "XP Orb Hitbox Options")
    public boolean showXPOrbEyeHeight = true;

    @Color(name = "XP Orb Eye Height Color", subcategory = "XP Orb Hitbox Options")
    public OneColor xpOrbEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(name = "XP Orb Look Vector", subcategory = "XP Orb Hitbox Options")
    public boolean showXPOrbLookVector = true;

    @Color(name = "XP Orb Look Vector Color", subcategory = "XP Orb Hitbox Options")
    public OneColor xpOrbLookVectorColor = new OneColor(0xFF0000FF);

    public HitBoxesConfig() {
        super(new Mod(HitBoxes.NAME, ModType.UTIL_QOL), HitBoxes.MODID + ".json");
        initialize();

        // player
        addDependency("showPlayerOutline", () -> showPlayerHitbox);
        addDependency("dashedPlayerHitbox", () -> showPlayerHitbox);
        addDependency("showPlayerEyeHeight", () -> showPlayerHitbox);
        addDependency("showPlayerLookVector", () -> showPlayerHitbox);

        addDependency("playerOutlineColor", () -> showPlayerHitbox && showPlayerOutline);
        addDependency("playerEyeHeightColor", () -> showPlayerHitbox && showPlayerEyeHeight);
        addDependency("playerLookVectorColor", () -> showPlayerHitbox && showPlayerLookVector);

        // mob
        addDependency("showMobOutline", () -> showMobHitbox);
        addDependency("dashedMobHitbox", () -> showMobHitbox);
        addDependency("showMobEyeHeight", () -> showMobHitbox);
        addDependency("showMobLookVector", () -> showMobHitbox);

        addDependency("mobOutlineColor", () -> showMobHitbox && showMobOutline);
        addDependency("mobEyeHeightColor", () -> showMobHitbox && showMobEyeHeight);
        addDependency("mobLookVectorColor", () -> showMobHitbox && showMobLookVector);

        // item
        addDependency("showItemOutline", () -> showItemHitbox);
        addDependency("dashedItemHitbox", () -> showItemHitbox);
        addDependency("showItemEyeHeight", () -> showItemHitbox);
        addDependency("showItemLookVector", () -> showItemHitbox);

        addDependency("itemOutlineColor", () -> showItemHitbox && showItemOutline);
        addDependency("itemEyeHeightColor", () -> showItemHitbox && showItemEyeHeight);
        addDependency("itemLookVectorColor", () -> showItemHitbox && showItemLookVector);

        // projectile (arrows, etc.)
        addDependency("showProjectileOutline", () -> showProjectileHitbox);
        addDependency("dashedProjectileHitbox", () -> showProjectileHitbox);
        addDependency("showProjectileEyeHeight", () -> showProjectileHitbox);
        addDependency("showProjectileLookVector", () -> showProjectileHitbox);

        addDependency("projectileOutlineColor", () -> showProjectileHitbox && showProjectileOutline);
        addDependency("projectileEyeHeightColor", () -> showProjectileHitbox && showProjectileEyeHeight);
        addDependency("projectileLookVectorColor", () -> showProjectileHitbox && showProjectileLookVector);

        // xp orb
        addDependency("showXPOrbOutline", () -> showXPOrbHitbox);
        addDependency("dashedXPOrbHitbox", () -> showXPOrbHitbox);
        addDependency("showXPOrbEyeHeight", () -> showXPOrbHitbox);
        addDependency("showXPOrbLookVector", () -> showXPOrbHitbox);

        addDependency("xpOrbOutlineColor", () -> showXPOrbHitbox && showXPOrbOutline);
        addDependency("xpOrbEyeHeightColor", () -> showXPOrbHitbox && showXPOrbEyeHeight);
        addDependency("xpOrbLookVectorColor", () -> showXPOrbHitbox && showXPOrbLookVector);
    }

    /**
     * Used to get the options in the form of an array.
     *
     * @param entityIn - The entity that will be given a very special hitbox.
     */
    public boolean[] getEntityBooleanOptions(Entity entityIn) {

        if (entityIn instanceof AbstractClientPlayer) {
            return new boolean[]{ showPlayerOutline, showPlayerEyeHeight, showPlayerLookVector };
        } else if (entityIn instanceof EntityItem) {
            return new boolean[]{ showPlayerOutline, showPlayerEyeHeight, showPlayerLookVector };
        } else if (entityIn instanceof EntityThrowable) {
            return new boolean[]{ showProjectileOutline, showProjectileEyeHeight, showProjectileLookVector };
        } else if (entityIn instanceof EntityXPOrb) {
            return new boolean[]{ showXPOrbOutline, showXPOrbEyeHeight, showXPOrbLookVector };
        }

        return new boolean[]{ showMobOutline, showMobEyeHeight, showMobLookVector };
    }

}

