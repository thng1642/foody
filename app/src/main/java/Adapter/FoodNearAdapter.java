package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.foodapp_16.FoodNear;
import hcmute.edu.vn.foodapp_16.R;

public class FoodNearAdapter extends RecyclerView.Adapter<FoodNearAdapter.FoodNearViewHolder>{

    private List<FoodNear> mListFoodNear;

    public FoodNearAdapter(List<FoodNear> mListFoodNear){
        this.mListFoodNear = mListFoodNear;
    }

    @NonNull
    @Override
    public FoodNearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food_near, parent, false);
        return new FoodNearAdapter.FoodNearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodNearViewHolder holder, int position) {
        FoodNear foodNear = mListFoodNear.get(position);
        if(foodNear == null){
            return;
        }
        holder.imgFood.setImageResource(foodNear.getImage());
        holder.tvPrice.setText(foodNear.getPrice());
        holder.tvName.setText(foodNear.getName());
    }

    @Override
    public int getItemCount() {
        if(mListFoodNear != null){
            return mListFoodNear.size();
        }
        return 0;
    }

    public class FoodNearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView tvPrice;
        private TextView tvName;
        public FoodNearViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgView_Food);
            tvPrice = itemView.findViewById(R.id.textView_Price);
            tvName = itemView.findViewById(R.id.textView_FoodName);
        }
    }
}
