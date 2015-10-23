package vn.mog.app360idsdk.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import vn.mog.app360idsdk.App360IDSDK;
import vn.mog.app360idsdk.App360IdSdkError;
import vn.mog.app360idsdk.SDKApplication;
import vn.mog.app360idsdk.entity.App360User;
import vn.mog.app360idsdk.util.DebugLog;

public class MainActivity extends ActionBarActivity {

    private App360IDSDK app360IDSDK;
    private String clientId="your-client-id";
    private String appSecret ="your-application-secret-key";
    private String scope="basic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app360IDSDK = new App360IDSDK(this);
        app360IDSDK.initialize(clientId, appSecret);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app360IDSDK.login(scope, true, new App360IDSDK.App360IDSDKListener() {
                    @Override
                    public void onSuccess(App360User app360User) {
                        DebugLog.d("getuser success " + app360User.getEmail());
                        Toast.makeText(SDKApplication.getInstance().getApplicationContext(), "getuser success " + app360User.getEmail(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFail(App360IdSdkError error) {
                        DebugLog.d("login app360id get fail cause " + error.getErrorCode());
                        Toast.makeText(SDKApplication.getInstance().getApplicationContext(), "login app360id get fail cause " + error.getErrorCode(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app360IDSDK.logout();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(null != app360IDSDK && app360IDSDK.onActivityResult(requestCode, resultCode, data)){

        }else
            super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        app360IDSDK.onDestroy();
    }
}
