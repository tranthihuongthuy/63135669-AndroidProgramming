package till.edu.examlist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    Examlist examAdapter;
    ArrayList<Exam> recyclerViewData;
    RecyclerView recyclerViewExam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewData = getDataForRecyclerView();
        recyclerViewExam = findViewById(R.id.recyclerViewExams);

        RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(this);
        recyclerViewExam.setLayoutManager(layoutLiner);

        examAdapter = new Examlist(this, recyclerViewData);
        recyclerViewExam.setAdapter(examAdapter);


    }
    ArrayList<Exam> getDataForRecyclerView(){
        ArrayList<Exam> dsDuLieu = new ArrayList<>();
        dsDuLieu.add(new Exam("Kiểm tra Tiếng Anh", "25/5/2024","làm bài kiểm tra trong vòng 75p"));
        dsDuLieu.add(new Exam("Kiểm tra Toán", "30/5/2024","làm bài kiểm tra trong vòng 60p"));
        dsDuLieu.add(new Exam("Kiểm tra Thực Hành", "9/6/2024","làm bài kiểm tra trong vòng 80p"));
        dsDuLieu.add(new Exam("Kiểm tra Di Động", "21/7/2024","làm bài kiểm tra trong vòng 90p"));

        return dsDuLieu;
    }
}