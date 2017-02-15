package app.cacatracker;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements InsertUserDialog.NoticeDialogListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_layout);

    }

    public void addUser(View v){
        // Start the insert User dialog
        DialogFragment dialog = new InsertUserDialog();
        dialog.show(getFragmentManager(), "add_user");
    }

    public LinearLayout createUserRow(String name){
        LinearLayout user_row = new LinearLayout(this);

        // Define user icon
        ImageView user_image = new ImageView(this);
        user_image.setImageResource(R.drawable.usericon);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.user_icon_width),(int) getResources().getDimension(R.dimen.user_icon_height));
        user_image.setLayoutParams(layoutParams);

        // Define user name
        TextView user_text = new TextView(this);
        user_text.setText(name);

        // Add icon and text to the row view
        user_row.addView(user_image);
        user_row.addView(user_text);
        return user_row;
    }
    public void addUserRow(String name){
        // Actual addition of a new user to the view list
        LinearLayout user_list = (LinearLayout) findViewById(R.id.user_list);
        LinearLayout user_row = createUserRow(name);
        user_list.addView(user_row);
    }

    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button
        EditText name = (EditText) findViewById(R.id.input_username);
        addUserRow(name.getText().toString());
    }

    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.getDialog().cancel();
    }
}
