package com.deepbarankar.todonotesapp.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.deepbarankar.todonotesapp.NotesApp;
import com.deepbarankar.todonotesapp.R;
import com.deepbarankar.todonotesapp.adapter.NotesAdapter;
import com.deepbarankar.todonotesapp.clickListeners.ItemClickListener;
import com.deepbarankar.todonotesapp.db.Notes;
import com.deepbarankar.todonotesapp.db.NotesDao;
//import com.deepbarankar.todonotesapp.model.Notes;
import com.deepbarankar.todonotesapp.utils.AppConstant;
import com.deepbarankar.todonotesapp.utils.PrefConstant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MyNotesActivity extends AppCompatActivity {

    private static final int ADD_NOTES_CODE = 100;
    String fullName, userName;
    FloatingActionButton fabAddNotes;
    //    TextView textViewTitle, textViewDescription; //Using RecyclerView instead of this
    String TAG = "MyNotesActivity";
    SharedPreferences sharedPreferences;
    RecyclerView recyclerViewNotes;
    ArrayList<Notes> notesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes); //It is used for activities and not fot inserting some other layouts.

        bindView();
        getIntentData();
        getDataFromDatabase();
        setupRecyclerView();

        fabAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d(TAG,"on click performed");

                //calling a pop up window form
//                setupDialogBox();
                Intent intent = new Intent(MyNotesActivity.this, AddNotesActivity.class);
                startActivityForResult(intent, ADD_NOTES_CODE);
                //startActivityForResult() is used when we open a new activity, and then get a result back from the second activity to the first activity.
                //ADD_NOTES_ACTIVITY is used to distinguish between what data we want.
            }
        });

        //Setting fullName in the Activity Action bar
        getSupportActionBar().setTitle(fullName);
    }

    private void getDataFromDatabase() {
        NotesApp notesApp = (NotesApp) getApplicationContext();
        NotesDao notesDao = notesApp.getNotesDb().notesDao();
//        List<Notes> listOfNotes = notesDao.getAll();
//        notesList.addAll(listOfNotes);
        Log.d(TAG, String.valueOf(notesDao.getAll().size()));
        notesList.addAll(notesDao.getAll());
    }

    private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
    }

    private void getIntentData() {
        //Receive the intent holding the data that was passed from the LoginActivity.
        Intent intent = getIntent();
        fullName = intent.getStringExtra(AppConstant.FULL_NAME); //Getting the String value that was passed, corresponding to the key AppConstant.FULL_NAME ("full_name")
        userName = intent.getStringExtra(AppConstant.USER_NAME);

        if (TextUtils.isEmpty(fullName) && TextUtils.isEmpty(userName)) {
            setupSharedPreferences();
            fullName = sharedPreferences.getString(AppConstant.FULL_NAME, "");
            userName = sharedPreferences.getString(AppConstant.USER_NAME, "");
        }
    }

    private void bindView() {
        fabAddNotes = findViewById(R.id.fabAddNotes); //findViewById is only used to access the widgets from the activity's layout file and nowhere else.

        //Using RecyclerView instead of this
//        textViewTitle = findViewById(R.id.textViewTitle);
//        textViewDescription = findViewById(R.id.textViewDescription);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
    }

//    private void setupDialogBox() {
//        View view = LayoutInflater.from(MyNotesActivity.this).inflate(R.layout.add_notes_dialog_layout, null);
//        //from() takes a context and inflate() takes a layout integer file of resource and a view group.
//        //Inflate means putting layout inside the Activity
//
//        //Accessing the widgets of add_notes_dialog_layout
//        EditText editTextTitle = view.findViewById(R.id.editTextTitle);
//        EditText editTextDescription = view.findViewById(R.id.editTextDescription);
//        Button buttonSubmit = view.findViewById(R.id.buttonSubmit);
//
//        //Dialog (or, Pop up)
//        AlertDialog dialog = new AlertDialog.Builder(this) //Builder() takes context and "this" defines "MyNotesActivity.this".
//                .setView(view)
//                .setCancelable(false) //Dialog will not close if we touch outside the dialog box
//                .create();
//
//        //show the dialog box
//        dialog.show();
//
//        buttonSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String title = editTextTitle.getText().toString();
//                String description = editTextDescription.getText().toString();
//                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)) {
//
////                Log.d(TAG,title);
////                Log.d(TAG,description);
//
//                    //Using RecyclerView instead of this
////                textViewTitle.setText(title);
////                textViewDescription.setText(description);
//
//                    Notes notes = new Notes();
//                    notes.setTitle(title);
//                    notes.setDescription(description);
//                    notesList.add(notes);
////                Log.d(TAG, String.valueOf(notesList.size()));
//
//                    addNotesToDb(notes);
//                } else {
//                    Toast.makeText(MyNotesActivity.this,"Title or Description can't be empty",Toast.LENGTH_SHORT).show();
//                }
//
////                setupRecyclerView();
//
//                //close the dialog box
//                dialog.hide();
//
//                //rcv -> adapter -> list
//            }
//        });
//    }

    private void addNotesToDb(Notes notes) {
        //insert notes in DB
        NotesApp notesApp = (NotesApp) getApplicationContext(); //Taking a global context of type NotesApp

        //To do anything in the Database (Insert, Query, etc.) we need the DAO class.
        NotesDao notesDao = notesApp.getNotesDb().notesDao();
        notesDao.insert(notes);
    }

    private void setupRecyclerView() {
        //interface: In Android interface is a way for us to interact with RecyclerView items.
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(Notes notes) {
//                Log.d(TAG, "on Click Worked");
                Intent intent = new Intent(MyNotesActivity.this, DetailActivity.class);
                intent.putExtra(AppConstant.TITLE, notes.getTitle());
                intent.putExtra(AppConstant.DESCRIPTION, notes.getDescription());
                startActivity(intent);
            }

            @Override
            public void onUpdate(Notes notes) {
                //update the value of the check box
//                Log.d(TAG, String.valueOf(notes.isTaskCompleted()));

                NotesApp notesApp = (NotesApp) getApplicationContext();
                NotesDao notesDao = notesApp.getNotesDb().notesDao();
                notesDao.update(notes);
            }
        };

        //Creating the Adapter
//        NotesAdapter notesAdapter = new NotesAdapter(notesList);
        NotesAdapter notesAdapter = new NotesAdapter(notesList, itemClickListener);

        //Setting up the layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyNotesActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        //Setting up the RecyclerView with the layout manager and adapter
        recyclerViewNotes.setLayoutManager(linearLayoutManager);
        recyclerViewNotes.setAdapter(notesAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        //This method catches the data returned from the second activity that was called using startActivityForResult()
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ADD_NOTES_CODE) {
            String title = data.getStringExtra(AppConstant.TITLE);
            String description = data.getStringExtra(AppConstant.DESCRIPTION);

            if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description)) {
                NotesApp notesApp = (NotesApp) getApplicationContext();
                NotesDao notesDao = notesApp.getNotesDb().notesDao();

                Notes note = new Notes();
                note.setTitle(title);
                note.setDescription(description);

                notesList.add(note);
                notesDao.insert(note);

                recyclerViewNotes.getAdapter().notifyItemChanged(notesList.size() - 1); //Updating the adapter in the RecyclerView
            }
        }
    }
}















