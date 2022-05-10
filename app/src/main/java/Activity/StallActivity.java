package Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.foodapp_16.Food;
import Adapter.FoodAdapter;
import hcmute.edu.vn.foodapp_16.R;
import hcmute.edu.vn.foodapp_16.Restaurant;

public class StallActivity extends AppCompatActivity {

    private RecyclerView rcvFoods;

    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stall);

        //RECYCLE VIEW MENU FOOD
        ///////////////////////////////////////////////////////////////////////////////////////////////
        rcvFoods = findViewById(R.id.rcv_menu);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvFoods.setLayoutManager(linearLayoutManager);

        foodAdapter = new FoodAdapter(this, getListFoods());
        rcvFoods.setAdapter(foodAdapter);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        //Click Restaurant -> Go to Stall Activity -> name restaurant
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Restaurant restaurant = (Restaurant) bundle.get("object_stall");

        TextView tvStallName = findViewById(R.id.textView_StallName);
        ImageView imgViewFood = findViewById(R.id.imageView_Food);

        tvStallName.setText(restaurant.getNameRestaurant());
        imgViewFood.setImageResource(restaurant.getImage());
        /////////////////////////////////////////////////////////////////////////////////

    }

    private List<Food> getListFoods() {
        List<Food> list = new ArrayList<>();

        list.add(new Food(R.drawable.list_food_1, "Most Loved Fried Chicken", "Gồm bún, đậu, thịt chân giò, chả cốm, nem chua rán", "$17.00"));
        list.add(new Food(R.drawable.popular_banner_01, "Bún đậu mẹt tre", "Gồm bún, đậu, thịt chân giò, chả cốm, nem chua rán", "$17.00"));
        list.add(new Food(R.drawable.popular_banner_02, "Bún đậu mắm tôm", "Gồm bún, đậu, thịt chân giò, chả cốm, nem chua rán", "$17.00"));
        list.add(new Food(R.drawable.list_food_1, "Most Loved Fried Chicken", "Gồm bún, đậu, thịt chân giò, chả cốm, nem chua rán", "$17.00"));
        list.add(new Food(R.drawable.popular_banner_01, "Bún đậu mẹt tre", "Gồm bún, đậu, thịt chân giò, chả cốm, nem chua rán", "$17.00"));
        list.add(new Food(R.drawable.popular_banner_02, "Bún đậu mắm tôm", "Gồm bún, đậu, thịt chân giò, chả cốm, nem chua rán", "$17.00"));

        return list;
    }
}