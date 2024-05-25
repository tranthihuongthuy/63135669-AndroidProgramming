package till.huongthuy.thick_appnote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout emailLayout;
    private TextInputLayout passwordLayout;
    private String registeredEmail;
    private String registeredPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailLayout = findViewById(R.id.email);
        passwordLayout = findViewById(R.id.password);

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        registeredEmail = sharedPreferences.getString("registeredEmail", "");
        registeredPassword = sharedPreferences.getString("registeredPassword", "");

        findViewById(R.id.login).setOnClickListener(v -> login());
        findViewById(R.id.gotoforgotpassword).setOnClickListener(v -> goToForgotPassword());
        findViewById(R.id.gotosignup).setOnClickListener(v -> goToSignup());
    }

    private void login() {
        String email = emailLayout.getEditText().getText().toString().trim();
        String password = passwordLayout.getEditText().getText().toString().trim();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập email và mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.equals(registeredEmail) && password.equals(registeredPassword)) {
            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ManHinhNotes.class);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Email hoặc mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToForgotPassword() {
        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }

    private void goToSignup() {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}
