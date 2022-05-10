package Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import hcmute.edu.vn.foodapp_16.CartFragment;
import hcmute.edu.vn.foodapp_16.HomeFragment;
import hcmute.edu.vn.foodapp_16.NotificationFragment;
import hcmute.edu.vn.foodapp_16.R;
import hcmute.edu.vn.foodapp_16.SearchFragment;
import hcmute.edu.vn.foodapp_16.UserFragment;

public class HomeActivity extends AppCompatActivity {

    //BOTTOM NAVIGATION
    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //BOTTOM NAVIGATION

        bottomNavigation = findViewById(R.id.bottom_navigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_bag));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_search));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_notification));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_person));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    case 1:
                        fragment = new CartFragment();
                        break;
                    case 2:
                        fragment = new SearchFragment();
                        break;
                    case 3:
                        fragment = new HomeFragment();
                        break;
                    case 4:
                        fragment = new NotificationFragment();
                        break;
                    case 5:
                        fragment = new UserFragment();
                        break;
                }
                loadFragment(fragment);

            }
        });

        //set notification count
        bottomNavigation.setCount(4,"10");
        //set home fragment initially selected
        bottomNavigation.show(3, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                        , "You Clicked " + item.getId()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext()
                        , "You Reselected " + item.getId()
                        , Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}