package uswm;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class LightSaber1 extends Item{
	private IIcon[] icon;
	//public static final String[] field_150923_a = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"};
	public static final String[] field_150921_b = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "light_blue", "magenta", "orange", "white"};  
	public LightSaber1(){
		 this.setHasSubtypes(true);
	     this.setMaxDamage(0);
	     this.setCreativeTab(uswm.tab1);
	}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        return stack;
    }
    //public String getUnlocalizedName(ItemStack stack)
    //{
    //    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 15);
     //   return super.getUnlocalizedName() + "." + icon[i];
    //}
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int i)
    {
        int j = MathHelper.clamp_int(i, 0, 15);
        return this.icon[j];
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        for (int i = 0; i < 16; ++i)
        {
        	list.add(new ItemStack(item, 1, i));
        }
    }
    @SideOnly(Side.CLIENT)
    protected String getIconString()
    {
    	int i = MathHelper.clamp_int(new ItemStack(this).getItemDamage(), 0, 15);
		return "uswm:lightsaber" + "_" + field_150921_b[i];
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iicon)
    {
        this.icon = new IIcon[field_150921_b.length];

        for (int i = 0; i < field_150921_b.length; ++i)
        {
            this.icon[i] = iicon.registerIcon("uswm:lightsaber" + "_" + field_150921_b[i]);
        }
    }
}
