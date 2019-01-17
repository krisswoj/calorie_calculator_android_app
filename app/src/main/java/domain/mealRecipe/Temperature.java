
package domain.mealRecipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("number")
    @Expose
    private float number;
    @SerializedName("unit")
    @Expose
    private String unit;

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
