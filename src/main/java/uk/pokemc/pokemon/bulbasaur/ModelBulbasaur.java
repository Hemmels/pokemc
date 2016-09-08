package uk.pokemc.pokemon.bulbasaur;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBulbasaur extends ModelBase{

    public ModelRenderer head;
    public ModelRenderer main_body;
    public ModelRenderer left_front_leg;
    public ModelRenderer right_front_leg;
    public ModelRenderer left_back_leg;
    public ModelRenderer right_back_leg;
    public ModelRenderer bulb_1;
    public ModelRenderer bulb_2;
    public ModelRenderer bulb_3;
    public ModelRenderer bulb_tip;

/**
 * So now we have the correct shape, just need to work out how to do the texture and animations. 
 */
    
    public ModelBulbasaur(){
        this.main_body = new ModelRenderer(this, 20, 0);
        this.main_body.addBox(-2F, 19.0F, -3F, 4, 3, 6);
        

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-1F, 18F, -5F, 2, 2, 3);
        
        this.left_front_leg = new ModelRenderer(this, 15, 0);
        this.left_front_leg.addBox(-1.75F, 22F, -2.75F, 1, 2, 1);
        
        this.right_front_leg = new ModelRenderer(this, 15, 0);
        this.right_front_leg.addBox(0.75F, 22F, -2.75F, 1, 2, 1);
        
        this.left_back_leg = new ModelRenderer(this, 15, 0);
        this.left_back_leg.addBox(-1.75F, 22F, 1.75F, 1, 2, 1);
        
        this.right_back_leg = new ModelRenderer(this, 15, 0);
        this.right_back_leg.addBox(0.75F, 22F, 1.75F, 1, 2, 1);
        
        this.bulb_1 = new ModelRenderer(this, 0, 85);
        this.bulb_1.addBox(-1.5F,18.5F,-1.5F, 3, 1, 3);
        
        this.bulb_2 = new ModelRenderer(this, 0, 85);
        this.bulb_2.addBox(-2.5F,16.5F,-2.5F, 5, 2, 5);

        this.bulb_3 = new ModelRenderer(this, 0, 85);
        this.bulb_3.addBox(-1.5F,15.5F,-1.5F, 3, 1, 3);
        
        this.bulb_tip = new ModelRenderer(this, 0, 85);
        this.bulb_tip.addBox(-0.5F,14.5F,-0.5F, 1, 1, 1);

    }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    main_body.render(f5);
	    head.render(f5);
	    left_back_leg.render(f5);
	    left_front_leg.render(f5);
	    right_back_leg.render(f5);
	    right_front_leg.render(f5);
	    bulb_1.render(f5);
	    bulb_2.render(f5);
	    bulb_3.render(f5);
	    bulb_tip.render(f5);
	}
    
    
}
