package app.cacatracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;


public class InsertUserDialog extends DialogFragment{
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog_builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Import the defined layout in the dialog
        dialog_builder.setView(inflater.inflate(R.layout.insert_user_dialog, null))
        // Add action buttons
                .setPositiveButton(R.string.add_user, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Add a new row with the name of the new user

                    }
                })
                .setNegativeButton(R.string.cancel_add_user, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Close the dialog and nothing is done
                        getDialog().cancel();

                    }
                });



        return dialog_builder.create();
    }
}
