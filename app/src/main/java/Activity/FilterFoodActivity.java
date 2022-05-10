package Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.foodapp_16.Categories;
import hcmute.edu.vn.foodapp_16.R;
import hcmute.edu.vn.foodapp_16.Restaurant;
import Adapter.RestaurantAdapter;

public class FilterFoodActivity extends AppCompatActivity {

    private RecyclerView rcvFilterFood;
    private RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_food);

        //RECYCLE VIEW FILTER FOOD
        ///////////////////////////////////////////////////////////////////////////////////////////////
        rcvFilterFood = findViewById(R.id.rcv_filter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvFilterFood.setLayoutManager(linearLayoutManager);

        restaurantAdapter = new RestaurantAdapter(this, getListFilter());
        rcvFilterFood.setAdapter(restaurantAdapter);
        ///////////////////////////////////////////////////////////////////////////////////////////////

        //Click Category -> Go to Filter Food Activity -> name category
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Categories categories = (Categories) bundle.get("object_category");

        TextView tvCategoryName = findViewById(R.id.textView_CategoryName);

        tvCategoryName.setText(categories.getCategories());
        /////////////////////////////////////////////////////////////////////////////////


    }

    private List<Restaurant> getListFilter() {
        List<Restaurant> list = new ArrayList<>();

        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre", "Bún đậu tá lả", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre", "Bún đậu tá lả", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_05, "We Food - Hủ Tiếu Nam Vang", "Hủ tiếu Nam Vang", "4.1 (100+)"));
        list.add(new Restaurant(R.drawable.popular_banner_02, "Bún Đậu Mắm Tôm Mẹt Tre", "Bún đậu tá lả", "4.1 (100+)"));


        return list;
    }
}