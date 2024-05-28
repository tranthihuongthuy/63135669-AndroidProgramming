package till.huongthuy.thick_appnote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import till.huongthuy.thick_appnote.Models.Notes;

public class NotesActivity extends AppCompatActivity {
    EditText editText_title, editText_notes;
    ImageView image_save;
    Notes notes;
    boolean is_old_note = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        image_save = findViewById(R.id.image_view_save);
        editText_title = findViewById(R.id.edit_text_tittle);
        editText_notes = findViewById(R.id.edit_text_notes);

        // Kiểm tra xem có ghi chú cũ được truyền vào không
        notes = (Notes) getIntent().getSerializableExtra("old_note");
        if (notes != null) {
            editText_title.setText(notes.getTittle());
            editText_notes.setText(notes.getNotes());
            is_old_note = true;
        } else {
            notes = new Notes();
        }

        image_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editText_title.getText().toString();
                String description = editText_notes.getText().toString();

                if (description.isEmpty()) {
                    Toast.makeText(NotesActivity.this, "Vui lòng thêm một số ghi chú!", Toast.LENGTH_SHORT).show();
                    return;
                }

                SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm a");
                Date date = new Date();

                notes.setTittle(title);
                notes.setNotes(description);
                notes.setDate(format.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
