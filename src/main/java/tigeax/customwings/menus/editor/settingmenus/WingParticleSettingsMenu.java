package tigeax.customwings.menus.editor.settingmenus;

import org.bukkit.Material;

import tigeax.customwings.configuration.settings.Setting;
import tigeax.customwings.configuration.settings.WingParticleSetting;
import tigeax.customwings.menus.editor.selectvaluemenus.items.SettingItem;
import tigeax.customwings.menus.items.GoBackItem;
import tigeax.customwings.util.menu.ItemMenu;
import tigeax.customwings.wing.WingParticle;

public class WingParticleSettingsMenu extends ItemMenu {

    private WingParticle wingParticle;

    public WingParticleSettingsMenu(WingParticle wingParticle) {
        super(wingParticle.getWingConfig().getGuiItemName() + " - " + wingParticle.getID(), Rows.SIX);
        this.wingParticle = wingParticle;

        setItem(13, new SettingItem(new Setting(WingParticleSetting.PARTICLE, wingParticle), "&3Particle", Material.DIAMOND_LEGGINGS));

        setItem(20, new SettingItem(new Setting(WingParticleSetting.DISTANCE, wingParticle), "&3Distance", Material.END_ROD));
        setItem(21, new SettingItem(new Setting(WingParticleSetting.HEIGHT, wingParticle), "&3Height", Material.END_ROD));
        setItem(23, new SettingItem(new Setting(WingParticleSetting.ANGLE, wingParticle), "&3Angle", Material.END_ROD));
        setItem(24, new SettingItem(new Setting(WingParticleSetting.SPEED, wingParticle), "&3Speed", Material.END_ROD));

        setItem(30, new SettingItem(new Setting(WingParticleSetting.COLOR, wingParticle), "&3Color", Material.PINK_WOOL));
        setItem(32, new SettingItem(new Setting(WingParticleSetting.NOTE_COLOR, wingParticle), "&3Note color", Material.JUKEBOX));

        setItem(40, new SettingItem(new Setting(WingParticleSetting.BLOCK_TYPE, wingParticle), "&3Block type"));

        setItem(53, new GoBackItem());
    }

    public WingParticle getWingParticle() {
        return wingParticle;
    }
    
}
