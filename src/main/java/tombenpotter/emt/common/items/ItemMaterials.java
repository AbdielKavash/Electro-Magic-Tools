package tombenpotter.emt.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.common.config.Config;
import thaumcraft.common.lib.utils.InventoryUtils;
import tombenpotter.emt.ElectroMagicTools;
import tombenpotter.emt.ModInformation;

import java.util.List;

public class ItemMaterials extends Item {

    public IIcon[] icon = new IIcon[25];

    public ItemMaterials() {
        this.setCreativeTab(ElectroMagicTools.tabEMT);
        this.setMaxDamage(0);
        this.setMaxStackSize(64);
        setHasSubtypes(true);
        OreDictionary.registerOre("plateThaumium", new ItemStack(this, 1, 5));
        OreDictionary.registerOre("slimeball", new ItemStack(this, 1, 8));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = null;
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "oreClusterUranium";
                break;
            }
            case 1: {
                name = "crushedOreAmber";
                break;
            }
            case 2: {
                name = "purifiedOreAmber";
                break;
            }
            case 3: {
                name = "crushedOreCinnabar";
                break;
            }
            case 4: {
                name = "purifiedOreCinnabar";
                break;
            }
            case 5: {
                name = "thaumiumPlate";
                break;
            }
            case 6: {
                name = "lightningSummoner";
                break;
            }
            case 7: {
                name = "featherMesh";
                break;
            }
            case 8: {
                name = "glue";
                break;
            }
            case 9: {
                name = "ductTape";
                break;
            }
            case 10: {
                name = "rubberBall";
                break;
            }
            case 11: {
                name = "cardboard";
                break;
            }
            case 12: {
                name = "featherGluedCardboardWing";
                break;
            }
            //case 13: {
            //    name = "denseIronSheet";
            //    break;
            //}
            case 13: {
                name = "taintedFeather";
                break;
            }
            case 14: {
                name = "thaumiumWing";
                break;
            }
            case 15: {
                name = "uumatterDrop";
                break;
            }
            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri) {
        this.icon[0] = ri.registerIcon(ModInformation.texturePath + ":materials/clusteruranium");
        this.icon[1] = ri.registerIcon(ModInformation.texturePath + ":materials/crushedamber");
        this.icon[2] = ri.registerIcon(ModInformation.texturePath + ":materials/purifiedamber");
        this.icon[3] = ri.registerIcon(ModInformation.texturePath + ":materials/crushedcinnabar");
        this.icon[4] = ri.registerIcon(ModInformation.texturePath + ":materials/purifiedcinnabar");
        this.icon[5] = ri.registerIcon(ModInformation.texturePath + ":materials/thaumiumplate");
        this.icon[6] = ri.registerIcon(ModInformation.texturePath + ":materials/lightningsummoner");
        this.icon[7] = ri.registerIcon(ModInformation.texturePath + ":materials/feathermesh");
        this.icon[8] = ri.registerIcon(ModInformation.texturePath + ":materials/glue");
        this.icon[9] = ri.registerIcon(ModInformation.texturePath + ":materials/ducttape");
        this.icon[10] = ri.registerIcon(ModInformation.texturePath + ":materials/rubberball");
        this.icon[11] = ri.registerIcon(ModInformation.texturePath + ":materials/cardboard");
        this.icon[12] = ri.registerIcon(ModInformation.texturePath + ":materials/cardboardsheet");
        //this.icon[13] = ri.registerIcon(ModInformation.texturePath + ":materials/denseironsheet");
        this.icon[13] = ri.registerIcon(ModInformation.texturePath + ":materials/taintedfeather");
        this.icon[14] = ri.registerIcon(ModInformation.texturePath + ":materials/thaumiumWing");
        this.icon[15] = ri.registerIcon(ModInformation.texturePath + ":materials/uumatterdrop");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 1; i <= 15; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (stack != null && stack.getItemDamage() == 6) {
            player.swingItem();
            float f = 1.0F;
            float f1 = player.prevRotationPitch + ((player.rotationPitch - player.prevRotationPitch) * f);
            float f2 = player.prevRotationYaw + ((player.rotationYaw - player.prevRotationYaw) * f);
            double d = player.prevPosX + ((player.posX - player.prevPosX) * f);
            double d1 = (player.prevPosY + ((player.posY - player.prevPosY) * f) + 1.6200000000000001D) - player.yOffset;
            double d2 = player.prevPosZ + ((player.posZ - player.prevPosZ) * f);
            Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
            float f3 = MathHelper.cos((-f2 * 0.01745329F) - 3.141593F);
            float f4 = MathHelper.sin((-f2 * 0.01745329F) - 3.141593F);
            float f5 = -MathHelper.cos(-f1 * 0.01745329F);
            float f6 = MathHelper.sin(-f1 * 0.01745329F);
            float f7 = f4 * f5;
            float f8 = f6;
            float f9 = f3 * f5;
            double d3 = 5000D;
            Vec3 vec3d1 = vec3d.addVector(f7 * d3, f8 * d3, f9 * d3);
            MovingObjectPosition movingobjectposition = player.worldObj.rayTraceBlocks(vec3d, vec3d1, true);
            if (movingobjectposition == null) {
                return stack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK) {
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;
                world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
            } else if (movingobjectposition.typeOfHit == MovingObjectType.ENTITY) {
                Entity entityhit = movingobjectposition.entityHit;
                double x = entityhit.posX;
                double y = entityhit.posY;
                double z = entityhit.posZ;
                world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
            }
            if (player.capabilities.isCreativeMode) {
                return stack;
            } else {
                player.inventory.consumeInventoryItem(this);
                return stack;
            }
        }
        return stack;
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        if ((!entity.worldObj.isRemote) && ((stack.getItemDamage() == 13)) && ((entity instanceof EntityLivingBase)) && (!((EntityLivingBase) entity).isEntityUndead()) && (!((EntityLivingBase) entity).isPotionActive(Config.potionTaintPoisonID)) && (world.rand.nextInt(4321) <= stack.stackSize)) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Config.potionTaintPoisonID, 120, 0, false));
            if ((entity instanceof EntityPlayer)) {
                InventoryUtils.consumeInventoryItem((EntityPlayer) entity, stack.getItem(), stack.getItemDamage());
            }
        }
    }
}
