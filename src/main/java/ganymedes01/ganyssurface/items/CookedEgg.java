package ganymedes01.ganyssurface.items;

import ganymedes01.ganyssurface.GanysSurface;
import ganymedes01.ganyssurface.core.utils.Utils;
import ganymedes01.ganyssurface.lib.Strings;
import net.minecraft.item.ItemFood;

/**
 * Gany's Surface
 *
 * @author ganymedes01
 *
 */

public class CookedEgg extends ItemFood {

	public CookedEgg() {
		super(5, false);
		setMaxStackSize(16);
		setTextureName(Utils.getItemTexture(Strings.COOKED_EGG_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.COOKED_EGG_NAME));
		setCreativeTab(GanysSurface.enableCookedEgg ? GanysSurface.surfaceTab : null);
	}
}