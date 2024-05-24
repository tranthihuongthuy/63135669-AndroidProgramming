package till.huongthuy.thick_appnote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

import till.huongthuy.thick_appnote.Models.Notes;

public class NotesActivity extends AppCompatActivity {
    EditText editText_tittle,editText_notes;
    ImageView image_save;
    Notes notes;
    boolean is_old_note = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        image_save = findViewById(R.id.image_view_save);
        editText_tittle = findViewById(R.id.edit_text_tittle);
        editText_notes = findViewById(R.id.edit_text_notes);
        is_old_note = true;

        notes = new Notes();
        try{
            notes = (Notes) getIntent().getSerializableExtra("old_note");
            editText_tittle.setText(notes.getTittle());
            editText_notes.setText(notes.getNotes());
        }catch (Exception e){
            e.printStackTrace();
        }

        image_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tittle = editText_tittle.getText().toString();
                String description = editText_notes.getText().toString();

                if(description.isEmpty()){
                    Toast.makeText(NotesActivity.this,"Please add some notes!",Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat fomat = new SimpleDateFormat("EEE,d MMM yyyy HH : mm: a");
                Date date = new Date();
                if(is_old_note){
                    notes = new Notes();
                }
                notes.setTittle(tittle);
                notes.setNotes(description);
                notes.setDate(fomat.format(date));
                Intent intent = new Intent();
                intent.putExtra("note",notes);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}