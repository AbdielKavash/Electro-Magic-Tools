package tombenpotter.emt.common.items.tools.omnitools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.item.ElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;
import tombenpotter.emt.common.util.ConfigHandler;

public class ItemOmnitoolThaumium extends ItemOmnitoolDiamond {

	public ItemOmnitoolThaumium() {
		super();
		this.efficiencyOnProperMaterial = 21F;
		this.setCreativeTab(ElectroMagicTools.tabEMT);
		this.setMaxStackSize(1);
		if (!ConfigHandler.toolsInBore) {
			this.setMaxDamage(27);
		}
		else {
			this.setMaxDamage(467);
		}
		maxCharge = 140000;
		hitCost = 650;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ModInformation.texturePath + ":tools/omnitool_thaumium");
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int par4, int par5, int par6, EntityLivingBase entityLiving) {
		if (!ConfigHandler.toolsInBore) {
			cost = 300;
		}
		else {
			cost = 1;
		}
		ElectricItem.manager.use(stack, cost, entityLiving);
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
			entityliving.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) attacker), 10F);
		}
		return false;
	}

	/* IC2 API METHODS */
	@Override
	public double getTransferLimit(ItemStack itemStack) {
		return 800;
	}
}
