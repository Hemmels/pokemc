package uk.pokemc.pokemon.charmander;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class RenderCharmander extends RenderLiving<EntityCharmander> {

	public static final ResourceLocation CHARMANDER_TEXTURES = new ResourceLocation(PokemcMod.MODID + ":textures/entity/charmander.png");

	public RenderCharmander(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn) {
		super(renderManagerIn, modelBaseIn, shadowSizeIn);
	}

	public RenderCharmander(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelCharmander(), 0.2f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCharmander entity) {
		// TODO Auto-generated method stub
		return CHARMANDER_TEXTURES;
	}
}
