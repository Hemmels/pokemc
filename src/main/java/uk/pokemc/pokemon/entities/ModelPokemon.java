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

@SideOnly(Side.CLIENT)
public class ModelPokemon extends ModelBase {

  public static final List<ModelRenderer> PIKACHU = createModelFromJson("pikachu");
  public List<ModelRenderer> blocks;

  public ModelPokemon(List<ModelRenderer> blocks) {
    this.blocks = blocks;
  }

  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    super.render(entity, f, f1, f2, f3, f4, f5);
    for (ModelRenderer renderer : blocks) {
      renderer.render(f5);
    }
  }

  public static List<ModelRenderer> createModelFromJson(String name) {
    ArrayList<Block> elements = new ArrayList<Block>(10);
    InputStream file = ModelPokemon.class.getClassLoader()
        .getResourceAsStream("assets/pokemc/models/entity/" + name + ".json");
    // Read data from file of given name
    JsonParser parser = new JsonParser();
    JsonElement jsonElement = parser.parse(new InputStreamReader(file));
    JsonObject obj = jsonElement.getAsJsonObject();
    JsonArray blocks = obj.getAsJsonArray("componentGroups").get(0).getAsJsonObject()
        .getAsJsonArray("components");
    for (JsonElement block : blocks) {
      elements.add(new Block(block.getAsJsonObject()));
    }

    // Build model from data
    List<ModelRenderer> blocksForRender = new ArrayList<ModelRenderer>(blocks.size());
    ModelBase base = new ModelPokemon(blocksForRender);
    ModelRenderer modelRenderer;
    float[] position;
    int[] size;
    for (Block block : elements) {
      modelRenderer = new ModelRenderer(base, 0, 0);
      position = convertToFloatArray(block.getPosition());
      size = block.getSize();
      modelRenderer.addBox(position[0], position[1], position[2], size[0], size[1], size[2]);
      blocksForRender.add(modelRenderer);
    }
    System.out.println(name + " has " + blocksForRender.size());
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
