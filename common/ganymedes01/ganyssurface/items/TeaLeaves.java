package ganymedes01.ganyssurface.items;

import ganymedes01.ganyssurface.GanysSurface;
import ganymedes01.ganyssurface.core.utils.Utils;
import ganymedes01.ganyssurface.lib.ModIDs;
import ganymedes01.ganyssurface.lib.Strings;
import net.minecraft.item.Item;

/**
 * Gany's Surface
 * 
 * @author ganymedes01
 * 
 */

public class TeaLeaves extends Item {

	public TeaLeaves() {
		super(ModIDs.TEA_LEAVES_ID);
		setCreativeTab(GanysSurface.surfaceTab);
		setTextureName(Utils.getItemTexture(Strings.TEA_LEAVES_NAME));
		setUnlocalizedName(Utils.getUnlocalizedName(Strings.TEA_LEAVES_NAME));
	}
}
