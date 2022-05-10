package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.foodapp_16.PopularFood;
import hcmute.edu.vn.foodapp_16.R;

public class PopularFoodAdapter extends RecyclerView.Adapter<PopularFoodAdapter.PopularFoodViewHolder>{

    private List<PopularFood> mListPopularFood;

    public PopularFoodAdapter(List<PopularFood> mListPopularFood){
        this.mListPopularFood = mListPopularFood;
    }

    @NonNull
    @Override
    public PopularFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular_food, parent, false);
        return new PopularFoodAdapter.PopularFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularFoodViewHolder holder, int position) {
        PopularFood popularFood = mListPopularFood.get(position);
        if(popularFood == null){
            return;
        }
        holder.imgFood.setImageResource(popularFood.getImage());
        holder.tvName.setText(popularFood.getName());
        holder.tvPrice.setText(popularFood.getPrice());
        holder.tvRating.setText(popularFood.getRating());
    }

    @Override
    public int getItemCount() {
        if(mListPopularFood != null){
            return mListPopularFood.size();
        }
        return 0;
    }

    public class PopularFoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvRating;
        public PopularFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgView_Food);
            tvName = itemView.findViewById(R.id.textView_FoodName);
            tvPrice = itemView.findViewById(R.id.textView_Price);
            tvRating = itemView.findViewById(R.id.textView_Rating);
        }
    }
}
