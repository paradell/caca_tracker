package app.cacatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_layout);

    }

    public void addUser(View v){
        addUserRow();
    }

    public LinearLayout createUserRow(){
        LinearLayout user_row = new LinearLayout(this);

        // Define user icon
        ImageView user_image = new ImageView(this);
        user_image.setImageResource(R.drawable.usericon);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.user_icon_width),(int) getResources().getDimension(R.dimen.user_icon_height));
        user_image.setLayoutParams(layoutParams);

        // Define user name
        TextView user_text = new TextView(this);
        user_text.setText(R.string.user1_name);

        // Add icon and text to the row view
        user_row.addView(user_image);
        user_row.addView(user_text);
        return user_row;
    }
    public void addUserRow(){
        // Actual addition of a new user to the view list
        LinearLayout user_list = (LinearLayout) findViewById(R.id.user_list);
        LinearLayout user_row = createUserRow();
        user_list.addView(user_row);
    }
}
