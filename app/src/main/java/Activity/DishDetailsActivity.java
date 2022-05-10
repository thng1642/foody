package Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.foodapp_16.Food;
import hcmute.edu.vn.foodapp_16.R;

public class DishDetailsActivity extends AppCompatActivity {

    Button btnAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);


        //Click Food -> Go to Dish Details Activity
        ///////////////////////////////////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Food food = (Food) bundle.get("object_food") ;

        TextView tvFoodName = findViewById(R.id.textView_FoodName);
        TextView tvDescription = findViewById(R.id.textView_Description);
        TextView tvPrice = findViewById(R.id.textView_Price);
        ImageView imgViewFood = findViewById(R.id.imageView_Food);

        tvFoodName.setText(food.getName());
        tvDescription.setText(food.getDescription());
        tvPrice.setText(food.getPrice());
        imgViewFood.setImageResource(food.getImage());

        /////////////////////////////////////////////////////////////////////////////////

        btnAddCart = (Button) findViewById(R.id.button_Add_To_Card);



    }
}