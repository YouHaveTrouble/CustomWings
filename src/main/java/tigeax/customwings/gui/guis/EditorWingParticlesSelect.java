package tigeax.customwings.gui.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import tigeax.customwings.CWPlayer;
import tigeax.customwings.CustomWings;
import tigeax.customwings.configuration.Configuration;
import tigeax.customwings.gui.CWGUIManager;
import tigeax.customwings.gui.CWGUIType;
import tigeax.customwings.wings.Wing;
import tigeax.customwings.wings.WingParticle;

public class EditorWingParticlesSelect {
	
	CustomWings plugin;
	Configuration config;

	public EditorWingParticlesSelect() {
		plugin = CustomWings.getInstance();
		config = plugin.getConfig();
	}

	public void open(CWPlayer cwPlayer, Wing wing) {

		String guiName = config.getEditorGUIName() + " - Wing Particles";

		Inventory gui = Bukkit.createInventory(null, 54, guiName);

		gui.setItem(4, CWGUIManager.getItem(wing.getGuiItem().getType(), "&f" + wing.getID()));
		gui.setItem(53, CWGUIManager.getItem(Material.WHITE_BED, "&4Previous page"));

		int slot = 9;

		for (WingParticle wingParticle : wing.getWingParticles()) {
			gui.setItem(slot, CWGUIManager.getItem(wingParticle.getItemMaterial(), "&f" + wingParticle.getID()));
			slot++;
		}

		cwPlayer.getPlayer().openInventory(gui);
	}

	public void click(CWPlayer cwPlayer, String itemName, Wing wing) {

		if (itemName.equals("Previous page")) {
			cwPlayer.openCWGUI(CWGUIType.EDITORWINGSETTINGS, wing);
			return;
		}

		WingParticle wingParticle = wing.getWingParticleByID(itemName);
		cwPlayer.openCWGUI(CWGUIType.EDITORWINGPARTICLESETTINGS, wingParticle);
	}
	
}
