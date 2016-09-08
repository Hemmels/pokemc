package uk.pokemc.pokemon.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.bulbasaur.ModelBulbasaur;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class RenderBulbasaur extends RenderLiving<EntityBulbasaur> {

  public static final ResourceLocation BULBASAUR_TEXTURES = new ResourceLocation(
      PokemcMod.MODID + ":textures/entity/bulbasaur.png");
  public static final ModelResourceLocation BULBASAUR_MODEL = new ModelResourceLocation(
		  PokemcMod.MODID + ":models/entity/bulbasaur.json");

  public RenderBulbasaur(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
    super(renderManagerIn, modelBaseIn, shadowSizeIn);
  }

  public RenderBulbasaur(RenderManager renderManagerIn) {
    super(renderManagerIn, new ModelBulbasaur(), 1f);
  }

  /**
   * Returns the location of an entity's texture. Doesn't seem to be called unless you call
   * Render.bindEntityTexture.
   */
  @Override
  protected ResourceLocation getEntityTexture(EntityBulbasaur entity) {
    // TODO Auto-generated method stub
    return BULBASAUR_TEXTURES;
  }

}
