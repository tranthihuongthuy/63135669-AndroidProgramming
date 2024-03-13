package till.edu.ex_6_listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTenTinhThanhVN;//khai báo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Hiển thị dữ liệu trong listview
        //B1 Cần có dữ liệu
        //Thông thường lây trong SQL, noSQL...
        //Bài này ta viết dữ liệu trực tếp

        dsTenTinhThanhVN = new ArrayList<String>();//tạo thể hiện cụ thể
        //thông thường ta lấy dữ liệu từ nguồn khác
        //bài này viết code tay
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Nha Trang");
        dsTenTinhThanhVN.add("Phú Yên");
        dsTenTinhThanhVN.add("Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đà Nẵng");
        dsTenTinhThanhVN.add("Đà Lạt");
        //tạo adapter
        ArrayAdapter<String> adapterTinhThanhVN;
        adapterTinhThanhVN = new ArrayAdapter<String>(this,
                android.R.layout.simple_gallery_item,
                dsTenTinhThanhVN);

        //Gắn vào điều khiển hiển thị với listview
        //B3.1 Tìm
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        //B3.2 Gắn
        lvTenTinhThanh.setAdapter(adapterTinhThanhVN);
        //3.3 Lắng nghe và xử lý sự kiện user tương tác
        //Gắn bộ lắng nghe vào
        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXL);
    }
    //tạo bộ lắng nghe và xu lý sự kiện onitemclick, đặt vào một biến
    //vd BoLangNghevaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Hiện lên màn hình thông báo nhanh về vị trí của phần tử vừa chọn
            //Toast.makeText(MainActivity.this,"Bạn vừa chọn "+String.valueOf(i),Toast.LENGTH_LONG).show();

            //Hiện lên màn hình thông báo nhanh về giá trị của phần tử vừa chọn

            String StrTenTinhChon = dsTenTinhThanhVN.get(i);
            Toast.makeText(MainActivity.this,StrTenTinhChon,Toast.LENGTH_LONG).show();
        }
    };
}