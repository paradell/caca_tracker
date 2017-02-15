package app.cacatracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;


public class InsertUserDialog extends DialogFragment{

    /* The activity that creates an instance of this dialog fragment must
    * implement this interface in order to receive event callbacks.
            * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;

    public void onAttach(Context context){
        super.onAttach(context);
        mListener = (NoticeDialogListener) context;

    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog_builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Import the defined layout in the dialog
        dialog_builder.setView(inflater.inflate(R.layout.insert_user_dialog, null))
        // Add action buttons
                .setPositiveButton(R.string.add_user, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Add a new row with the name of the new user
                        mListener.onDialogPositiveClick(InsertUserDialog.this);

                    }
                })
                .setNegativeButton(R.string.cancel_add_user, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Close the dialog and nothing is done
                        mListener.onDialogNegativeClick(InsertUserDialog.this);

                    }
                });



        return dialog_builder.create();
    }
}
