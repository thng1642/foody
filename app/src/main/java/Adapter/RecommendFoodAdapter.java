package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.foodapp_16.R;
import hcmute.edu.vn.foodapp_16.RecommendFood;

public class RecommendFoodAdapter extends RecyclerView.Adapter<RecommendFoodAdapter.RecommendFoodViewHolder> {

    private List<RecommendFood> mListRecommendFood;

    public RecommendFoodAdapter(List<RecommendFood> mListRecommendFood){
        this.mListRecommendFood = mListRecommendFood;
    }

    @NonNull
    @Override
    public RecommendFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend_food, parent, false);
        return new RecommendFoodAdapter.RecommendFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendFoodViewHolder holder, int position) {
        RecommendFood recommendFood = mListRecommendFood.get(position);
        if(recommendFood == null){
            return;
        }
        holder.imgFood.setImageResource(recommendFood.getImage());
        holder.tvPrice.setText(recommendFood.getPrice());
        holder.tvName.setText(recommendFood.getName());
    }

    @Override
    public int getItemCount() {
        if(mListRecommendFood != null){
            return mListRecommendFood.size();
        }
        return 0;
    }

    public class RecommendFoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView tvPrice;
        private TextView tvName;
        public RecommendFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgView_Food);
            tvPrice = itemView.findViewById(R.id.textView_Price);
            tvName = itemView.findViewById(R.id.textView_FoodName);
        }
    }
}
