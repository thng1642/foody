package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.foodapp_16.Model.CustomerModel;
import hcmute.edu.vn.foodapp_16.R;

public class LoginActivity extends AppCompatActivity {

    private TextView phone;
    private TextView password;
    private TextView txtSignup;
    private Button btnLogin;
    private CustomerModel customerModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtSignup = (TextView) findViewById(R.id.txtSignUp);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        customerModel = new CustomerModel(LoginActivity.this);

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                phone = (TextView) findViewById(R.id.editTextPhone);
                password = (TextView) findViewById(R.id.editTextPassword);

                String myPassword = customerModel.findPassword(phone.getText().toString());

                Toast.makeText(LoginActivity.this, myPassword,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });



    }
}