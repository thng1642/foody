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

import Activity.FilterFoodActivity;
import hcmute.edu.vn.foodapp_16.Categories;
import hcmute.edu.vn.foodapp_16.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{

    private List<Categories> mListCategories;
    private Context mContext;


    public CategoriesAdapter(Context context, List<Categories> mListCategories){
        this.mContext = context;
        this.mListCategories = mListCategories;
    }


    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories, parent, false);
        return new CategoriesAdapter.CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        final Categories categories = mListCategories.get(position);
        if(categories == null){
            return;
        }
        holder.imgCategories.setImageResource(categories.getImage());
        holder.tvCategories.setText(categories.getCategories());

        holder.layoutItemCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickGoToFilterFood(categories);
            }


        });
    }


    private void OnClickGoToFilterFood(Categories categories) {
        Intent intent = new Intent(mContext, FilterFoodActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_category", categories);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    //Get ID


    @Override
    public int getItemCount() {
        if(mListCategories != null){
            return mListCategories.size();
        }
        return 0;
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemCategory;
        private ImageView imgCategories;
        private TextView tvCategories;
        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemCategory = itemView.findViewById(R.id.layout_item_category);
            imgCategories = itemView.findViewById(R.id.imgView_Categories);
            tvCategories = itemView.findViewById(R.id.textView_Categories);
        }

    }
}
