package till.huongthuy.thick_appnote;

import androidx.cardview.widget.CardView;

import till.huongthuy.thick_appnote.Models.Notes;

public interface NotesClick {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardView);
}
