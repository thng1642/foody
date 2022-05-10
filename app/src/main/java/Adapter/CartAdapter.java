package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.foodapp_16.Cart;
import hcmute.edu.vn.foodapp_16.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    private List<Cart> mListCarts;

    public CartAdapter(List<Cart> mListCarts){

        this.mListCarts = mListCarts;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartAdapter.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = mListCarts.get(position);
        if(cart == null){
            return;
        }
        holder.imgCart.setImageResource(cart.getImage());
        holder.tvNameFood.setText(cart.getNameFood());
        holder.tvQuantity.setText(cart.getQuantity());
        holder.tvNote.setText(cart.getNote());
        holder.tvSubTotal.setText(cart.getSubTotal());
    }

    @Override
    public int getItemCount() {
        if(mListCarts != null){
            return mListCarts.size();
        }
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCart;
        private TextView tvNameFood;
        private TextView tvQuantity;
        private TextView tvNote;
        private TextView tvSubTotal;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCart = itemView.findViewById(R.id.imageView_Food);
            tvNameFood = itemView.findViewById(R.id.textView_FoodName);
            tvQuantity = itemView.findViewById(R.id.textView_Quantity);
            tvNote = itemView.findViewById(R.id.textView_Note);
            tvSubTotal = itemView.findViewById(R.id.textView_SubTotal);
        }
    }
}
