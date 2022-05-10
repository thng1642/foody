package hcmute.edu.vn.foodapp_16;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MessageAdapter;

public class NotificationFragment extends Fragment {

    private RecyclerView rcvMessages;

    private MessageAdapter messageAdapter;

    private Button btnOnBack;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        rcvMessages = view.findViewById(R.id.rcv_messages);
        rcvMessages.setLayoutManager(new LinearLayoutManager(this.getContext()));

        messageAdapter = new MessageAdapter(getListMessages());

        rcvMessages.setAdapter(messageAdapter);

        rcvMessages.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));

//        btnOnBack = view.findViewById(R.id.button_OnBack);

//        btnOnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                HomeFragment homeFragment = new HomeFragment();
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container_fm_notification, homeFragment, null).addToBackStack(null).commit();
//            }
//        });

        //Button Back Home
        ImageButton imgBtnOnBack = (ImageButton) view.findViewById(R.id.button_OnBack);
        imgBtnOnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment  = new HomeFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frame_layout, fragment, fragment.getTag())
                        .commit();
            }
        });

        return view;
    }


    private List<Message> getListMessages() {
        List<Message> list = new ArrayList<>();

        list.add(new Message(R.drawable.ic_message_cart, "Có món mới rồi. Khám phá ngay thôi!", "12 hours ago"));
        list.add(new Message(R.drawable.ic_message_account, "Có món mới rồi. Khám phá ngay thôi!", "12 hours ago"));
        list.add(new Message(R.drawable.ic_message_food, "Có món mới rồi. Khám phá ngay thôi!", "12 hours ago"));
        list.add(new Message(R.drawable.ic_message_cart, "Có món mới rồi. Khám phá ngay thôi!", "12 hours ago"));
        list.add(new Message(R.drawable.ic_message_account, "Có món mới rồi. Khám phá ngay thôi!", "12 hours ago"));
        list.add(new Message(R.drawable.ic_message_food, "Có món mới rồi. Khám phá ngay thôi!", "12 hours ago"));

        return list;
    }
}