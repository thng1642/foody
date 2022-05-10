package Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.foodapp_16.Order;
import Adapter.OrderAdapter;
import hcmute.edu.vn.foodapp_16.R;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView rcvOrders;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        rcvOrders = findViewById(R.id.rcv_orders);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvOrders.setLayoutManager(linearLayoutManager);

        orderAdapter = new OrderAdapter(getListOrders());
        rcvOrders.setAdapter(orderAdapter);
        
    }

    private List<Order> getListOrders() {
        List<Order> list = new ArrayList<>();

        list.add(new Order(R.drawable.popular_banner_05, "Most Loved Fried Chicken","3", "$ 50.00", "Complete"));
        list.add(new Order(R.drawable.popular_banner_02, "Most Loved Fried Chicken","3", "$ 50.00", "Complete"));
        list.add(new Order(R.drawable.popular_banner_03, "Most Loved Fried Chicken","3", "$ 50.00", "Complete"));
        list.add(new Order(R.drawable.popular_banner_01, "Most Loved Fried Chicken","3", "$ 50.00", "Complete"));
        list.add(new Order(R.drawable.popular_banner_04, "Most Loved Fried Chicken","3", "$ 50.00", "Complete"));


        return list;
    }
}