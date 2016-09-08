package uk.pokemc.json;

import java.util.Arrays;

import com.google.gson.JsonObject;

public class Block {

	String size;
	String origin;
	String position;
	String rotation;
	String tOffset;
	String tSize;

	/**
	 * String representation of a JSON object block in a model.
	 * 
	 * @param obj
	 */
	public Block(JsonObject obj) {
		this.size = obj.get("size").getAsString();
		this.origin = obj.get("origin").getAsString();
		this.position = obj.get("position").getAsString();
		this.rotation = obj.get("rotation").getAsString();
		this.tOffset = obj.get("textureOffset").getAsString();
		this.tSize = obj.get("textureSize").getAsString();
	}

	// No mapToFloat :(
	public int[] getSize() {
		return Arrays.asList(size.split(",")).stream().mapToInt(this::absToInt).toArray();
	}

	public double[] getOrigin() {
		return Arrays.asList(origin.split(",")).stream().mapToDouble(Float::valueOf).toArray();
	}

	public double[] getPosition() {
		return Arrays.asList(position.split(",")).stream().mapToDouble(Float::valueOf).toArray();
	}

	public double[] getRotation() {
		return Arrays.asList(rotation.split(",")).stream().mapToDouble(Float::valueOf).toArray();
	}

	public double[] gettOffset() {
		return Arrays.asList(tOffset.split(",")).stream().mapToDouble(Float::valueOf).toArray();
	}

	public double[] gettSize() {
		return Arrays.asList(tSize.split(",")).stream().mapToDouble(Float::valueOf).toArray();
	}

	private int absToInt(String s) {
		return Double.valueOf(Math.floor(Double.parseDouble(s))).intValue();
	}

}
