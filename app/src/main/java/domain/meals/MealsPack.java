
package domain.meals;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealsPack extends OutputStream {

    @SerializedName("meals")
    @Expose
    private List<Meal> meals = null;
    @SerializedName("nutrients")
    @Expose
    private Nutrients nutrients;

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    @Override
    public void write(int b) throws IOException {

    }
}
