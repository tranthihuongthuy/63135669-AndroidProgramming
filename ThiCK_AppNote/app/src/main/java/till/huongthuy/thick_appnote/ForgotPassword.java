package till.huongthuy.thick_appnote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {

    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailEditText = findViewById(R.id.fogotpassword);

        findViewById(R.id.passwordrecoverbutton).setOnClickListener(v -> recoverPassword());
        findViewById(R.id.gobacktologin).setOnClickListener(v -> goToLogin());
    }

    private void recoverPassword() {
        String email = emailEditText.getText().toString().trim();
        if (email.isEmpty()) {
            Toast.makeText(ForgotPassword.this, "Vui lòng nhập email của bạn", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy thông tin tài khoản đã đăng ký từ SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String registeredEmail = sharedPreferences.getString("registeredEmail", "");
        String registeredPassword = sharedPreferences.getString("registeredPassword", "");

        if (email.equals(registeredEmail)) {
            Toast.makeText(ForgotPassword.this, "Mật khẩu của bạn là: " + registeredPassword, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ForgotPassword.this, "Email không tồn tại", Toast.LENGTH_SHORT).show();
        }
    }

    private void goToLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
