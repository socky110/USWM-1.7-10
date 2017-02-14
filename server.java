package uswm;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class server extends sharedproxy{
	@EventHandler
    public void pre(FMLPreInitializationEvent e){
		super.pre(e);
    }
	@EventHandler
    public void init(FMLInitializationEvent e){
		super.init(e);
    }
}