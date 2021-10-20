package com.silikhe.healthcare.ui.Hospital

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment
import com.silikhe.healthcare.R


class HospitalDialog : AppCompatDialogFragment() {
    private var donTitle: EditText? = null
    private var donDesc: EditText? = null
    private var donImage: EditText? = null
    var storyTitle: String? = null
    var storyDesc: String? = null
    var storyImage: String? = null
//    private var firebaseDatabase: FirebaseDatabase? = null
//    private var databaseReference: DatabaseReference? = null
    var storyId: String? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(
            requireActivity()
        )
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.hospital_dialog, null)
        builder.setView(view)
            .setTitle("Create An Order")
            .setNegativeButton(
                "Cancel"
            ) { dialogInterface, i -> }
            .setPositiveButton(
                "Add Order"
            ) { dialogInterface, i ->
//                postStory()
                donTitle = view.findViewById(R.id.story_title)
                donDesc = view.findViewById(R.id.story_description)
                donImage = view.findViewById(R.id.img_url)
//                firebaseDatabase = FirebaseDatabase.getInstance()
//                databaseReference = firebaseDatabase.getReference("Stories")
            }
        donTitle = view.findViewById(R.id.story_title)
        donDesc = view.findViewById(R.id.story_description)
        donImage = view.findViewById(R.id.img_url)
        return builder.create()
    }

//    fun postStory() {
//        databaseReference = FirebaseDatabase.getInstance().getReference("Stories")
//        storyTitle = donTitle!!.text.toString()
//        storyDesc = donDesc!!.text.toString()
//        storyImage = donImage!!.text.toString()
//        storyId = storyTitle
//        val story = StoryModel(storyId, storyTitle, storyDesc, storyImage)
//        databaseReference.addValueEventListener(object : ValueEventListener() {
//            fun onDataChange(snapshot: DataSnapshot) {
//                databaseReference.child(storyId).setValue(story)
//                Log.d(
//                    TAG,
//                    "Message added successfully:$databaseReference"
//                )
//            }
//
//            fun onCancelled(error: DatabaseError) {
//                Log.d(TAG, "There was an error: $error")
//            }
//        })
//    }

    companion object {
        private const val TAG = "StoryDialogue"
    }
}