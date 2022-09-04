package gq.noxiuam.hitboxes.config;

import cc.polyfrost.oneconfig.config.annotations.Checkbox;
import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.core.OneColor;
import gq.noxiuam.hitboxes.HitBoxes;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class HitBoxesConfig extends cc.polyfrost.oneconfig.config.Config {

    // player
    @Switch(
            name = "Player Hitbox",
            subcategory = "Player Hitbox Options"
    )
    public static boolean showPlayerHitbox = true;

    @Color(
            name = "Player Hitbox Color",
            subcategory = "Player Hitbox Options"
    )
    public static OneColor playerHitBoxColor = new OneColor(-1);

    @Checkbox(
            name = "Dashed",
            subcategory = "Player Hitbox Options",
            size = 2
    )
    public static boolean dashedPlayerHitbox = false;

    @Switch(
            name = "Player Hitbox Outline",
            subcategory = "Player Hitbox Options"
    )
    public static boolean showPlayerOutline = true;

    @Color(
            name = "Player Hitbox Outline Color",
            subcategory = "Player Hitbox Options"
    )
    public static OneColor playerOutlineColor = new OneColor(-1);

    @Switch(
            name = "Player Eye Height",
            subcategory = "Player Hitbox Options"
    )
    public static boolean showPlayerEyeHeight = true;

    @Color(
            name = "Player Eye Height Color",
            subcategory = "Player Hitbox Options"
    )
    public static OneColor playerEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(
            name = "Player Look Vector",
            subcategory = "Player Hitbox Options"
    )
    public static boolean showPlayerLookVector = true;

    @Color(
            name = "Player Look Vector Color",
            subcategory = "Player Hitbox Options"
    )
    public static OneColor playerLookVectorColor = new OneColor(0xFF0000FF);

    // mob
    @Switch(
            name = "Mob Hitbox",
            subcategory = "Mob Hitbox Options"
    )
    public static boolean showMobHitbox = true;

    @Color(
            name = "Mob Hitbox Color",
            subcategory = "Mob Hitbox Options"
    )
    public static OneColor mobHitBoxColor = new OneColor(-1);

    @Checkbox(
            name = "Dashed",
            subcategory = "Mob Hitbox Options",
            size = 2
    )
    public static boolean dashedMobHitbox = false;

    @Switch(
            name = "Mob Hitbox Outline",
            subcategory = "Mob Hitbox Options"
    )
    public static boolean showMobOutline = true;

    @Color(
            name = "Mob Outline Color",
            subcategory = "Mob Hitbox Options"
    )
    public static OneColor mobOutlineColor = new OneColor(-1);

    @Switch(
            name = "Mob Eye Height",
            subcategory = "Mob Hitbox Options"
    )
    public static boolean showMobEyeHeight = true;

    @Color(
            name = "Mob Eye Height Color",
            subcategory = "Mob Hitbox Options"
    )
    public static OneColor mobEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(
            name = "Mob Look Vector",
            subcategory = "Mob Hitbox Options"
    )
    public static boolean showMobLookVector = true;

    @Color(
            name = "Mob Look Vector Color",
            subcategory = "Mob Hitbox Options"
    )
    public static OneColor mobLookVectorColor = new OneColor(0xFF0000FF);

    // item
    @Switch(
            name = "Item Hitbox",
            subcategory = "Item Hitbox Options"
    )
    public static boolean showItemHitbox = true;

    @Color(
            name = "Item Hitbox Color",
            subcategory = "Item Hitbox Options"
    )
    public static OneColor itemHitBoxColor = new OneColor(-1);
    
    @Checkbox(
            name = "Dashed",
            subcategory = "Item Hitbox Options",
            size = 2
    )
    public static boolean dashedItemHitbox = false;
    
    @Switch(
            name = "Item Hitbox Outline",
            subcategory = "Item Hitbox Options"
    )
    public static boolean showItemOutline = true;

    @Color(
            name = "Item Outline Color",
            subcategory = "Item Hitbox Options"
    )
    public static OneColor itemOutlineColor = new OneColor(-1);

    @Switch(
            name = "Item Eye Height",
            subcategory = "Item Hitbox Options"
    )
    public static boolean showItemEyeHeight = true;

    @Color(
            name = "Item Eye Height Color",
            subcategory = "Item Hitbox Options"
    )
    public static OneColor itemEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(
            name = "Item Look Vector",
            subcategory = "Item Hitbox Options"
    )
    public static boolean showItemLookVector = true;

    @Color(
            name = "Item Look Vector Color",
            subcategory = "Item Hitbox Options"
    )
    public static OneColor itemLookVectorColor = new OneColor(0xFF0000FF);

    // projectiles
    @Switch(
            name = "Projectile Hitbox",
            subcategory = "Projectile Hitbox Options"
    )
    public static boolean showProjectileHitbox = true;

    @Color(
            name = "Projectile Hitbox Color",
            subcategory = "Projectile Hitbox Options"
    )
    public static OneColor projectileHitBoxColor = new OneColor(-1);

    @Checkbox(
            name = "Dashed",
            subcategory = "Projectile Hitbox Options",
            size = 2
    )
    public static boolean dashedProjectileHitbox = false;
    
    @Switch(
            name = "Projectile Hitbox Outline",
            subcategory = "Projectile Hitbox Options"
    )
    public static boolean showProjectileOutline = true;

    @Color(
            name = "Projectile Outline Color",
            subcategory = "Projectile Hitbox Options"
    )
    public static OneColor projectileOutlineColor = new OneColor(-1);

    @Switch(
            name = "Projectile Eye Height",
            subcategory = "Projectile Hitbox Options"
    )
    public static boolean showProjectileEyeHeight = true;

    @Color(
            name = "Projectile Eye Height Color",
            subcategory = "Projectile Hitbox Options"
    )
    public static OneColor projectileEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(
            name = "Projectile Look Vector",
            subcategory = "Projectile Hitbox Options"
    )
    public static boolean showProjectileLookVector = true;

    @Color(
            name = "Projectile Look Vector Color",
            subcategory = "Projectile Hitbox Options"
    )
    public static OneColor projectileLookVectorColor = new OneColor(0xFF0000FF);

    // xp orb
    @Switch(
            name = "XP Orb Hitbox",
            subcategory = "XP Orb Hitbox Options"
    )
    public static boolean showXPOrbHitbox = true;

    @Color(
            name = "XP Orb Hitbox Color",
            subcategory = "XP Orb Hitbox Options"
    )
    public static OneColor xpOrbHitBoxColor = new OneColor(-1);

    @Checkbox(
            name = "Dashed",
            subcategory = "XP Orb Hitbox Options",
            size = 2
    )
    public static boolean dashedXPOrbHitbox = false;

    @Switch(
            name = "XP Orb Hitbox Outline",
            subcategory = "XP Orb Hitbox Options"
    )
    public static boolean showXPOrbOutline = true;

    @Color(
            name = "XP Orb Outline Color",
            subcategory = "XP Orb Hitbox Options"
    )
    public static OneColor xpOrbOutlineColor = new OneColor(-1);

    @Switch(
            name = "XP Orb Eye Height",
            subcategory = "XP Orb Hitbox Options"
    )
    public static boolean showXPOrbEyeHeight = true;

    @Color(
            name = "XP Orb Eye Height Color",
            subcategory = "XP Orb Hitbox Options"
    )
    public static OneColor xpOrbEyeHeightColor = new OneColor(0xFFFF0000);

    @Switch(
            name = "XP Orb Look Vector",
            subcategory = "XP Orb Hitbox Options"
    )
    public static boolean showXPOrbLookVector = true;

    @Color(
            name = "XP Orb Look Vector Color",
            subcategory = "XP Orb Hitbox Options"
    )
    public static OneColor xpOrbLookVectorColor = new OneColor(0xFF0000FF);

    public HitBoxesConfig() {
        super(new Mod(HitBoxes.NAME, ModType.UTIL_QOL), HitBoxes.MODID + ".json");
        initialize();
        // player
        addDependency("showPlayerOutline", () -> showPlayerHitbox);
        addDependency("dashedPlayerHitbox", () -> showPlayerHitbox);
        addDependency("showPlayerEyeHeight", () -> showPlayerHitbox);
        addDependency("showPlayerLookVector", () -> showPlayerHitbox);

        addDependency("playerHitBoxColor", () -> showPlayerHitbox);
        addDependency("playerOutlineColor", () -> showPlayerHitbox && showPlayerOutline);
        addDependency("playerEyeHeightColor", () -> showPlayerHitbox && showPlayerEyeHeight);
        addDependency("playerLookVectorColor", () -> showPlayerHitbox && showPlayerLookVector);

        // mob
        addDependency("showMobOutline", () -> showMobHitbox);
        addDependency("dashedMobHitbox", () -> showMobHitbox);
        addDependency("showMobEyeHeight", () -> showMobHitbox);
        addDependency("showMobLookVector", () -> showMobHitbox);

        addDependency("mobHitBoxColor", () -> showMobHitbox);
        addDependency("mobOutlineColor", () -> showMobHitbox && showMobOutline);
        addDependency("mobEyeHeightColor", () -> showMobHitbox && showMobEyeHeight);
        addDependency("mobLookVectorColor", () -> showMobHitbox && showMobLookVector);

        // item
        addDependency("showItemOutline", () -> showItemHitbox);
        addDependency("dashedItemHitbox", () -> showItemHitbox);
        addDependency("showItemEyeHeight", () -> showItemHitbox);
        addDependency("showItemLookVector", () -> showItemHitbox);

        addDependency("itemHitBoxColor", () -> showItemHitbox);
        addDependency("itemOutlineColor", () -> showItemHitbox && showItemOutline);
        addDependency("itemEyeHeightColor", () -> showItemHitbox && showItemEyeHeight);
        addDependency("itemLookVectorColor", () -> showItemHitbox && showItemLookVector);

        // projectile (arrows, etc.)
        addDependency("showProjectileOutline", () -> showProjectileHitbox);
        addDependency("dashedProjectileHitbox", () -> showProjectileHitbox);
        addDependency("showProjectileEyeHeight", () -> showProjectileHitbox);
        addDependency("showProjectileLookVector", () -> showProjectileHitbox);

        addDependency("projectileHitBoxColor", () -> showProjectileHitbox);
        addDependency("projectileOutlineColor", () -> showProjectileHitbox && showProjectileOutline);
        addDependency("projectileEyeHeightColor", () -> showProjectileHitbox && showProjectileEyeHeight);
        addDependency("projectileLookVectorColor", () -> showProjectileHitbox && showProjectileLookVector);

        // xp orb
        addDependency("showXPOrbOutline", () -> showXPOrbHitbox);
        addDependency("dashedXPOrbHitbox", () -> showXPOrbHitbox);
        addDependency("showXPOrbEyeHeight", () -> showXPOrbHitbox);
        addDependency("showXPOrbLookVector", () -> showXPOrbHitbox);

        addDependency("xpOrbHitBoxColor", () -> showXPOrbHitbox);
        addDependency("xpOrbOutlineColor", () -> showXPOrbHitbox && showXPOrbOutline);
        addDependency("xpOrbEyeHeightColor", () -> showXPOrbHitbox && showXPOrbEyeHeight);
        addDependency("xpOrbLookVectorColor", () -> showXPOrbHitbox && showXPOrbLookVector);
    }
}

