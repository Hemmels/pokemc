package uk.pokemc.pokemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPikachu extends RenderLiving<EntityPikachu> {
	
    private static final ResourceLocation PIKACHU_TEXTURES = new ResourceLocation("textures/entity/pikachu.png");

    public RenderPikachu(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
    	super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(EntityPikachu entity) {
		// TODO Auto-generated method stub
		return PIKACHU_TEXTURES;
	}
    
}