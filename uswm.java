package uswm;

import java.util.List;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@Mod(modid = uswm.MODID, version = uswm.VERSION, name = uswm.NAME)
public class uswm
{
    public static final String MODID = "uswm";
    public static final String VERSION = "1.0";
    public static final String NAME = "u (stands for something) Star Wars Mod";
    
    
    @SidedProxy(clientSide="uswm.client", serverSide="uswm.server")
    public static sharedproxy proxy;
    
   // public static SoundEvent sound1 = new SoundEvent(new ResourceLocation("throwablemobs", "BGwalk"));
    //public static SoundEvent sound2 = new SoundEvent(new ResourceLocation("throwablemobs", "bomb"));
    public static bls bluelightsaber;
    public static gls greenlightsaber;
    
    public static CreativeTabs tab1 = new CreativeTabs("tab1"){
		@Override
		public Item getTabIconItem() {
			return bluelightsaber;
		}
    };
    //public static ToolMaterial mat = EnumHelper.addToolMaterial("stickmat", 0, 100, 1, -1.5F, 30);
    public static void lsr(LightSaber ls, String unlocalname, String name){
    	GameRegistry.registerItem(ls, unlocalname);
    	LanguageRegistry.addName(ls, name);
    }

	private Item lightsaber;
    @EventHandler
    public void pre(FMLPreInitializationEvent e){
    	
    	bluelightsaber = new bls();
    	lsr(bluelightsaber, "bls", "Blue LightSaber");
    		//GameRegistry.registerItem(bluelightsaber, "bls");
        	//LanguageRegistry.addName(bluelightsaber, "Blue LightSaber");
        greenlightsaber = new gls();
        lsr(greenlightsaber, "gls", "Green LightSaber");
    		//GameRegistry.registerItem(greenlightsaber, "gls2");
        	//LanguageRegistry.addName(greenlightsaber, "Green LightSaber");
        	
    		//lsr(lightsaber4, lightsaber4.field_150921_b[4], 4);
        	//lightsaber4 = new LightSaber1();
        	//GameRegistry.registerItem(lightsaber4, "lightsaber" + "_" + lightsaber4.field_150921_b[4]);
        	//LanguageRegistry.addName(lightsaber4, lightsaber4.field_150921_b[4]);
        	//lightsaber4.getIconFromDamage(4);
    		//GameRegistry.registerItem(ls[], "lightsaber" + "_" + lightsaber.field_150921_b[i]);
    	 
    		//LanguageRegistry.addName(ls[i], lightsaber.field_150921_b[i] + " Lightsaber");
    	//GameRegistry.registerItem(lightsaber, new LightSaber().field_150921_b[lightsaber.getDamage(new ItemStack(lightsaber))]);
    	//itemzomb.setUnlocalizedName("itemzomb").setRegistryName(MODID, "itemzomb").setCreativeTab(tabs.tabMyMod).setMaxStackSize(24);
    	//GameRegistry.register(itemzomb.setRegistryName(midgimon.MODID, "itemzomb"));
    	//blockmidgiball = new BlockFurnace(false){}.setCreativeTab(null).setUnlocalizedName("furnace");
    	//GameRegistry.registerBlock(blockmidgiball, "furnace");
	EntityRegistry.registerModEntity(EntityLightSaber.class, "EntityLightSaber", 121, MODID, 64, 5, true);
    	//EntityRegistry.registerModEntity(EntityMidgiballB.class, "EntityMidgiballB", 123, MODID, 64, 5, true, 500, -60000);
    	
    	//GameRegistry.addShapelessRecipe(new ItemStack(betterball, 1), new Object[] {midgiball, Blocks.STONE_BUTTON});
    	//GameRegistry.addRecipe(new ItemStack(beatstick, 1), 
    	//		"|  ",
    	//		" | ", 
    	//		"  |", 
    	//		'|', Items.STICK);
    	//GameRegistry.addRecipe(new ItemStack(beatstick, 1), 
    	//		"  |",
    	//		" | ", 
    	//		"|  ", 
    	//		'|', Items.STICK);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e)
    {
    	MinecraftForgeClient.registerItemRenderer(bluelightsaber, new IItemRenderer(){
    		private ModelLightSaber model;
    		protected RenderManager renderManager;
    		public final ResourceLocation location = new ResourceLocation("uswm:textures/entity/lightsaber2.png");
			@Override
			public boolean handleRenderType(ItemStack item, ItemRenderType type) {
				switch(type)
				{
				case EQUIPPED: return true;
				case EQUIPPED_FIRST_PERSON: return true;
				default: return false;
				}
			}

			@Override
			public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
				return false;
			}

			@Override
			public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
				model = new ModelLightSaber();
				switch(type)
				{
				case EQUIPPED:
				{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(location);
				GL11.glRotatef(0, 0, 0, 0);
				GL11.glScalef(0.15F, 0.125F, 0.15F);
				GL11.glTranslatef(3, 4, 0);
				 
				 
				this.model.render(null, 1F, 1, 1, 1, 1, 1);
				 
				GL11.glPopMatrix();
				 
				 
				}
				case EQUIPPED_FIRST_PERSON:
				{
					GL11.glPushMatrix();
					Minecraft.getMinecraft().renderEngine.bindTexture(location);
					GL11.glRotatef(0, 0, 0, 0);
					GL11.glScalef(0.15F, 0.125F, 0.15F);
					GL11.glTranslatef(3, 4, 0);
					 
					 
					this.model.render(null, 1F, 1, 1, 1, 1, 1);
					 
					GL11.glPopMatrix();
					 
					 
					}
				default:
				break;
				}
			}
    		
    	});
    	RenderingRegistry.registerEntityRenderingHandler(EntityLightSaber.class, new RenderLightSaber(){

			@Override
			protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
				return new ResourceLocation("uswm:textures/entity/lightsaber2.png");
			}
    	}); 
    	//RenderingRegistry.registerEntityRenderingHandler(EntityMidgiball.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), Item.getItemFromBlock(blockmidgiball), Minecraft.getMinecraft().getRenderItem())); 
    	//GameRegistry.register(sound1.setRegistryName(new ResourceLocation("throwablemobs", "BGwalk")));
    	//GameRegistry.register(sound2.setRegistryName(new ResourceLocation("throwablemobs", "bomb")));
    	//MinecraftForge.EVENT_BUS.register(MobDropsHandler.class);
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(blockmidgiball), 0, new ModelResourceLocation(MODID + ":" + "furnace", "inventory"));
    	//Minecraft.getMinecraft().getSoundHandler().equals(sounds.class);
    	//Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(entitythrower.class).bindTexture(new ResourceLocation("weaponscraft", "textures/items/wheatthin.png"));
    	}
}
