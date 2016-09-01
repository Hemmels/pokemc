package uk.pokemc.pokemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.pokemon.entities.EntityPikachu;
import uk.pokemc.runtime.PokemcMod;

@SideOnly(Side.CLIENT)
public class RenderPikachu extends RenderLiving<EntityPikachu> {
	
    public static final ResourceLocation PIKACHU_TEXTURES = new ResourceLocation(PokemcMod.MODID + ":textures/entity/pikachu.png");

    public RenderPikachu(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
    	super(renderManagerIn, modelBaseIn, shadowSizeIn);
    	System.out.println("Our renderer for RenderLiving<EntityPikachu> has been created");
    }
    public RenderPikachu(RenderManager renderManagerIn){
    	super(renderManagerIn, new ModelPikachu(), 2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(EntityPikachu entity) {
		// TODO Auto-generated method stub
		return PIKACHU_TEXTURES;
	}
	@Override
	protected boolean canRenderName(EntityPikachu p_canRenderName_1_) {
		// TODO Auto-generated method stub
		System.out.println("Name? : " + super.canRenderName(p_canRenderName_1_));
		return super.canRenderName(p_canRenderName_1_);
	}
	
}
