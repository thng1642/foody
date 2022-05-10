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

import Activity.DishDetailsActivity;
import hcmute.edu.vn.foodapp_16.Food;
import hcmute.edu.vn.foodapp_16.R;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    private List<Food> mListFoods;
    private Context mContext;

    public FoodAdapter(Context context, List<Food> mListFoods) {
        this.mContext = context;
        this.mListFoods = mListFoods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, parent, false);
        return new FoodAdapter.FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        final Food food = mListFoods.get(position);
        if(food == null){
            return;
        }
        holder.imgFood.setImageResource(food.getImage());
        holder.tvName.setText(food.getName());
        holder.tvDescription.setText(food.getDescription());
        holder.tvPrice.setText(food.getPrice());

        holder.layoutItemFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickGoToDishDetails(food);
            }
        });

    }

    private void OnClickGoToDishDetails(Food food) {
        Intent intent = new Intent(mContext, DishDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_food", food);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mListFoods != null){
            return mListFoods.size();
        }
        return 0;
    }

    public class  FoodViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemFood;
        private ImageView imgFood;
        private TextView tvName;
        private TextView tvDescription;
        private TextView tvPrice;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemFood = itemView.findViewById(R.id.layout_item_food);
            imgFood = itemView.findViewById(R.id.imageView_Food);
            tvName = itemView.findViewById(R.id.textView_FoodName);
            tvDescription = itemView.findViewById(R.id.textView_Description);
            tvPrice = itemView.findViewById(R.id.textView_Price);

        }
    }
}
