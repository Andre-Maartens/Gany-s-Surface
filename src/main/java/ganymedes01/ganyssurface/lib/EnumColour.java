package ganymedes01.ganyssurface.lib;

import java.awt.Color;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.StatCollector;

/**
 * Gany's Surface
 *
 * @author ganymedes01
 *
 */

public enum EnumColour {
	BLACK("Black"),
	RED("Red"),
	GREEN("Green"),
	BROWN("Brown"),
	BLUE("Blue"),
	PURPLE("Purple"),
	CYAN("Cyan"),
	LIGHT_GREY("LightGray"),
	GREY("Gray"),
	PINK("Pink"),
	LIME("Lime"),
	YELLOW("Yellow"),
	LIGHT_BLUE("LightBlue"),
	MAGENTA("Magenta"),
	ORANGE("Orange"),
	WHITE("White");

	final String dye;
	final String name;

	EnumColour(String name) {
		dye = "dye" + name;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getOreName() {
		return dye;
	}

	public Color getColour() {
		int i = BlockColored.func_150031_c(ordinal());
		return new Color(EntitySheep.fleeceColorTable[i][0], EntitySheep.fleeceColorTable[i][1], EntitySheep.fleeceColorTable[i][2]);
	}

	public int getRGB() {
		return getColour().getRGB();
	}

	public int getDarker() {
		return getColour().darker().getRGB();
	}

	public int getBrighter() {
		return getColour().brighter().getRGB();
	}

	public String getTranslatedName() {
		return StatCollector.translateToLocal("colour." + Reference.MOD_ID + "." + dye);
	}
}