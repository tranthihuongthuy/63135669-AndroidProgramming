package till.edu.ex4_addsubmuldiv_onclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các đối tượng gắn với điều khiển ứng ở đây
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong,nutTru,nutNhan,nutChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }
    void TimDieuKhien(){
        editTextSo1 = (EditText) findViewById(R.id.edtSo1);
        editTextSo2 = (EditText) findViewById(R.id.edtSo2);
        editTextKQ = (EditText) findViewById(R.id.edtKQ);
        nutCong = (Button) findViewById(R.id.btnCong);
        nutTru = (Button) findViewById(R.id.btnTru);
        nutNhan = (Button) findViewById(R.id.btnNhan);
        nutChia = (Button) findViewById(R.id.btnChia);
    }
    //Xử lý cộng
    public void XuLyCong(View v){
        //Code xử lý cộng ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 và số 2
        //b1.2. Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2. Tính toán
        float Tong = soA + soB;
        //b3. Hiển thị kết quả
        //b3.1.
        //3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tong);
        //b3.3. gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý trừ
    public void XuLyTru(View v){
        //Code xử lý trừ ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 và số 2
        //b1.2. Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2. Tính toán
        float Hieu = soA - soB;
        //b3. Hiển thị kết quả
        //b3.1.
        //3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Hieu);
        //b3.3. gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý nhân
    public void XuLyNhan(View v){
        //Code xử lý nhân ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 và số 2
        //b1.2. Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2. Tính toán
        float Tich = soA * soB;
        //b3. Hiển thị kết quả
        //b3.1.
        //3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Tich);
        //b3.3. gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKQ);
    }
    //Xử lý chia
    public void XuLyChia(View v){
        //Code xử lý chia ở đây
        //b1. Lấy dữ liệu 2 số
        //b1.1. Tìm EditText số 1 và số 2
        //b1.2. Lấy dữ liệu từ 2 điều khiển đó
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3. Chuyển dữ liệu từ chuỗi sang số
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2. Tính toán
        float Thuong = soA / soB;
        //b3. Hiển thị kết quả
        //b3.1.
        //3.2. Chuẩn bị dữ liệu xuất, biến thành dạng chuỗi
        String chuoiKQ = String.valueOf(Thuong);
        //b3.3. gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKQ);
    }
}