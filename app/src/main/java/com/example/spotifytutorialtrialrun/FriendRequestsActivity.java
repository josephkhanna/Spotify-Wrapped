package com.example.spotifytutorialtrialrun;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.List;

public class FriendRequestsActivity extends Activity {
    private ListView friendRequestsList;
    private Button friendrequestsbackbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendrequests);
        //friendRequestsList = findViewById(R.id.friend_requests_list);
        //friendrequestsbackbutton = findViewById(R.id.friendrequestsbackbutton);
        //friendrequestsbackbutton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
         //       Intent intent = new Intent(FriendRequestsActivity.this, FriendsActivity.class);
         //       startActivity(intent);
          //  }
        //});
    }
       /*
        // TODO: Fetch the friend requests from your backend server
        List<String> friendRequests = fetchFriendRequests();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.friend_request_item, R.id.friend_request_email, friendRequests);
        friendRequestsList.setAdapter(adapter);

        for (int i = 0; i < friendRequestsList.getChildCount(); i++) {
            View item = friendRequestsList.getChildAt(i);
            Button acceptButton = item.findViewById(R.id.accept_button);
            Button declineButton = item.findViewById(R.id.decline_button);

            acceptButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = ((TextView) item.findViewById(R.id.friend_request_email)).getText().toString();
                    // TODO: Send a request to your backend server to accept the friend request
                    acceptFriendRequest(email);
                }
            });

            declineButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = ((TextView) item.findViewById(R.id.friend_request_email)).getText().toString();
                    // TODO: Send a request to your backend server to decline the friend request
                    declineFriendRequest(email);
                }
            });
        }
    }

    private List<String> fetchFriendRequests() {
        // TODO: Replace with your actual implementation
        return null;
    }

    private void acceptFriendRequest(String email) {
        // TODO: Replace with your actual implementation
    }

    private void declineFriendRequest(String email) {
        // TODO: Replace with your actual implementation
    }
    */
}
