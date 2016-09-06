package uk.pokemc.pokemon;

import static net.minecraft.entity.SharedMonsterAttributes.ATTACK_DAMAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.base.Optional;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import uk.pokemc.pokemon.entities.EntityPikachu;

public class EntityPokemon extends EntityCreature {

  protected static final DataParameter<Byte> TAMED = EntityDataManager
      .<Byte>createKey(EntityTameable.class, DataSerializers.BYTE);
  public static DamageSource INTERPOKEMON = new DamageSource("interPokemon");

  protected static final DataParameter<Byte> TYPE = EntityDataManager
      .<Byte>createKey(EntityPokemon.class, DataSerializers.BYTE);
  private static final DataParameter<Boolean> DATA_FLYING = EntityDataManager
      .<Boolean>createKey(EntityPokemon.class, DataSerializers.BOOLEAN);
  protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager
      .<Optional<UUID>>createKey(EntityTameable.class, DataSerializers.OPTIONAL_UNIQUE_ID);
  // TODO: Can we keep "variant" of pokemon here?
  private static final DataParameter<Byte> ID = EntityDataManager
      .<Byte>createKey(EntityPikachu.class, DataSerializers.BYTE);

  public static final double BASE_SPEED_GROUND = 0.3;
  public static final double BASE_SPEED_AIR = 0.4;
  public static final double BASE_DAMAGE = 8;
  public static final double BASE_HEALTH = 60;
  public static final float BASE_WIDTH = 2.75f;
  public static final float BASE_HEIGHT = 2.75f;
  public static final double BASE_FOLLOW_RANGE = 16;
  public static final double BASE_FOLLOW_RANGE_FLYING = BASE_FOLLOW_RANGE * 2;
  public static final int HOME_RADIUS = 64;
  public static final double ALTITUDE_FLYING_THRESHOLD = 2;

  // server/client delegates
  private final Map<String, PokemonHelper> helpers = new HashMap<>();

  public EntityPokemon(World worldIn) {
    super(worldIn);
    // enables walking over blocks
    stepHeight = 1;

    // helpers.put(PokemonInteractHelper.class.getName(), new PokemonInteractHelper(this));

    // init helpers
    // helpers.values().forEach(PokemonHelper::applyEntityAttributes);
  }

  @Override
  // Pokemon can only be hurt by other pokemon
  public boolean isEntityInvulnerable(DamageSource source) {
    if (source == INTERPOKEMON) {
      return true;
    }
    return false;
  }

  @Override
  protected void applyEntityAttributes() {
    super.applyEntityAttributes();
    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
        .setBaseValue(0.30000001192092896D);
  }

  public boolean canFly() {
    return false;
  }

  /**
   * Returns true if the entity is flying.
   */
  public boolean isFlying() {
    return false;// dataManager.get(DATA_FLYING);
  }

  /**
   * Called when the mob is falling. Calculates and applies fall damage.
   */
  @Override
  public void fall(float distance, float damageMultiplier) {
    // ignore fall damage if the entity can fly
    if (!canFly()) {
      super.fall(distance, damageMultiplier);
    }
  }

  /**
   * (abstract) Protected helper method to write subclass entity data to NBT.
   */
  @Override
  public void writeEntityToNBT(NBTTagCompound nbt) {
    super.writeEntityToNBT(nbt);
    // nbt.setBoolean(NBT_SADDLED, isSaddled());

    helpers.values().forEach(helper -> helper.writeToNBT(nbt));
  }

  /**
   * (abstract) Protected helper method to read subclass entity data from NBT.
   */
  @Override
  public void readEntityFromNBT(NBTTagCompound nbt) {
    super.readEntityFromNBT(nbt);
    // setSaddled(nbt.getBoolean(NBT_SADDLED));

    helpers.values().forEach(helper -> helper.readFromNBT(nbt));
  }

  /**
   * Set the flying flag of the entity.
   */
  public void setFlying(boolean flying) {
    dataManager.set(DATA_FLYING, flying);
  }

  public boolean isTamed() {
    return false;
    // return (((Byte)this.dataManager.get(TAMED)).byteValue() & 4) != 0;
  }

  public void setTamed(boolean tamed) {
    byte b0 = this.dataManager.get(TAMED).byteValue();

    if (tamed) {
      this.dataManager.set(TAMED, Byte.valueOf((byte) (b0 | 4)));
    } else {
      this.dataManager.set(TAMED, Byte.valueOf((byte) (b0 & -5)));
    }

    // TODO: this.setupTamedAI();
  }

