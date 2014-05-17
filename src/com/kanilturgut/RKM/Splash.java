package com.kanilturgut.RKM;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.kanilturgut.RKM.helpers.AQueryOperation;
import com.kanilturgut.RKM.page_model.SocialNetwork;
import com.kanilturgut.RKM.page_model.Twitter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 15:59
 */
public class Splash extends Activity {

    final String TAG = "Splash";
    Context context = null;

    AQuery aQuery = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.context = this;

        // set AQuery
        aQuery = new AQuery(context);


        //get initial tweet from server
        String url = "http://onurcansert.com:3000/initialTweets";
        aQuery.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>() {

            @Override
            public void callback(String url, JSONArray object, AjaxStatus status) {
                if (object != null) {

                    for (int i = 0; i < object.length(); i++) {

                        try {
                            JSONObject jsonObject = object.getJSONObject(i);
                            SocialNetwork.socialNetworks.add(Twitter.fromJSON(jsonObject));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    //startPubnup();

                } else {
                    //ajax error, show error code
                    Toast.makeText(context, "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}