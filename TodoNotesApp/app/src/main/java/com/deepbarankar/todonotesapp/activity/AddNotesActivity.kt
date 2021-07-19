package com.deepbarankar.todonotesapp.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.FileProvider
import com.deepbarankar.todonotesapp.BuildConfig
import com.deepbarankar.todonotesapp.R
import com.deepbarankar.todonotesapp.utils.AppConstant
import java.io.File
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class AddNotesActivity : AppCompatActivity() {

    companion object {
        //This is the static equivalent of Kotlin
        //Anything inside the companion object block belongs to the class
        const val REQUEST_CODE_CAMERA = 1
        const val REQUEST_CODE_GALLERY = 2
    }

    lateinit var editTextTitle: EditText
    lateinit var editTextDescription: EditText
    lateinit var submitButton: Button
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)
        bindViews()
        clickListener()
    }

    private fun clickListener() {
        submitButton.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent()
                intent.putExtra(AppConstant.TITLE, editTextTitle.text.toString())
                intent.putExtra(AppConstant.DESCRIPTION, editTextDescription.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        })

        imageView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                setupDialog()
            }
        })
    }

    private fun setupDialog() {
        val view = LayoutInflater.from(this@AddNotesActivity).inflate(R.layout.dialog_selector, null) //Here null in inflate means that we are not attaching it to any View Group
        val textViewCamera = view.findViewById<TextView>(R.id.textViewCamera)
        val textViewGallery = view.findViewById<TextView>(R.id.textViewGallery)

        val dialog = AlertDialog.Builder(this)
            .setView(view)
            .setCancelable(true)
            .create()

        dialog.show()

        textViewCamera.setOnClickListener(object : View.OnClickListener{
            /*
            When we first click on the camera option,
            It first specifies a intent that I have to capture the image
            Then we create a temporary file and convert it to a URI
            Then we pass that URI to the intent

            So, basically what would happen is,
            The image that we created, would be passed to the intent by using putExtra
            So that whenever we take an image, that image will be assigned to that URI
            And then we are starting the camera using startActivityForResult
             */
            override fun onClick(v: View?) {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if(takePictureIntent.resolveActivity(packageManager) != null) {
                    var photoFile: File? = null
                    try {
                        photoFile = createImageFile()
                    } catch (e: Exception) {
                        print(e.message)
                    }
                    if(photoFile != null) {
                        //We need to define Provider in the AndroidManifest file to use FileProvider
                        val photoUri = FileProvider.getUriForFile(this@AddNotesActivity,
                            BuildConfig.APPLICATION_ID+".provider",
                            photoFile)
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
                        startActivityForResult(takePictureIntent, REQUEST_CODE_CAMERA)
                    }
                }
            }

        })

        textViewGallery.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI) //Here we are doing action using intent rather than loading a new Activity.
                // Here we are doing an action of picking an image's path
                startActivityForResult(intent, REQUEST_CODE_GALLERY)
                dialog.hide()
            }

        })
    }

    private fun createImageFile(): File? {
        val timeStamp = SimpleDateFormat("yyyyMMddHHmmss").format(Date())
        val fileName: String = "JPEG " + timeStamp + "_"
        val storageDirectory: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDirectory)
    }

    private fun bindViews() {
        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        submitButton = findViewById(R.id.buttonSubmit)
        imageView = findViewById(R.id.imageViewAdd)
    }


}
