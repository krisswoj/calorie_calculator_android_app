package domain;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class MealsApiRequest extends AsyncTask<Void, Void, String> {

    private static final String API_URL_RESPONSE = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate";
    private static final String API_KEY = "58350e36fbmsh0d1027c7c4adcd2p1dbdd9jsn8aa5925947d2";

    private String timeFrame;
    private String targetCalories;
    private String typeOfDiet;
    private String excludedIngredients;

    private String response;

    public MealsApiRequest(String timeFrame, String targetCalories, String typeOfDiet, String excludedIngredients) {
        this.timeFrame = timeFrame;
        this.targetCalories = targetCalories;
        this.typeOfDiet = typeOfDiet;
        this.excludedIngredients = excludedIngredients;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            CloseableHttpClient client = HttpClients.createDefault();

            URIBuilder builder = new URIBuilder(API_URL_RESPONSE);
            builder
                    .setParameter("timeFrame", timeFrame)
                    .setParameter("targetCalories", targetCalories)
                    .setParameter("diet", typeOfDiet)
                    .setParameter("exclude", excludedIngredients);

            HttpGet httpGet = new HttpGet(builder.build());

            httpGet.setHeader("X-RapidAPI-Key", API_KEY);
            CloseableHttpResponse response = client.execute(httpGet);
            this.response = httpResponseConverter(response);
            client.close();

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }

    private String httpResponseConverter(CloseableHttpResponse response) throws IOException {

        String res = null;
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream instream = entity.getContent();
            byte[] bytes = IOUtils.toByteArray(instream);
            res = new String(bytes, "UTF-8");
            instream.close();
        }
        return res;
    }
}
