package ganymedes01.ganyssurface.blocks;

import ganymedes01.ganyssurface.GanysSurface;
import ganymedes01.ganyssurface.core.utils.Utils;
import ganymedes01.ganyssurface.lib.Reference;
import ganymedes01.ganyssurface.lib.Strings;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Gany's Surface
 * 
 * @author ganymedes01
 * 
 */

public class ChocolateCakeBlock extends BlockCake {

	@SideOnly(Side.CLIENT)
	private IIcon cakeTopIcon, cakeBottomIcon, cakeInner;

	public ChocolateCakeBlock() {
		super();
		disableStats();
		setHardness(0.5F);
		setStepSound(soundTypeCloth);
		if (GanysSurface.enableChocolate)
			setCreativeTab(GanysSurface.surfaceTab);
		setBlockName(Utils.getUnlocalizedName(Strings.CHOCOLATE_CAKE_NAME));
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		eatCakeSlice(world, x, y, z, player);
		return true;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		eatCakeSlice(world, x, y, z, player);
	}

	private void eatCakeSlice(World world, int x, int y, int z, EntityPlayer player) {
		if (player.canEat(false)) {
			player.getFoodStats().addStats(2, 0.6F);
			int l = world.getBlockMetadata(x, y, z) + 1;

			if (l >= 6)
				world.setBlockToAir(x, y, z);
			else
				world.setBlockMetadataWithNotify(x, y, z, l, 2);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getItemIconName() {
		return Reference.ITEM_BLOCK_TEXTURE_PATH + Strings.CHOCOLATE_CAKE_NAME;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.chocolateCake);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? cakeTopIcon : side == 0 ? cakeBottomIcon : meta > 0 && side == 4 ? cakeInner : blockIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		blockIcon = reg.registerIcon(Utils.getBlockTexture(Strings.CHOCOLATE_CAKE_NAME) + "_side");
		cakeInner = reg.registerIcon(Utils.getBlockTexture(Strings.CHOCOLATE_CAKE_NAME) + "_inner");
		cakeTopIcon = reg.registerIcon(Utils.getBlockTexture(Strings.CHOCOLATE_CAKE_NAME) + "_top");
		cakeBottomIcon = reg.registerIcon(Utils.getBlockTexture(Strings.CHOCOLATE_CAKE_NAME) + "_bottom");
	}
}