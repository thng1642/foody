package hcmute.edu.vn.foodapp_16;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.FoodAdapter;

public class SearchFragment extends Fragment {

    private RecyclerView rcvFoods;

    private FoodAdapter foodAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        rcvFoods = view.findViewById(R.id.rcv_foods);
        rcvFoods.setLayoutManager(new LinearLayoutManager(this.getContext()));

        foodAdapter = new FoodAdapter(this.getContext(),getListFoods());

        rcvFoods.setAdapter(foodAdapter);
        rcvFoods.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private List<Food> getListFoods() {
        List<Food> list = new ArrayList<>();

        list.add(new Food(R.drawable.list_food_1, "Most Loved Fried Chicken", "Ha Noi", "4.5 (100+)"));
        list.add(new Food(R.drawable.popular_banner_01, "Chicken", "Ha Noi", "4.5 (100+)"));
        list.add(new Food(R.drawable.popular_banner_02, "Pasta", "Ha Noi", "4.5 (100+)"));

        return list;
    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}