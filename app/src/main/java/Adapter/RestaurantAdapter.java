package Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Activity.StallActivity;
import hcmute.edu.vn.foodapp_16.R;
import hcmute.edu.vn.foodapp_16.Restaurant;

public class RestaurantAdapter extends RecyclerView.Adapter< RestaurantAdapter. RestaurantViewHolder>{

    private List<Restaurant> mListRestaurants;
    private Context mContext;

    public RestaurantAdapter(Context context, List<Restaurant> mListRestaurants) {
        this.mContext = context;
        this.mListRestaurants = mListRestaurants;
    }


    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantAdapter.RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        final Restaurant restaurant = mListRestaurants.get(position);
        if(restaurant == null){
            return;
        }
        holder.imgFood.setImageResource(restaurant.getImage());
        holder.tvNameRestaurant.setText(restaurant.getNameRestaurant());
        holder.tvNameFood.setText(restaurant.getNameFood());
        holder.tvRating.setText(restaurant.getRating());

        holder.layoutItemRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickGoToStall(restaurant);
            }
        });
    }

    private void OnClickGoToStall(Restaurant restaurant) {
        Intent intent = new Intent(mContext, StallActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_stall", restaurant);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListRestaurants != null){
            return mListRestaurants.size();
        }
        return 0;
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemRestaurant;
        private ImageView imgFood;
        private TextView tvNameRestaurant;
        private TextView tvNameFood;
        private TextView tvRating;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemRestaurant = itemView.findViewById(R.id.layout_item_restaurant);
            imgFood = itemView.findViewById(R.id.imageView_Food);
            tvNameRestaurant = itemView.findViewById(R.id.textView_RestaurantName);
            tvNameFood = itemView.findViewById(R.id.textView_FoodName);
            tvRating = itemView.findViewById(R.id.textView_Rating);
        }
    }
}
