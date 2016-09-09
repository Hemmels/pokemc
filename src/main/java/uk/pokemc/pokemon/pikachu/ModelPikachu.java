package uk.pokemc.pokemon.pikachu;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPikachu extends ModelBase{

    public ModelRenderer head;
    public ModelRenderer main_body;
    public ModelRenderer tail_1;
    public ModelRenderer tail_2;
    public ModelRenderer tail_3;
    public ModelRenderer tail_4;
    public ModelRenderer left_leg;
    public ModelRenderer right_leg;
    public ModelRenderer left_arm;
    public ModelRenderer right_arm;
    public ModelRenderer left_ear;
    public ModelRenderer right_ear;

    public ModelPikachu(){
        this.main_body = new ModelRenderer(this, 10, 0);
        this.main_body.addBox(-1.5F, 16.0F, -1.5F, 3, 6, 3);
        

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-1F, 14F, -1F, 2, 2, 2);
        
//
//        // TODO: Where to start in the flat file?
        this.tail_1 = new ModelRenderer(this, 0, 15);
        this.tail_1.addBox(-0.5F, 21.0F, 1.5F, 1, 1, 2);
//        
        this.tail_2 = new ModelRenderer(this, 10, 15);
        this.tail_2.addBox(-0.5F, 20F, 2.5F, 1, 1, 2);
//        
        this.tail_3 = new ModelRenderer(this, 0, 6);
        this.tail_3.addBox(-0.5F, 18F, 3.5F, 1, 2, 3);
//                
        this.tail_4 = new ModelRenderer(this, 0, 6);
        this.tail_4.addBox(-0.5F, 16F, 5.5F, 1, 2, 3);
//        
        this.left_leg = new ModelRenderer(this, 0, 6);
        this.left_leg.addBox(-1.25F, 22.0F, -0.5F, 1, 1, 1);
//        
        this.right_leg = new ModelRenderer(this, 0, 6);
        this.right_leg.addBox(0.25F, 22.0F, -0.5F, 1, 1, 1);
        
        this.left_arm = new ModelRenderer(this, 0, 6);
        this.left_arm.addBox(-3.0F, 17.0F, -0.5F, 2, 1, 1);
        
        this.right_arm = new ModelRenderer(this, 0, 6);
        this.right_arm.addBox(1.0F, 17.0F, -0.5F, 2, 1, 1);
        
        this.left_ear = new ModelRenderer(this, 25, 0);
        this.left_ear.addBox(-1.5F, 12.0F, -1.0F, 1, 2, 1);
        
        this.right_ear = new ModelRenderer(this, 25, 0);
        this.right_ear.addBox(0.5F, 12.0F, -1.0F, 1, 2, 1);
        //this.right_ear.rotateAngleX = -45F;
    }

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    head.render(f5);
	    main_body.render(f5);
	    tail_1.render(f5);
	    tail_2.render(f5);
	    tail_3.render(f5);
	    tail_4.render(f5);
	    left_leg.render(f5);
	    right_leg.render(f5);
	    left_arm.render(f5);
	    right_arm.render(f5);
	    left_ear.render(f5);
	    right_ear.render(f5);
	}
    
    
}
