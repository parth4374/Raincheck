import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.csc340.matb.raincheck.R;
import java.io.File;

/**
 * This is the initial class that maps the buttons on the Starting Screen (Main Activity Page) and
 * assigns Icons, Backgrounds and user messages according to the data received.
 *
 * @author parthpatel
 */

public class Dynamic extends AppCompatActivity {

    //Creating 3 ImageViews for the 3 buttons.
    ImageView settings, location;

    //A bitmap to store the image.
    private Bitmap bmp;

    //Differential static integers.
    private static final int RESULT_LOAD_IMAGE = 1;

    //In case we decide to use camera to for weather inputs.
    private static final int CAMERA_REQUEST = 1888;

    //A brightness variable to adjust brightness on the homepage of the application.
    private ProgressDialog brightness;

    /**
     * A permission method to get access for Read/Write Storage, Internet and Camera on the phone.
     * @param savedInstanceState
     */
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Linking the homepage.xml class.
        setContentView(R.layout.homepage);

        //Asking permission for any Android higher than Android lollipop.
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {Manifest.permission.INTERNET, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

        if (!hasPermissions(Dynamic.this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(Dynamic.this, PERMISSIONS, PERMISSION_ALL);
        }

        //Mapping buttons through findViewById.
        settings = findViewById(R.id.settings);
        location = findViewById(R.id.location);

        //A listener that logs the location button touch on the phone.
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(setContentView(R.layout.locations));
            }
        });

        //A listener that logs the settings button touch on the phone.
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(setContentView(R.layout.settings));
            }
        });

        //Defining a file variable to store the data.
        File file;

        //A click checker variable.
        Boolean click = true;

        //Setting max brightness to 100.
        brightness.setMax(100);


        //Loops setting data from the API class to switch between dynamic backgrounds.
        if(location.data = rain)
            file = rain;
        else if(location.data = snow)
            file = snow;
        else if(location.data = sun)
            file = sun;
        else if(location.data = night)
            file = night;


        //A filler method that fills the homepage background.
        protected void onCreate(Bundle savedInstanceState)RelativeLayout relativeLayout;
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.homepage);

            //A filler function for the background on main screen.
            relativeLayout = (RelativeLayout) findViewById(R.id.fill_vertical);

            //Array of images from drawable folder that will be in the pool for weather conditions.
            images[]  = {R.drawable.rain, R.drawable.snow, R.drawable.sun, R.drawable.night, R.drawable.default};

            //Array of images from drawable folder that will be in the pool for weather icons per conditions.
            icon[] = {R.drawable.umbrella, R.drawable.snowicon, R.drawable.lighticon, R.drawable.breezeicon}
        }

        //A void method for selection of background for the homescreen.
        protected void onResume()
        {
            if(relativeLayout != null)
                relativeLayout.setBackgroundResource(images[R.drawable.default]);

            //Setting Icons and Background if Raining.
            if(data == rain)
                relativeLayout.setBackgroundResource(images[R.drawable.rain]);
                setContentView(findViewById(R.id.message("It is raining, Make sure to carry an umbrealla.")));
                relativeLayout.setBackgroundResource(icon[R.drawable.umbrella]);

            //Setting Icons and Background if Snowing.
            else if(data == snow)
                relativeLayout.setBackgroundResource(images[R.drawable.snow]);
                setContentView(findViewById(R.id.message("It is snowing, Make sure to wear warm clothes.")));
                relativeLayout.setBackgroundResource(icon[R.drawable.snowicon]);

            //Setting Icons and Background if Sunny.
            else if(data == sun)
                relativeLayout.setBackgroundResource(images[R.drawable.sun]);
                setContentView(findViewById(R.id.message("It is sunny outside. Make sure you wear light clothes.")));
                relativeLayout.setBackgroundResource(icon[R.drawable.lighticon]);


            //Setting Icons and Background if Night time.
            else if(data == night)
                relativeLayout.setBackgroundResource(images[R.drawable.night]);
                setContentView(findViewById(R.id.message("It is night time and blissful outside.")));
                relativeLayout.setBackgroundResource(icon[R.drawable.breezeicon]);

        }

        //Setting the temperature data to display on the main screen.
        location.temp = setContentView(R.id.temp;
    }
}