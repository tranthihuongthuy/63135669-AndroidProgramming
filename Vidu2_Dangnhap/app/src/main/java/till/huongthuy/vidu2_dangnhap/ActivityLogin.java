package till.huongthuy.vidu2_dangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLogin extends AppCompatActivity {

    private static final String CORRECT_USERNAME = "tranthihuongthuy";
    private static final String CORRECT_PASSWORD = "123";

    private EditText edtUserName;
    private EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        edtPass = findViewById(R.id.edtPass);
    }

    public void XacNhan(View v) {
        String username = edtUserName.getText().toString().trim();
        String password = edtPass.getText().toString().trim();

        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            // Đăng nhập thành công
            Toast.makeText(ActivityLogin.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            // Chuyển sang màn hình chính
            Intent iQuiz = new Intent(ActivityLogin.this, ActivityHome.class);
            iQuiz.putExtra("USERNAME", username);
            startActivity(iQuiz);
            finish();
        } else {
            // Đăng nhập thất bại
            Toast.makeText(ActivityLogin.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }
}