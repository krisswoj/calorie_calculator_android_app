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

public class MealRecipeApiRequest extends AsyncTask<Void, Void, String> {

    private static final String API_URL_RESPONSE = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/";
    private static final String API_KEY = "58350e36fbmsh0d1027c7c4adcd2p1dbdd9jsn8aa5925947d2";

    private String recipeId;
    private String response;

    public MealRecipeApiRequest(String recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {

            String urlLink = String.format("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/%s/information", recipeId);

            CloseableHttpClient client = HttpClients.createDefault();

            URIBuilder builder = new URIBuilder(urlLink);
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
