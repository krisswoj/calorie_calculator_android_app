package com.example.kuba.myapp.result;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kuba.myapp.R;

import java.util.ArrayList;

public class MealsResultView extends AppCompatActivity {


        ArrayList<DataModel> dataModels;
        ListView listView;
        private static CustomAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result_view);

            listView = (ListView) findViewById(R.id.list);

            dataModels = new ArrayList<>();
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));
            dataModels.add(new DataModel("Apple Pie", "Android 1.0", "1", "September 23, 2008", "https://pixabay.com/static/uploads/photo/2014/07/10/11/00/daisies-388946_960_720.jpg"));

            adapter = new CustomAdapter(dataModels, getApplicationContext());
            listView.setAdapter(adapter);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    DataModel dataModel = dataModels.get(position);
                    showTestPage(view, dataModel.getName());
                }
            });
        }



        public void showTestPage(View view, String valueToDisplay){

            Intent intent = new Intent(this, TestActivity.class);
            Bundle extras = new Bundle();

            extras.putString("rs1", valueToDisplay);

            intent.putExtras(extras);
            startActivity(intent);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }



