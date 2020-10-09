package sfu.cmpt213.a1;

/**
 * Tokimon class that is used to hold and give the variables for the Tokimon object.
 *
 * @name String variable stored that represents the name of the Tokimon.
 * @type String variable stored that represents the type of the Tokimon.
 * @height Double variable stored that represents the height of the Tokimon.
 * @weight Double variable stored that represents the weight of the Tokimon.
 * @strength Double variable stored that represents the strength of the Tokimon that is 0 by default and may be incremented or decremented.
 */

public class Tokimon {
    /**
     *
     */
    private final String name;
    private final String type;
    private final double height;
    private final double weight;
    private double strength;

    Tokimon(String name, String type, Double height, Double weight, Double strength) {
        this.name = name;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.strength = 0.0;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getStrength() {
        return strength;
    }

    public void incrementStrength(Double inc) {
        this.strength += inc;
    }

    @Override
    public String toString() {
        return "Tokimon{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", strength=" + strength +
                '}';
    }

}
