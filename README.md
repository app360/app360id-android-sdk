#Introduction

App360ID SDK helps you build engaging social apps and get more installs

The App360ID iOS SDK supports iOS version 6.0 and above.

#Requirements

##Development Environment

| App360IDSDK Version | Minimum Android Target | 				Notes 			|
|:-----------------:|:------------------:|:----------------------------:|
|1.0.0|9||

#Getting started with Demo project

Firstly, clone or download this repository to your machine.

- `git clone https://github.com/app360/app360id-android-sdk.git`
- Or, download from https://github.com/app360/app360id-android-sdk/releases

Open build.gradle inside demo project, find `initializeWithApplicationId` line and replace the placeholders with your application credentials.

Run the project. The app demonstrates capability of App360ID SDK.

#Setup your project

##Application Id & Client key

To using any function of App360SDK, you need to configure application id and secret. SDK uses this pair of key to authorize your app (game) with SDK's server. To retrieve application ID and client secret, register your application on https://developers.app360.vn/; your application ID and secret is available in application details page, Information tab.

![App credentials](http://i.imgur.com/4xZ8fYc.png)

##Redirect

To handle login flow, the project's directory should contain a properties file named `app360.properties` and put it into assets folder. The file should contain `redirect_uri`. `redirect_uri` can be configure on App360 Developer. You can find it in application detail page, Information tab, OAuth2 section (OAuth2 Redirect URIs)

#Integrate SDK into your project
Set your appplication extends SDKApplication 
Put jar realease to libs folder 

##Initialize
```java
App360IDSDK app360IDSDK = new App360IDSDK(this);
app360IDSDK.initial(clientId, appScret);
```

##Login

```java
app360IDSDK.login(scope, false, new App360IDSDK.WebViewSDKListener() {
        @Override
        public void onSuccess(App360User app360User){
           Toast.makeText(SDKApplication.getInstance().getApplicationContext(), "getuser success " + app360User.getEmail(), Toast.LENGTH_SHORT).show();
        }

         @Override
        public void onFail(App360IdSdkError error) {
            Toast.makeText(SDKApplication.getInstance().getApplicationContext(), "login app360id get fail cause " + error.getErrorCode(), Toast.LENGTH_SHORT).show();
        }
});
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

**How much does the App360ID Android SDK add to my application size?**

The latest version of the SDK weighs less than 1MB. But this isn't the size which will be added to your archive when submitted to iTunes.
Based on several tests, it should adds below 1MB depending of the size of your application.
The bigger your app is, the less the App360ID Android SDK will have an impact on the final size.

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