  /**
   * Returns the distance to the ground while the entity is flying.
   */
  public double getAltitude() {
    BlockPos groundPos = worldObj.getHeight(getPosition());
    return posY - groundPos.getY();
  }

  @Nullable
  public UUID getOwnerId() {
    return (UUID) (this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
  }

  public void setOwnerId(@Nullable UUID p_184754_1_) {
    this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(p_184754_1_));
  }

  @Nullable
  public EntityLivingBase getOwner() {
    try {
      UUID uuid = this.getOwnerId();
      return uuid == null ? null : this.worldObj.getPlayerEntityByUUID(uuid);
    } catch (IllegalArgumentException var2) {
      return null;
    }
  }

  public boolean isOwner(EntityLivingBase entityIn) {
    return entityIn == this.getOwner();
  }

  @Override
  public void moveEntityWithHeading(float strafe, float forward) {
    // disable method while flying, the movement is done entirely by
    // moveEntity() and this one just makes the dragon to fall slowly when
    // hovering
    if (!isFlying()) {
      super.moveEntityWithHeading(strafe, forward);
    }
  }

  /**
   * Handles entity death timer, experience orb and particle creation
   */
  @Override
  protected void onDeathUpdate() {
    helpers.values().forEach(PokemonHelper::onDeathUpdate);

    // unmount any riding entities
    removePassengers();

    // freeze at place
    motionX = motionY = motionZ = 0;
    rotationYaw = prevRotationYaw;
    rotationYawHead = prevRotationYawHead;

    if (deathTime >= getMaxDeathTime()) {
      setDead();
    }

    deathTime++;
  }

  @Override
  public void setDead() {
    helpers.values().forEach(PokemonHelper::onDeath);
    super.setDead();
  }

  @Override
  public String getName() {
    // return custom name if set
    if (hasCustomName()) {
      return getCustomNameTag();
    }

    // return default breed name otherwise
    String entName = EntityList.getEntityString(this);
    return "entity." + entName + ".name";
  }

  /**
   * Returns the volume for the sounds this mob makes.
   */
  @Override
  protected float getSoundVolume() {
    // note: unused, managed in playSound()
    return 1;
  }

  /**
   * Gets the pitch of living sounds in living entities.
   */
  @Override
  protected float getSoundPitch() {
    // note: unused, managed in playSound()
    return 1;
  }

