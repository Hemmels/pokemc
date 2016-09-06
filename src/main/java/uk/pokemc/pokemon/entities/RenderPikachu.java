package uk.pokemc.pokemon.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class RenderPikachu extends RenderLiving<EntityPikachu> {

  public static final ResourceLocation PIKACHU_TEXTURES = new ResourceLocation(
      PokemcMod.MODID + ":textures/entity/pikachu.png");
  public static final ModelResourceLocation PIKACHU_MODEL = new ModelResourceLocation(
      PokemcMod.MODID + ":models/entity/pikachu.json");

  public RenderPikachu(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
    super(renderManagerIn, modelBaseIn, shadowSizeIn);
  }

  public RenderPikachu(RenderManager renderManagerIn) {
    super(renderManagerIn, PokemcModel.PIKACHU, 1f);
  }

  /**
   * Returns the location of an entity's texture. Doesn't seem to be called unless you call
   * Render.bindEntityTexture.
   */
  @Override
  protected ResourceLocation getEntityTexture(EntityPikachu entity) {
    // TODO Auto-generated method stub
    return PIKACHU_TEXTURES;
  }

}
