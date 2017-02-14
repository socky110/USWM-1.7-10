package uswm;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class LightSaber2 extends Item{
	private IIcon icon;
	public LightSaber2(){
	     this.setMaxDamage(0);
	     this.setCreativeTab(uswm.tab1);
	     ItemBow p;
	}
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
	    return 3600;
	}
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.block;
    }
    @SideOnly(Side.CLIENT)
    protected String getIconString()
    {
		return "uswm:gls";
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iicon)
    {
            this.icon = iicon.registerIcon("uswm:gls");
    }
}