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
public class RenderSquirtle extends RenderLiving<EntitySquirtle> {

	public static final ResourceLocation SQUIRTLE_TEXTURES = new ResourceLocation(PokemcMod.MODID + ":textures/entity/squirtle.png");
	public static final ModelResourceLocation SQUIRTLE_MODEL = new ModelResourceLocation(PokemcMod.MODID + ":models/entity/squirtle.json");

	public RenderSquirtle(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
		super(renderManagerIn, modelBaseIn, shadowSizeIn);
	}

	public RenderSquirtle(RenderManager renderManagerIn) {
		super(renderManagerIn, BDCraftModelPokemon.SQUIRTLE, 0.4f);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntitySquirtle entity) {
		// TODO Auto-generated method stub
		return SQUIRTLE_TEXTURES;
	}

}
