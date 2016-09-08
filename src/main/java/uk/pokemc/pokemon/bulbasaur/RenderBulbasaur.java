package uk.pokemc.pokemon.bulbasaur;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class RenderBulbasaur extends RenderLiving<EntityBulbasaur> {

	public static final ResourceLocation BULBASAUR_TEXTURES = new ResourceLocation(PokemcMod.MODID + ":textures/entity/bulbasaur.png");

	public RenderBulbasaur(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
		super(renderManagerIn, modelBaseIn, shadowSizeIn);
	}

	public RenderBulbasaur(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelBulbasaur(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBulbasaur entity) {
		// TODO Auto-generated method stub
		return BULBASAUR_TEXTURES;
	}
}