  /**
   * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a
   * pig.
   */
  @Override
  public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack item) {
    // inherited interaction
    if (super.processInteract(player, hand, item)) {
      return true;
    }
    return false;
    // return getInteractHelper().interact(player, item);
  }

  public void tamedFor(EntityPlayer player, boolean successful) {
    if (successful) {
      setTamed(true);
      navigator.clearPathEntity(); // replacement for setPathToEntity(null);
      setAttackTarget(null);
      setOwnerId(player.getUniqueID());
      // playTameEffect(true);
      worldObj.setEntityState(this, (byte) 7);
    } else {
      // playTameEffect(false);
      worldObj.setEntityState(this, (byte) 6);
    }
  }

  public boolean isTamedFor(EntityPlayer player) {
    return isTamed() && isOwner(player);
  }

  /**
   * Drop 0-2 items of this living's type.
   * 
   * @param par1
   *          - Whether this entity has recently been hit by a player.
   * @param par2
   *          - Level of Looting used to kill this mob.
   */
  @Override
  protected void dropFewItems(boolean par1, int par2) {
    super.dropFewItems(par1, par2);
    // TODO: What should they drop?
    dropItem(Items.EXPERIENCE_BOTTLE, 1);
  }

  @Override
  public boolean attackEntityAsMob(Entity entityIn) {
    boolean attacked = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
        (float) getEntityAttribute(ATTACK_DAMAGE).getAttributeValue());

    if (attacked) {
      applyEnchantments(this, entityIn);
    }

    return attacked;
  }

  private <T extends PokemonHelper> T getHelper(Class<T> clazz) {
    return (T) helpers.get(clazz);
  }

  public PokemonInteractHelper getInteractHelper() {
    return getHelper(PokemonInteractHelper.class);
  }

  /**
   * For vehicles, the first passenger is generally considered the controller and "drives" the
   * vehicle. For example, Pigs, Horses, and Boats are generally "steered" by the controlling
   * passenger.
   */
  @Override
  public Entity getControllingPassenger() {
    List<Entity> list = getPassengers();
    return list.isEmpty() ? null : list.get(0);
  }

  @Override
  public boolean canPassengerSteer() {
    // must always return false or the vanilla movement code interferes
    // with PokemonMoveHelper
    return false;
  }

  public EntityPlayer getRidingPlayer() {
    Entity entity = getControllingPassenger();
    if (entity instanceof EntityPlayer) {
      return (EntityPlayer) entity;
    } else {
      return null;
    }
  }

  public void setRidingPlayer(EntityPlayer player) {
    player.rotationYaw = rotationYaw;
    player.rotationPitch = rotationPitch;
    player.startRiding(this);
  }

  // @Override
  // public void updateRiderPosition() {
  // if (riddenByEntity != null) {
  // double px = posX;
  // double py = posY + getMountedYOffset() + riddenByEntity.getYOffset();
  // double pz = posZ;
  //
  // // dragon position is the middle of the model and the saddle is on
  // // the shoulders, so move player forwards on Z axis relative to the
  // // dragon's rotation to fix that
  // Vec3 pos = new Vec3(0, 0, 0.8 * getScale());
  // pos = pos.rotateYaw((float) Math.toRadians(-renderYawOffset)); // oops
  // px += pos.xCoord;
  // py += pos.yCoord;
  // pz += pos.zCoord;
  //
  // riddenByEntity.setPosition(px, py, pz);
  //
  // // fix rider rotation
  // if (riddenByEntity instanceof EntityLiving) {
  // EntityLiving rider = ((EntityLiving) riddenByEntity);
  // rider.prevRotationPitch = rider.rotationPitch;
  // rider.prevRotationYaw = rider.rotationYaw;
  // rider.renderYawOffset = renderYawOffset;
  // }
  // }
  // }

  public boolean isInvulnerableTo(DamageSource src) {
    Entity srcEnt = src.getEntity();
    if (srcEnt != null) {
      // ignore own damage
      if (srcEnt == this) {
        return true;
      }

      // ignore damage from riders
      if (isPassenger(srcEnt)) {
        return true;
      }
    }

    // don't drown as egg
    if (src.damageType.equals("drown")) {
      return true;
    }

    return isEntityInvulnerable(src);
  }

  /**
   * Returns the entity's health relative to the maximum health.
   * 
   * @return health normalized between 0 and 1
   */
  public double getHealthRelative() {
    return getHealth() / (double) getMaxHealth();
  }

  public int getDeathTime() {
    return deathTime;
  }

  public int getMaxDeathTime() {
    return 120;
  }

  public void setImmuneToFire(boolean isImmuneToFire) {
    this.isImmuneToFire = isImmuneToFire;
  }

  public void setAttackDamage(double damage) {
    getEntityAttribute(ATTACK_DAMAGE).setBaseValue(damage);
  }

  /**
   * Public wrapper for protected final setScale(), used by PokemonLifeStageHelper.
   * 
   * @param scale
   */
  public void setScalePublic(float scale) {
    double posXTmp = posX;
    double posYTmp = posY;
    double posZTmp = posZ;
    boolean onGroundTmp = onGround;

    // workaround for a vanilla bug; the position is apparently not set correcty
    // after changing the entity size, causing asynchronous server/client positioning
    setPosition(posXTmp, posYTmp, posZTmp);

    // otherwise, setScale stops the dragon from landing while it is growing
    onGround = onGroundTmp;
  }

  @Override
  public boolean isChild() {
    return false;
  }

  /**
   * Checks if this entity is running on a client.
   * 
   * Required since MCP's isClientWorld returns the exact opposite...
   * 
   * @return true if the entity runs on a client or false if it runs on a server
   */
  public final boolean isClient() {
    return worldObj.isRemote;
  }

  /**
   * Checks if this entity is running on a server.
   * 
   * @return true if the entity runs on a server or false if it runs on a client
   */
  public final boolean isServer() {
    return !worldObj.isRemote;
  }

  @Override
  public IEntityLivingData onInitialSpawn(DifficultyInstance p_onInitialSpawn_1_,
      IEntityLivingData p_onInitialSpawn_2_) {
    // TODO Auto-generated method stub
    System.out.println(getEntityId() + " was added to the world! - it's a " + getName());
    return super.onInitialSpawn(p_onInitialSpawn_1_, p_onInitialSpawn_2_);
  }

}
