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
import hcmute.edu.vn.foodapp_16.Bean.Customer;

public class SignupActivity extends AppCompatActivity {

    private TextView txtLogin;
    private Button btnSinUp;
    private TextView txtPhone;
    private TextView txtFullname;
    private TextView txtPassword;
    private TextView txtConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txtLogin = (TextView) findViewById(R.id.txtLogin);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // Đăng ký tài khoản cho khách hàng
        // Mapping
        btnSinUp = (Button) findViewById(R.id.buttonSignUp);
        txtPhone = (TextView) findViewById(R.id.editTextPhone);
        txtFullname = (TextView) findViewById(R.id.editTextUser);
        txtPassword = (TextView) findViewById(R.id.editTextPassword);
        txtConfirmPass = (TextView) findViewById(R.id.editTextConfirmPassword);

        btnSinUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phone = txtPhone.getText().toString(),
                        fullName = txtFullname.getText().toString(),
                        password = txtPassword.getText().toString();

                if (password.equals(txtConfirmPass.getText().toString()) == false) {
                    Toast.makeText(SignupActivity.this, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                }
                else {
                    Customer customer;
                    try {

                        customer = new Customer(fullName, phone, password);
                    }
                    catch (Exception e) {
                        customer = new Customer();
                        Toast.makeText(SignupActivity.this, "Error creating", Toast.LENGTH_SHORT).show();
                    }

                    CustomerModel dbCustomer = new CustomerModel(SignupActivity.this);
                    boolean isSuccess = dbCustomer.addOne(customer);

                    if (isSuccess == true) {

                        // Forward to home activity
                        Toast.makeText(SignupActivity.this, "Thành công", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(SignupActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}