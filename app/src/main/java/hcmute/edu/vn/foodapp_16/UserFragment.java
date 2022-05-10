package hcmute.edu.vn.foodapp_16;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import Activity.AccountActivity;
import Activity.OrderActivity;
import Activity.PaymentActivity;
import Activity.VoucherActivity;


public class UserFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        ImageButton imgBtnOrder = (ImageButton) view.findViewById(R.id.textView_Order);
        imgBtnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), OrderActivity.class);
                startActivity(in);
            }
        });

        ImageButton imgBtnVoucher = (ImageButton) view.findViewById(R.id.textView_Voucher);
        imgBtnVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), VoucherActivity.class);
                startActivity(in);
            }
        });

        ImageButton imgBtnPayment = (ImageButton) view.findViewById(R.id.textView_Payment);
        imgBtnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), PaymentActivity.class);
                startActivity(in);
            }
        });

        ImageButton imgBtnAccount = (ImageButton) view.findViewById(R.id.textView_Account);
        imgBtnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), AccountActivity.class);
                startActivity(in);
            }
        });

        ///
        ImageButton imgBtnHome = (ImageButton) view.findViewById(R.id.textView_Home);
        imgBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment  = new HomeFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frame_layout, fragment, fragment.getTag())
                        .commit();

            }
        });

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
}