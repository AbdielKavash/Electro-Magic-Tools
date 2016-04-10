package emt.item.armor.boots;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import emt.ModInformation;
import emt.util.EMTConfigHandler;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemNanoBootsTraveller extends ItemElectricBootsTraveller {

	public ItemNanoBootsTraveller(int par3, int par4) {
		super(par3, par4);
		maxCharge = 1000000;
		speedBonus = (float) EMTConfigHandler.nanoBootsSpeed;
		jumpBonus = (float) EMTConfigHandler.nanoBootsJump;
		visDiscount = 4;
		transferLimit = 1000;
		energyPerDamage = 500;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(ModInformation.TEXTURE_PATH + ":armor/boots_nano");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return ModInformation.TEXTURE_PATH + ":textures/models/nanobootstravel.png";
	}
}