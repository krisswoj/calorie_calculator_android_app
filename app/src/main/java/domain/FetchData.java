package domain;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Abhishek Panwar on 7/14/2017.
 */

public class FetchData extends AsyncTask<Void, Void, String> {
    private String data = "";
    private String dataParsed = "";
    private String singleParsed = "";

    @Override
    protected String doInBackground(Void... voids) {
        try {


            CloseableHttpClient client = HttpClients.createDefault();

            URIBuilder builder = new URIBuilder("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate");
            builder
                    .setParameter("timeFrame", "day")
//                    .setParameters(nameValuePairList(allegroSellersId))
                    .setParameter("targetCalories", "2500")
                    .setParameter("diet", "paleo");

            HttpGet httpGet = new HttpGet(builder.build());

            httpGet.setHeader("X-RapidAPI-Key", "58350e36fbmsh0d1027c7c4adcd2p1dbdd9jsn8aa5925947d2");
            CloseableHttpResponse response = client.execute(httpGet);
            String res = httpResponseConverter(response);
//            String res = response.toString();
            client.close();

            System.out.println("test json reposne: " + res);



//            HttpResponse<JsonNode> response = Unirest.get("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate?timeFrame=day&targetCalories=2000&diet=vegetarian&exclude=shellfish%2C+olives")
//                    .header("X-RapidAPI-Key", "58350e36fbmsh0d1027c7c4adcd2p1dbdd9jsn8aa5925947d2").asJson();
//
//            URIBuilder builder = new URIBuilder();
//            builder.setScheme("https")
//                    .setHost("spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
//                    .setPath("/recipes/mealplans/generate")
//                    .setParameter("timeFrame", "day")
//                    .setParameter("targetCalories", "2500")
//                    .setParameter("diet", "paleo")
//                    .setParameter("exclude", "oils")
//                    .setParameter("X-RapidAPI-Key", "58350e36fbmsh0d1027c7c4adcd2p1dbdd9jsn8aa5925947d2");

//            builder.build().toString();



//            URL url = new URL("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate");
//            URL url = new URL(builder.build().toString());

//            System.out.println("test json reposne: " + response.getBody().toString());


            URL url = new URL("https://api.myjson.com/bins/j5f6b");
//            URL url = new URL("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate?timeFrame=day&targetCalories=2000&diet=vegetarian&exclude=shellfish%2C+olives");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data += line;
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return data;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
//        MainActivity.data.setText(this.dataParsed);

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

//    private List<NameValuePair> nameValuePairs (String timeFrame, int targetCalories, String diet, String exclude){
//        List<NameValuePair> nameValuePairs = new
//    }
}
