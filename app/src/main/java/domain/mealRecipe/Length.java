
package domain.mealRecipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Length {

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("unit")
    @Expose
    private String unit;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
