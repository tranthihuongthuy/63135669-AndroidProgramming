package till.edu.ex3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gắn view tương ứng với file này
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
    //Đây là bộ lắng nghe và xử lý sự kiện click lên nút Tính tổng
    public void XuLyCong(View view){
        //Tìm, tham chiếu đến điều khiển trên tệp XML, mapping sang java file
        EditText  editTextSoA = findViewById(R.id.edtA);
        EditText  editTextSoB = findViewById(R.id.edtB);
        EditText  editTextKetQua = findViewById(R.id.edtKetQua);
        //Lấy dữ liệu về
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();
        //Chuyển dữ liệu sang dạng số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);
        //Tính toán theo yêu cầu
        int tong = so_A + so_B;
        String strTong = String.valueOf(tong); //chuyển sang dạng chuỗi
        //Hiện ra màn hình
        editTextKetQua.setText(strTong);
    }
}