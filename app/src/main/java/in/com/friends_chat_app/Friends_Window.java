package in.com.friends_chat_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Friends_Window extends AppCompatActivity {

    CircleImageView cimgfriend;
    TextView txtFriendName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends__window);

        Intent i = getIntent();

        // Recieving the intent from FriendsAdapter classes
        String name = i.getStringExtra("name");
        String photo = i.getStringExtra("photo");

        // picasso library to load the images from online mode
        Picasso.get().load(photo).into(cimgfriend);
        txtFriendName.setText(name);
    }
}