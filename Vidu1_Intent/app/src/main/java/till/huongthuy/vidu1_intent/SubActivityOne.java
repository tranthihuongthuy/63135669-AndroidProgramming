package till.huongthuy.vidu1_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_one);
    }
    //Hàm đáp ứng sự kiện nhấn lên nút "Quay về trang chủ"
    //Xử lý chuyển về màn hình trang chủ
    public void QuayVe(View v){
        //Tạo một đối tượng Intent
        Intent iManHinhCHINH = new Intent(this,MainActivity.class);
        startActivity(iManHinhCHINH);
    }
}