package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.foodapp_16.Order;
import hcmute.edu.vn.foodapp_16.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder>{

    private List<Order> mListOrders;

    public OrderAdapter(List<Order> mListOrders){

        this.mListOrders = mListOrders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderAdapter.OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        Order order = mListOrders.get(position);
        if(order == null){
            return;
        }
        holder.imgCart.setImageResource(order.getImage());
        holder.tvNameFood.setText(order.getNameFood());
        holder.tvQuantity.setText(order.getQuantity());
        holder.tvTotal.setText(order.getTotal());
        holder.tvStatus.setText(order.getStatus());
    }

    @Override
    public int getItemCount() {
        if(mListOrders != null){
            return mListOrders.size();
        }
        return 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCart;
        private TextView tvNameFood;
        private TextView tvQuantity;
        private TextView tvTotal;
        private TextView tvStatus;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCart = itemView.findViewById(R.id.imageView_Food);
            tvNameFood = itemView.findViewById(R.id.textView_FoodName);
            tvQuantity = itemView.findViewById(R.id.textView_Quantity);
            tvTotal = itemView.findViewById(R.id.textView_Total);
            tvStatus = itemView.findViewById(R.id.textView_Status);
        }
    }
}
