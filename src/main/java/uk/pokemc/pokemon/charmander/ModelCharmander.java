package uk.pokemc.pokemon.charmander;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCharmander extends ModelBase {

	public ModelRenderer head;
	public ModelRenderer mouth;
	public ModelRenderer main_body;
	public ModelRenderer left_leg;
	public ModelRenderer right_leg;
	public ModelRenderer left_arm;
	public ModelRenderer right_arm;
	public ModelRenderer tail;
	public ModelRenderer tail_tip;

	/**
	 * So now we have the correct shape, just need to work out how to do the
	 * texture and animations.
	 */

	public ModelCharmander() {
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-1.5F, 12F, -1F, 3, 4, 2);
		
		this.mouth = new ModelRenderer(this,0,0);
		this.mouth.addBox(-1F, 14F, -3F, 2, 1, 2);
		this.mouth.addBox(-1F, 13.7F, -2.5F, 2, 2, 2);		
		
		this.main_body = new ModelRenderer(this, 0, 0);
		this.main_body.addBox(-2F, 16.0F, -1.5F, 4, 6, 3);
		
		this.left_leg = new ModelRenderer(this, 0, 0);
		this.left_leg.addBox(-2.5F, 21F, -1F, 2, 2, 2);
		this.left_leg.addBox(-2F, 23F, -0.5F, 1, 1, 1);

		this.right_leg = new ModelRenderer(this, 0, 0);
		this.right_leg.addBox(0.5F, 21F, -1F, 2, 2, 2);
		this.right_leg.addBox(1F, 23F, -0.5F, 1, 1, 1);

		this.right_arm = new ModelRenderer(this, 0, 0);
		this.right_arm.addBox(-4, 18F, -0.5F, 2, 1, 1);

		this.left_arm = new ModelRenderer(this, 0, 0);
		this.left_arm.addBox(2F, 18F, -0.5F, 2, 1, 1);

		this.tail = new ModelRenderer(this, 0, 0);
		this.tail.addBox(-1.5F, 19F, 1F, 3, 3, 3);
		this.tail.addBox(-1F, 18.5F, 4F, 2, 2, 2);
		this.tail.addBox(-0.5F, 17.5F, 6F, 1, 2, 1);
		
		this.tail_tip = new ModelRenderer(this,13,0);
		this.tail_tip.addBox(-1F, 15.5F, 5F, 2, 2, 2);


	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		main_body.render(f5);
		head.render(f5);
		mouth.render(f5);
		right_leg.render(f5);
		left_leg.render(f5);
		right_arm.render(f5);
		left_arm.render(f5);
		tail.render(f5);
		tail_tip.render(f5);
	}

}
