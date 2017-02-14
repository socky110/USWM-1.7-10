package uswm;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMidgimon extends EntityAnimal{
	//protected static final DataParameter<Byte> TAMED = EntityDataManager.<Byte>createKey(EntityMidgimon.class, DataSerializers.BYTE);
	//private static final DataParameter<Boolean> SADDLED = EntityDataManager.<Boolean>createKey(EntityMidgimon.class, DataSerializers.BOOLEAN);
    //private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(new Item[] {Items.CARROT, Items.POTATO, Items.BEETROOT});
    public static EntityTameable tame;
    private boolean boosting;
    private int boostTime;
    private int totalBoostTime;
	public EntityMidgimon(World worldIn) {
		super(worldIn);
		
		//set size is the hitbox
		this.setSize(0.6F, 1.35F);
	}
	public double getYOffset()
    {
		//hitbox offset
        return 0D;
    }
	protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Items.cookie, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.5D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
	public boolean interact(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

        if (itemstack != null && this.isBreedingItem(itemstack) && this.getGrowingAge() == 0) //&& this.inLove <= 0)
        {
            if (!p_70085_1_.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;

                if (itemstack.stackSize <= 0)
                {
                    p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
                }
            }

            this.func_146082_f(p_70085_1_);
            return true;
        }
        else
        {
            return super.interact(p_70085_1_);
        }
    }
    protected void entityInit()
    {
        super.entityInit();
        //this.dataManager.register(SADDLED, Boolean.valueOf(true));
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        //compound.setBoolean("Saddle", this.getSaddled());
        //compound.setBoolean("Sitting", this.isSitting());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        //this.setSaddled(compound.getBoolean("Saddle"));
        //if (this.aiSit != null)
       // {
       //     this.aiSit.setSitting(compound.getBoolean("Sitting"));
       // }

        //this.setSitting(compound.getBoolean("Sitting"));
    }

    /**
     * Drop the equipment for this entity.
     */
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier)
    {
        super.dropEquipment(wasRecentlyHit, lootingModifier);

        //if (this.getSaddled())
        //{
            //this.dropItem(Items.SADDLE, 1);
        //}
    }

    /**
     * Set or remove the saddle of the pig.
     */
    public EntityMidgimon createChild(EntityAgeable ageable)
    {
        return new EntityMidgimon(this.worldObj);
    }
}
