package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.List;

import hcmute.edu.vn.foodapp_16.Message;
import hcmute.edu.vn.foodapp_16.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private List<Message> mListMessages;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public MessageAdapter(List<Message> mListMessages){

        this.mListMessages = mListMessages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new MessageAdapter.MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = mListMessages.get(position);
        if(message == null){
            return;
        }

        viewBinderHelper.bind(holder.swipeRevealLayout,String.valueOf(message.getId()));

        holder.imgMessage.setImageResource(message.getImage());
        holder.tvMessage.setText(message.getMessage());
        holder.tvTime.setText(message.getTime());

        holder.imgBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListMessages.remove(holder.getBindingAdapterPosition());
                notifyItemRemoved(holder.getBindingAdapterPosition());
            }
        });

        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListMessages.remove(holder.getBindingAdapterPosition());
                notifyItemRemoved(holder.getBindingAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mListMessages != null){
            return mListMessages.size();
        }
        return 0;
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder{

        private SwipeRevealLayout swipeRevealLayout;
        private ImageButton imgBtnDelete;
        private LinearLayout layoutDelete;

        private ImageView imgMessage;
        private TextView tvMessage;
        private TextView tvTime;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            swipeRevealLayout = itemView.findViewById(R.id.swipeRevealLayout_Notification);
            imgBtnDelete = itemView.findViewById(R.id.imgButton_Delete);
            layoutDelete = itemView.findViewById(R.id.layout_delete);

            imgMessage = itemView.findViewById(R.id.imageView_Message);
            tvMessage = itemView.findViewById(R.id.textView_Message);
            tvTime = itemView.findViewById(R.id.textView_Time);

        }
    }
}
