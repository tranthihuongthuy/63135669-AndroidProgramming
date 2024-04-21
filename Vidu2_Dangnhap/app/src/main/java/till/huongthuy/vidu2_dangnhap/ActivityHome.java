package till.huongthuy.vidu2_dangnhap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.image);
        // Nhận dữ liệu tên người dùng từ Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        // Hiển thị tên người dùng trên giao diện
        TextView tvUserName = findViewById(R.id.tvUserName);
        tvUserName.setText(username);
    }
}