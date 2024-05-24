package till.huongthuy.thick_appnote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import till.huongthuy.thick_appnote.Adapters.NotesListAdapter;
import till.huongthuy.thick_appnote.DataBase.RoomDB;
import till.huongthuy.thick_appnote.Models.Notes;

public class ManHinhNotes extends AppCompatActivity {
    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
    RoomDB database;
    FloatingActionButton fab_btn;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_notes);

        recyclerView = findViewById(R.id.recycler_view);
        fab_btn = findViewById(R.id.fab_add_btn);
        searchView = findViewById(R.id.search_view);
        database = RoomDB.getInstance(this);
        notes = database.dao().getAll();
        updateRecycler(notes);

        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManHinhNotes.this,NotesActivity.class);
                startActivityForResult(intent,101);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
    }
    private void filter(String newText){
        List<Notes> filter_list = new ArrayList<>();
        for(Notes single_notes : notes){
            if(single_notes.getTittle().toLowerCase().contains(newText.toLowerCase())
            || single_notes.getNotes().toLowerCase().contains(newText.toLowerCase())){
                filter_list.add(single_notes);

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101){
            if(resultCode == Activity.RESULT_OK){
                Notes new_notes = (Notes) data.getSerializableExtra("note");
                database.dao().insert(new_notes);
                notes.clear();
                notes.addAll(database.dao().getAll());
                notesListAdapter.notifyDataSetChanged();
            }
        }

        else if(requestCode==102){
            if(resultCode==Activity.RESULT_OK){
                Notes new_notes = (Notes) data.getSerializableExtra("note");
                database.dao().update(new_notes.getID(),new_notes.getTittle(),new_notes.getNotes());
                notes.clear();
                notes.addAll(database.dao().getAll());
                notesListAdapter.notifyDataSetChanged();
            }
        }
    }

    private void updateRecycler(List<Notes> notes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        notesListAdapter = new NotesListAdapter(ManHinhNotes.this,notes,notesClick);
        recyclerView.setAdapter(notesListAdapter);

    }
    private final NotesClick notesClick = new NotesClick() {
        @Override
        public void onClick(Notes notes) {
            Intent intent = new Intent(ManHinhNotes.this,NotesActivity.class);
            intent.putExtra("old_note",notes);
            startActivityForResult(intent,102);
        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {

        }
    };
}