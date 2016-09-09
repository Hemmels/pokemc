package uk.pokemc.pokemon.entities;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.pokemc.json.Block;
import uk.pokemc.pokemon.bulbasaur.ModelBulbasaur;
import uk.pokemc.pokemon.pikachu.ModelPikachu;

@SideOnly(Side.CLIENT)
public class BDCraftModelPokemon extends ModelBase {

	// Ignore the horrendous design pattern/factory for now
	public static final BDCraftModelPokemon BULBASAUR = new BDCraftModelPokemon(createModelFromJson(1, "bulbasaur", 1280, 640));
	public static final BDCraftModelPokemon SQUIRTLE = new BDCraftModelPokemon(createModelFromJson(2, "squirtle", 128, 64));
	public static final BDCraftModelPokemon PIKACHU = new BDCraftModelPokemon(createModelFromJson(25, "pikachu", 1024, 256));

	public List<ModelRenderer> blocks;
	
	public static ModelBase getByPokeId(int id){
		switch (id){
			case 1:{
				return new ModelBulbasaur();
			}
			case 2:{
				return new ModelSquirtle();
			}
			default:{
				return new ModelPikachu();
			}
		}
	}

	public BDCraftModelPokemon(List<ModelRenderer> blocks) {
		this.blocks = blocks;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		for (ModelRenderer renderer : blocks) {
			renderer.render(f5);
		}
	}

	public static List<ModelRenderer> createModelFromJson(int pokeid, String name, int x, int y) {
		ArrayList<Block> elements = new ArrayList<Block>(10);
		InputStream file = BDCraftModelPokemon.class.getClassLoader().getResourceAsStream("assets/pokemc/models/entity/" + name + ".json");
		if (file == null) {
			return null;
		}

		// Read data from file of given name
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(new InputStreamReader(file));
		JsonObject obj = jsonElement.getAsJsonObject();
		JsonArray blocks = obj.getAsJsonArray("componentGroups").get(0).getAsJsonObject().getAsJsonArray("components");
		for (JsonElement block : blocks) {
			elements.add(new Block(block.getAsJsonObject()));
		}

		// Build model from data
		List<ModelRenderer> blocksForRender = new ArrayList<ModelRenderer>(blocks.size());
		ModelBase base = getByPokeId(pokeid);
		ModelRenderer modelRenderer;
		float[] position;
		int[] size;
		double[] textureOffset = null;
		double[] rotations;
		for (Block block : elements) {
			position = convertToFloatArray(block.getPosition());
			size = block.getSize();
			textureOffset = block.gettOffset();
			modelRenderer = new ModelRenderer(base, (int)textureOffset[0], (int)textureOffset[1]);
			// TODO: Rotations aren't trivial copies from Block class :(
//			rotations = block.getRotation();
//			System.out.println(String.format("rotations for block: %f,%f,%f", (float)rotations[0], (float)rotations[1], (float)rotations[2]));
			modelRenderer.addBox(position[0], position[1], position[2], size[0], size[1], size[2]);
//			modelRenderer.setRotationPoint((float)rotations[0], (float)rotations[1], (float)rotations[2]);
			modelRenderer.setTextureSize(x, y);
			blocksForRender.add(modelRenderer);
		}
		System.out.println(name + " has " + blocksForRender.size() + " renderable blocks");
		System.out.println(String.format("and is using texture with size: %d,%d", x, y));
		return blocksForRender;
	}

	private static float[] convertToFloatArray(double[] input) {
		float[] floatArray = new float[input.length];
		for (int i = 0; i < input.length; i++) {
			floatArray[i] = (float) input[i];
		}
		return floatArray;
	}
}
