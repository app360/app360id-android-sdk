#Introduction

App360ID SDK helps you build engaging social apps and get more installs

The App360ID Android SDK supports Android 2.3 and above.

#Requirements

##Development Environment

| App360IDSDK Version | Minimum Android Target | 				Notes 			|
|:-----------------:|:------------------:|:----------------------------:|
|1.0.0|9||

#Getting started with Demo project

Firstly, clone or download this repository to your machine.

- `git clone https://github.com/app360/app360id-android-sdk.git`
- `Or, download from https://github.com/app360/app360id-android-sdk/releases`

Open build.gradle inside demo project, find `MainActivity` class in demo module and modify `clientId`,`appSecret` with your application credentials.

Run `myapplication` module.

#Setup your project

##Application Id & Client key

To using any function of App360SDK, you need to configure application id and secret. SDK uses this pair of key to authorize your app (game) with SDK's server. To retrieve application ID and client secret, register your application on https://developers.app360.vn/; your application ID and secret is available in application details page, Information tab.

![App credentials](http://i.imgur.com/4xZ8fYc.png)

##Redirect

To handle login flow, the project's directory should contain a properties file named `app360.properties` and put it into assets folder. The file should contain `redirect_uri`. `redirect_uri` can be configure on App360 Developer. You can find it in application detail page, Information tab, OAuth2 section (OAuth2 Redirect URIs)

#Integrate SDK into your project

Put app360idsk.jar,gson-2.3.1.jar, volley-1.0.15.jar to libs folder . If you use android studio ,  right click it and choose `add as library`
Add `app360.properties` to `assets` folder :
```
redirect_uri=http://example.com
```
Set your application extends SDKApplication and add `vn.mog.openidsdk.activity.WebViewAtivity` to your manifest:
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="vn.mog.openidsdk.demo" >

    <uses-permission android:name="android.permission.INTERNET"/>
    <application
        android:name="vn.mog.app360idsdk.SDKApplication"
        ....
         >
        ....
        <activity android:name="vn.mog.app360idsdk.activity.LoginActivity"
            />
    </application>

</manifest>
```

##Initialize
```java
/**
*Initialize SDK
* @param appId application id
* @param appSecret application secret key
*/
public void initialize(String appId,String appSecret)
```

For example:

```java
App360IDSDK app360IDSDK = new App360IDSDK(context);
app360IDSDK.initialize(clientId, appScret);
```

##Login
```java
/**
 * execute login follow : if session valid then call {@link #getUserInfo(String)}, or start  {@link vn.mog.openidsdk.activity.WebViewAtivity} activity
 * @param scope                 Scope (permission) want to access
 * @param shouldDisplayUI       Should SDK show form for user login.
 * @param app360IDSDKListener   callback
 */
 public void login(String scope,boolean shouldDisplayUI,App360IDSDKListener app360IDSDKListener)
```

For example:
```java
app360IDSDK.login(scope, true, new App360IDSDK.App360IDSDKListener() {
         @Override
         public void onSuccess(App360User app360User{
              Toast.makeText(SDKApplication.getInstance().getApplicationContext(), "getuser success " + app360User.getEmail(), Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onFail(App360IdSdkError error) {
              Toast.makeText(SDKApplication.getInstance().getApplicationContext(), "login app360id get fail cause " + error.getErrorCode(), Toast.LENGTH_SHORT).show();
         }
});
```

##Logout
```java
/**
 * Clear all sdk session.
 */
 public void logout()
```

For example:
```java
app360IDSDK.logout();
```


#Release Notes

##Version 1.0.0

**Release date**: 09 Apr 2015

 - Initial version

#Known Issues

There's no known issues for now

#FAQ

**What is a application id and client key?**

They are a pair of key, used to authorize your app (game) with SDK's server.

**How can i get my application id and client key?**

1. Goto https://developers.app360.vn
2. Login if you already have an account or register a new one
3. Open your application in App360 dashboard, select Information tab
4. All key you need will be there

#Support
Please contact [us](mailto:support@app360.vn) for general inquiries.

##For a technical issue
In case you have a technical issue, you can reach [our technical support team](mailto:support@app360.vn).
Please provide the following information when you reach out, it'll allow us to help you much more quickly.

 - **The library version** you're using. You can get the precise number by
   printing the result of the `App360IDSDK.getSDKVersion` method.
 - **The platform** used to produce the problem (device model or emulator),
   and the android version.
 - **The steps** to reproduce the problem.
 - If possible, **some pieces of code**, or even a project.

> For more information, please go to https://developers.app360.vn.