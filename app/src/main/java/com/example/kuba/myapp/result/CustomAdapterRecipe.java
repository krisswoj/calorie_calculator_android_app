package com.example.kuba.myapp.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.kuba.myapp.R;

import java.util.List;

import domain.mealRecipe.MealRecipeResponse;
import domain.meals.Meal;

public class CustomAdapterRecipe extends ArrayAdapter<MealRecipeResponse> implements View.OnClickListener {

    private ImageLoader mImageLoader;
    private List<MealRecipeResponse> dataSet;
    private Context mContext;

    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        NetworkImageView img;
    }

    public CustomAdapterRecipe(List<MealRecipeResponse> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;
    }


    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MealRecipeResponse mealRecipeResponse = getItem(position);
        ViewHolder viewHolder;
        mImageLoader = CustomVolleyRequestQueue.getInstance(getContext()).getImageLoader();
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);

            viewHolder.txtName = convertView.findViewById(R.id.name);
            viewHolder.txtType = convertView.findViewById(R.id.type);
            viewHolder.img = convertView.findViewById(R.id.network_img_view);

            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.txtName.setText(mealRecipeResponse.getTitle());
        viewHolder.txtType.setText(String.valueOf(mealRecipeResponse.getReadyInMinutes()));
        viewHolder.img.setImageUrl("https://spoonacular.com/recipeImages/" + mealRecipeResponse.getImage(), mImageLoader);

        return convertView;
    }
}
