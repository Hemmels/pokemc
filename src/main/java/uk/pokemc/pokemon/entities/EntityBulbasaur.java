package uk.pokemc.pokemon.entities;

import java.util.Calendar;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import uk.pokemc.pokemon.EntityPokemon;
import uk.pokemc.runtime.PokemcMod;

public class EntityBulbasaur extends EntityPokemon {
  // No shorts used in Forge/MC - Use Integer instead
  
  public static final short POKEID = 1;

  public EntityBulbasaur(World worldIn) {
    super(worldIn);
    this.setCustomNameTag("Bulbasaur");
    this.setCanPickUpLoot(false);
    this.setHealth(10);
    // TODO: Reserve and use IDs 1000+ for each pokemon?
    this.setSize(0.5F, 0.5F);
    this.dataManager.register(TYPE, Byte.valueOf((byte) (1)));
  }

  /**
   * Returns the volume for the sounds this mob makes.
   */
  @Override
  protected float getSoundVolume() {
    return 0.1F;
  }

  /**
   * Gets the pitch of living sounds in living entities.
   */
  @Override
  protected float getSoundPitch() {
    return super.getSoundPitch() * 0.75F;
  }

  @Override
  @Nullable
  protected SoundEvent getAmbientSound() {
    return SoundEvents.ENTITY_SHEEP_AMBIENT;
  }

  @Override
  protected SoundEvent getHurtSound() {
    return SoundEvents.ENTITY_SHEEP_HURT;
  }

  @Override
  protected SoundEvent getDeathSound() {
    return SoundEvents.ENTITY_SHEEP_DEATH;
  }

  /**
   * Returns true if this entity should push and be pushed by other entities when colliding.
   */
  @Override
  public boolean canBePushed() {
    return true;
  }

  @Override
  protected void collideWithEntity(Entity entityIn) {
  }

  @Override
  protected void collideWithNearbyEntities() {
  }

  public Byte getPokemcType() {
    return this.dataManager.get(TYPE).byteValue();
  }

  /**
   * Used for elemental pokemon types? TODO: Work out pokemon types etc.
   * 
   * @param type
   */
  public void setPokemcType(byte type) {
    byte b0 = this.dataManager.get(TYPE).byteValue();
    this.dataManager.set(TYPE, Byte.valueOf((byte) (b0 | 1)));
  }

  /**
   * Called when the entity is attacked.
   */
  @Override
  public boolean attackEntityFrom(DamageSource source, float amount) {
    return isEntityInvulnerable(source);
  }

  /**
   * (abstract) Protected helper method to read subclass entity data from NBT.
   */
  @Override
  public void readEntityFromNBT(NBTTagCompound compound) {
    super.readEntityFromNBT(compound);
    this.dataManager.set(TYPE, Byte.valueOf(compound.getByte("PokemcFlags")));
  }

  /**
   * (abstract) Protected helper method to write subclass entity data to NBT.
   */
  @Override
  public void writeEntityToNBT(NBTTagCompound compound) {
    compound.setByte("PokemcFlags", this.dataManager.get(TYPE).byteValue());
  }

  /**
   * Checks if the entity's current position is a valid location to spawn this entity.
   */
  @Override
  public boolean getCanSpawnHere() {
    BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

    if (blockpos.getY() >= this.worldObj.getSeaLevel()) {
      return false;
    } 
    else {
      int lightLevel = this.worldObj.getLightFromNeighbors(blockpos);
      int spawnAtLight = 4;

      if (this.isDateAroundHalloween(this.worldObj.getCurrentDate())) {
        spawnAtLight = 7;
      } else if (this.rand.nextBoolean()) {
        return false;
      }

      return lightLevel > this.rand.nextInt(spawnAtLight) ? false : super.getCanSpawnHere();
    }
  }

  private boolean isDateAroundHalloween(Calendar p_175569_1_) {
    return p_175569_1_.get(2) + 1 == 10 && p_175569_1_.get(5) >= 20
        || p_175569_1_.get(2) + 1 == 11 && p_175569_1_.get(5) <= 3;
  }

  @Override
  public float getEyeHeight() {
    return this.height / 2.0F;
  }

  public static void registerFixesCow(DataFixer fixer) {
    EntityLiving.registerFixesMob(fixer, "Cow");
  }

  @Override
  protected void initEntityAI() {
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(3, new EntityAILookIdle(this));
  }

  @Override
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
        .setBaseValue(0.30000000298023224D);
  }

  @Override
  protected void playStepSound(BlockPos pos, Block blockIn) {
    this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
  }

  @Override
  @Nullable
  protected ResourceLocation getLootTable() {
    ResourceLocation loc = LootTableList
        .register(new ResourceLocation(PokemcMod.MODID, "entities/bulbasaur"));
    return loc;
  }

  @Override
  public void onEntityUpdate() {
    super.onEntityUpdate();
  }

  @Override
  public void onUpdate() {
    super.onUpdate();
  }

}