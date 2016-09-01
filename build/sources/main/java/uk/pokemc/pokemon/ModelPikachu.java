package uk.pokemc.pokemon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
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
        this.main_body = new ModelRenderer(this, 0, 0);
        this.main_body.addBox(-5.0F, -1.0F, -7.0F, 15, 6, 5);

        // TODO: Where to start in the flat file?
        this.tail_1 = new ModelRenderer(this, 0, 0);
        this.tail_1.addBox(-7.0F, -1.5F, -5.0F, 1, 1, 2);
        
        this.tail_2 = new ModelRenderer(this, 0, 0);
        this.tail_2.addBox(-7.0F, -2.5F, -4.0F, 1, 1, 2);
        
        this.tail_3 = new ModelRenderer(this, 0, 0);
        this.tail_3.addBox(-7.0F, -3.5F, -2.0F, 1, 2, 3);
        
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-5.5F, -7.0F, -7.5F, 4, 4, 4);
        
        this.tail_4 = new ModelRenderer(this, 0, 0);
        this.tail_4.addBox(-7.0F, -5.0F, 0.0F, 1, 2, 3);
        
        this.left_leg = new ModelRenderer(this, 0, 0);
        this.left_leg.addBox(-6.0F, 0.0F, -9.5F, 1, 1, 1);
        
        this.right_leg = new ModelRenderer(this, 0, 0);
        this.right_leg.addBox(-8.0F, 0.0F, -9.5F, 1, 1, 1);
        
        this.left_arm = new ModelRenderer(this, 0, 0);
        this.left_arm.addBox(-3.0F, -5.0F, -10.0F, 2, 1, 1);
        
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.addBox(-10.0F, -5.0F, -10.0F, 2, 1, 1);
        
        this.left_ear = new ModelRenderer(this, 0, 0);
        this.left_ear.addBox(-9.0F, -10.0F, -9.0F, 1, 3, 1);
        
        this.right_ear = new ModelRenderer(this, 0, 0);
        this.right_ear.addBox(-5.0F, -10.0F, -9.0F, 1, 3, 1);
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
