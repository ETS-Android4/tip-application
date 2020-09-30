package com.yetkinyurtsever.kermit_tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    TextView textView1, textView2;
    CardView c1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final ListView listView = (ListView) findViewById(R.id.betView);
        textView1 = (TextView) findViewById(R.id.nickname);
        textView2 = (TextView) findViewById(R.id.subInfo);
        c1 = (CardView) findViewById(R.id.avatar);
        c1.setPreventCornerOverlap(false);

        int profileID = getIntent().getIntExtra("PROFILE_ID", 0);

        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();


        if(profileID == 0){
            Toast.makeText(this, "Error occured!", Toast.LENGTH_SHORT).show();
        }else if(profileID == 1){

            textView1.setText("Alperen'in tahminleri");
            textView2.setText("Bet King");

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("tippers/Alperen");

            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<BetCard> betArray = new ArrayList<>();

                    for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                        String dbHome = (String) messageSnapshot.child("Home").getValue();
                        String dbAway = (String) messageSnapshot.child("Away").getValue();
                        String dbCode = (String) messageSnapshot.child("Code").getValue();
                        String dbPredict = (String) messageSnapshot.child("Prediction").getValue();

                        System.out.println("db code: " + dbCode);
                        BetCard b = new BetCard(dbHome, dbAway, dbCode, dbPredict);
                        betArray.add(b);
                    }

                    Collections.reverse(betArray);

                    BetListAdapter adapter = new BetListAdapter(getApplicationContext(), R.layout.adapter_view_layout, betArray);
                    listView.setAdapter(adapter);
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

        }else if(profileID == 2){

            textView1.setText("Göktürk'ün tahminleri");
            textView2.setText("Bet Ninja");

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("tippers/Göktürk");

            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<BetCard> betArray = new ArrayList<>();

                    for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                        String dbHome = (String) messageSnapshot.child("Home").getValue();
                        String dbAway = (String) messageSnapshot.child("Away").getValue();
                        String dbCode = (String) messageSnapshot.child("Code").getValue();
                        String dbPredict = (String) messageSnapshot.child("Prediction").getValue();

                        System.out.println("db code: " + dbCode);
                        BetCard b = new BetCard(dbHome, dbAway, dbCode, dbPredict);
                        betArray.add(b);
                    }

                    Collections.reverse(betArray);

                    BetListAdapter adapter = new BetListAdapter(getApplicationContext(), R.layout.adapter_view_layout, betArray);
                    listView.setAdapter(adapter);
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
    }
}
