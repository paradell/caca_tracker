package app.cacatracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;


public class InsertUserDialog extends DialogFragment{

    /* The activity that creates an instance of this dialog fragment must
    * implement this interface in order to receive event callbacks.
            * Each method passes the DialogFragment in case the host needs to query it. */
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String name);
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
        dialog_builder.setTitle("Add a new user");

        // Add a insert text field in the Alert Dialog
        final EditText name = new EditText(getActivity());
        name.setHint(R.string.insert_user_hint);

        dialog_builder.setView(name);

        // Import the defined layout in the dialog
        dialog_builder.setPositiveButton(R.string.add_user, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Send the user name to MainActivity to use the text value
                        mListener.onDialogPositiveClick(InsertUserDialog.this, name.getText().toString());

                    }
                })
                .setNegativeButton(R.string.cancel_add_user, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogNegativeClick(InsertUserDialog.this);

                    }
                });

        return dialog_builder.create();
    }
}
