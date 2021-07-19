package com.deepbarankar.todonotesapp.clickListeners;

//import com.deepbarankar.todonotesapp.model.Notes;

import com.deepbarankar.todonotesapp.db.Notes;

public interface ItemClickListener {
    //This interface is going to help us to send the data from the adapter to the MyNotesActivity and at MyNotesActivity, we are going to open a new Activity.
    void onClick(Notes notes);
    void onUpdate(Notes notes);
}
