package emt.gthandler.common.loader;

import static emt.command.CommandOutputs.mkbook;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import emt.tile.GT_MetaTileEntity_ResearchCompleter;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import thaumcraft.common.config.ConfigItems;

public class EMT_GT_Loader implements Runnable {

    public static int aIDoffset = 13000 - GT_Values.VN.length - 1;
    public static ItemStack ResearchMultiblock;

    @Override
    public void run() {
        ResearchMultiblock = new GT_MetaTileEntity_ResearchCompleter(
                aIDoffset + GT_Values.VN.length + 2,
                "Research Completer",
                "Research Completer").getStackForm(1L);
    }

    public void runlate() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.book),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 1L),
                        new ItemStack(ConfigItems.itemShard, 1, OreDictionary.WILDCARD_VALUE))
                .itemOutputs(mkbook()).duration(6 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
    }
}
