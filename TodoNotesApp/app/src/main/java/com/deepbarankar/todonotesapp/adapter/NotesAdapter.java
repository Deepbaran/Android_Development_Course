package com.deepbarankar.todonotesapp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepbarankar.todonotesapp.R;
import com.deepbarankar.todonotesapp.clickListeners.ItemClickListener;
import com.deepbarankar.todonotesapp.db.Notes;
//import com.deepbarankar.todonotesapp.model.Notes;

import java.util.List;

//This is an adapter: It helps us to display the data in the list to a specific layout that we want to show.
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<Notes> listNotes;
    private ItemClickListener itemClickListener;
    String TAG = "NotesAdapter";

    public NotesAdapter(List<Notes> list, ItemClickListener itemClickListener) {
        this.listNotes = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate a layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_adapter_layout, parent, false);
        return new ViewHolder(view); //Binding the new view (layout file) to the ViewHolder.
        //We are passing to the ViewHolder constructor that is defined below.
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        //Bind data from list to the new ViewHolder we created
        Notes notes = listNotes.get(position);
        String title = notes.getTitle();
        String description = notes.getDescription();
        holder.textViewTitle.setText(title);
        holder.textViewDescription.setText(description);
        holder.checkBoxMarkStatus.setChecked(notes.isTaskCompleted());

        //We can interact with the items
        //Passing the data from the adapter to the MyNotesActivity
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(notes);
            }
        });
        holder.checkBoxMarkStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                notes.setTaskCompleted(isChecked);
//                Log.d(TAG, String.valueOf(isChecked));
                itemClickListener.onUpdate(notes);
            }
        });
    }

    @Override
    public int getItemCount() {
        //return number of items in the list
        return listNotes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle, textViewDescription;
        CheckBox checkBoxMarkStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            checkBoxMarkStatus = itemView.findViewById(R.id.checkboxMarkStatus);
        }
    }
}
