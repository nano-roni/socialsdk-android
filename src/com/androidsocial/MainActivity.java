package com.androidsocial;

import org.brickred.socialauth.Profile;
import org.brickred.socialauth.android.DialogListener;
import org.brickred.socialauth.android.SocialAuthAdapter;
import org.brickred.socialauth.android.SocialAuthError;
import org.brickred.socialauth.android.SocialAuthListener;
import org.brickred.socialauth.android.SocialAuthAdapter.Provider;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

	SocialAuthAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loging_activity);
        
        adapter=new SocialAuthAdapter(new DialogListener() {

            @Override
            public void onError(SocialAuthError arg0) {
                Log.e("Login activity", arg0.getMessage());
            }

            @Override
            public void onComplete(Bundle arg0) {
                adapter.getUserProfileAsync(new SocialAuthListener<Profile>() {

                    @Override
                    public void onExecute(String arg0, Profile arg1) {
                        Log.d("Custom-UI", "Receiving Data");
                           Profile profileMap = arg1;
                           Log.d("Custom-UI",  "Validate ID         = " + profileMap.getValidatedId());
                           Log.d("Custom-UI",  "First Name          = " + profileMap.getFirstName());
                           Log.d("Custom-UI",  "Last Name           = " + profileMap.getLastName());
                           Log.d("Custom-UI",  "Email               = " + profileMap.getEmail());
                           Log.d("Custom-UI",  "Gender                   = " + profileMap.getGender());
                           Log.d("Custom-UI",  "Country                  = " + profileMap.getCountry());
                           Log.d("Custom-UI",  "Language                 = " + profileMap.getLanguage());
                           Log.d("Custom-UI",  "Location                 = " + profileMap.getLocation());
                           Log.d("Custom-UI",  "Profile Image URL  = " + profileMap.getProfileImageURL());
                           setContentView(R.layout.logedin_activity);
                    }

                    @Override
                    public void onError(SocialAuthError arg0) {
                        // TODO Auto-generated method stub

                    }
                });
            }

            @Override
            public void onCancel() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onBack() {
                // TODO Auto-generated method stub

            }
        });
        Button skip=(Button) findViewById(R.id.btnSkip);
        skip.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	setContentView(R.layout.logedin_activity);
            }
        });

        ImageView imgFacebook=(ImageView) findViewById(R.id.facebook);
        imgFacebook.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.authorize(MainActivity.this, Provider.FACEBOOK);
            }
        });
        ImageView imgGoogle=(ImageView) findViewById(R.id.googleplus);
        imgGoogle.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.addCallBack(Provider.GOOGLE,"http://socialauth.in/socialauthdemo");
                adapter.authorize(MainActivity.this, Provider.GOOGLE);
            }
        });
        ImageView imgTwitter=(ImageView) findViewById(R.id.twitter);
        imgTwitter.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                adapter.addCallBack(Provider.TWITTER,"http://socialauth.in/socialauthdemo/socialAuthSuccessAction.do");
                adapter.authorize(MainActivity.this, Provider.TWITTER);
            }
        });
        ImageView imgLinkedin=(ImageView) findViewById(R.id.linkedin);
        imgLinkedin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
//                adapter.addCallBack(Provider.LINKEDIN,"http://socialauth.in/socialauthdemo");
                adapter.authorize(MainActivity.this, Provider.LINKEDIN);
            }
        });
        
    }
}
