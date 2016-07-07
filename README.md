# Intercom for Android 1.1.21

## Supported versions
Targets Android 2.3 (API 9) but *only* 4.0.3 (API 15) and above have tracking and messaging functionality.

## Set up

A full guide to integrating Intercom for Android with your app is available [here](http://docs.intercom.io/Install-on-your-mobile-product/installing-intercom-for-android)

### Permissions

We include these permissions by default:
```
    <uses-permission android:name="android.permission.INTERNET"/>>
```
[INTERNET](http://developer.android.com/reference/android/Manifest.permission.html#INTERNET) allows us to make network requests.  

You can optionally include these permissions:
```
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.MANAGE_DOCUMENTS"/>
```
[READ_EXTERNAL_STORAGE](http://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE) is used for attachments.
[MANAGE_DOCUMENTS](http://developer.android.com/reference/android/Manifest.permission.html#MANAGE_DOCUMENTS) is used for attachments.

As of 1.1.0 GCM permissions are now included by default in the main package. If you do not wish to use GCM you can use the intercom-sdk-base package, for more details visit http://docs.intercom.io/Install-on-your-mobile-product/installing-intercom-for-android

The GCM permissions are:  
```
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
```

[WAKE_LOCK](http://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK)  
[RECEIVE](https://developer.android.com/google/gcm/client.html#manifest)  

You can optionally include these permissions for GCM:
```
    <uses-permission android:name="android.permission.VIBRATE"/>
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
```
[VIBRATE](http://developer.android.com/reference/android/Manifest.permission.html#VIBRATE) Allows the device to vibrate when a push message is received
[READ_PHONE_STATE](http://developer.android.com/reference/android/Manifest.permission.html#READ_PHONE_STATE) Allows us to generate a device id using TelephonyManager.getDeviceId();  
[ACCESS_WIFI_STATE](http://developer.android.com/reference/android/Manifest.permission.html#ACCESS_WIFI_STATE) Allows us to generate a mac id using WifiInfo.getMacAddress()  

### Dependencies

The gcm module does requires google play services if you're including it manually:
```
compile 'com.google.android.gms:play-services-gcm:8.4.0'
```

The compileSdkVersion needs to be 23.

##How should I use Intercom for Android in my app?
Broadly speaking, there are three types of apps that Intercom for Android will work in.

1. Apps that only have registered users, like Facebook, Instagram or Slack. Your users have to log in straight away in order to use your app. [Show me how.](https://github.com/intercom/intercom-android#my-app-only-has-logged-in-users)
2. Apps that never log users in, like Angry Birds or a flashlight app. Your users never have to log in to use your app. [Show me how.](https://github.com/intercom/intercom-android#my-apps-users-never-log-in)
3. Apps that support both logged in and logged out users, like Google Maps or Youtube. [Show me how.](https://github.com/intercom/intercom-android#my-app-has-logged-in-and-logged-out-users)

### Initialize Intercom
No matter what category of app you have, you'll need your Intercom app id and the Android API key that can be found on the [Intercom App Settings](https://app.intercom.io/) page in the API keys section. Once you've found those keys, initialize Intercom by calling the following in the `onCreate()` method of your application class:

```Java
Intercom.initialize(this, "your api key", "your app id");
```

###My app only has logged in users
1. Firstly, on successful completion of your authentication method in your login activity you will need to register your user.


```
private void successfulLogin(){
	...
	// Registering with Intercom is easy. For best results, use a unique user_id if you have one.
	Intercom.client().registerIdentifiedUser(new Registration().withUserId("123456"));
}
```

**Note:** _If you don't have a unique `userId` to use here, or if you have a `userId` and an `email` you can use `withEmail(String email)` on the Registration object._

2. Also, in your launch activity (or wherever you _check_ your user's authenticated state when your app starts up)

```
// Override point for customization after application launch.
if(loggedIn){
	...
	// We're logged in, we can register the user with Intercom
	Intercom.client().registerIdentifiedUser(new Registration().withUserId("123456"));
	// Carry on as normal
	...
}
```

3. Finally, when users eventually want to log out of your app, we should clear the Intercom library's caches so that when they log back in again, everything works perfectly. In your logout code, simply call `Intercom.client().reset();` like so:

```
private void logout(){
	...
	// This resets the Intercom library's cache of your user's identity and wipes the slate clean.
	Intercom.client().reset();
}
```		


###My apps users never log in

1. If you only have unidentified users in your app then your integration is only one line. Just register an unidentified user in the `onCreate()` method of your application class like so:
```
@Override public void onCreate(){
	super.onCreate();
    Intercom.initialize(this, APP.getApiKey(), APP.getAppId());
    Intercom.client().registerUnidentifiedUser();
}
```


###My app has logged in and logged out users

1. Firstly, on successful completion of your authentication method in your login activity you will need to register your user.

```
private void successfulLogin(){
	...
	// Registering with Intercom is easy. For best results, use a unique user_id if you have one.
	Intercom.client().registerIdentifiedUser(new Registration().withUserId("123456"));
}
```
**Note:** _If you don't have a unique `userId` to use here, or if you have a `userId` and an `email` you can use `withEmail(String email)` on the Registration object._

2. Also, in your launch activity (or wherever you _check_ your user's authenticated state when your app starts up)

```
// Override point for customization after application launch.
if(loggedIn){
	...
	// We're logged in, we can register the user with Intercom
	Intercom.client().registerIdentifiedUser(new Registration().withUserId("123456"));
} else {
	// Since we aren't logged in, we are an unidentified user. Lets register.
	Intercom.client().registerUnidentifiedUser();		
}
```

3. Finally, when users eventually want to log out of your app, we should clear the Intercom library's caches so that when they log back in again, everything works perfectly. In your logout code, simply call `Intercom.client().reset();` like so:
```
private void logout(){
	...
	// This resets the Intercom library's cache of your user's identity and wipes the slate clean.
	Intercom.client().reset();

	// Now that you have logged your user out and reset, you can register a new
	// unidentified user in their place.
	Intercom.client().registerUnidentifiedUser();
}
```

###Tips on getting the best out of Intercom for Android

1. **Do not use an email address as a `userId` as this field is unique and cannot be changed or updated later.** If you only have an email address, you can just register a user with that.
2. **If you register users with an email address, email must be a unique field in your app.** Otherwise we won't know which user to update and the mobile integration won't work.
3. Intercom for Android knows when your app is backgrounded and comes alive again, so all you need to do is register a type of user like the examples above and we'll do the rest.

## How does the in-app messenger work?

Intercom allows you to send messages to your users while also enabling your users send messages to you. If you have a dedicated button in your app that you wish to hook the new message composer up to, you can control Intercom's messaging UI via the `Intercom.client().displayMessageComposer();` and `Intercom.client().displayConversationsList();` methods. More information on messaging with Intercom for Android can be found [here](http://docs.intercom.io/Install-on-your-mobile-product/configuring-intercom-for-android#messaging).

## What about events, push notifications, company and user data?

Intercom for Android has support for all these things. For full details please read our [documentation](http://docs.intercom.io/Install-on-your-mobile-product/configuring-intercom-for-android).

## Documentation and getting started guides

Detailed documentation and getting started guides for:

- Updating a user
- Working with attributes
- Company Data
- Custom Attributes
- Events
- Messaging
- Deep Linking in messages

are available in [our documentation](https://docs.intercom.io/install-on-your-product-or-site/install-intercom-on-your-android-app). Please contact us in Intercom with any questions you may have, we're only a message away!

## Migrating to the latest version of the SDK

Migrating to the latest and greatest versions of the Android SDK shouldn't need to be a daunting prospect. In fact there is only one place that you should need to make changes in order to get the newest SDK versions.

In your app's build.gradle file you can add the following:

    dependencies {
        compile project(':intercom-sdk-base') // Intercom base library
        compile project(':intercom-sdk-gcm') // Intercom messaging services that uses Google cloud messaging
        compile 'com.google.android.gms:play-services-gcm:8.4.0' // Only required if you use GCM
    }

or if you use our bundled dependency updating it to:

    compile ('io.intercom.android:intercom-sdk:1.+@aar') { // Bundled package containing Intercom both base and GCM
        transitive = true
    }

This will ensure you will get the most current version of the SDK when as it is released.

Our Android SDK versions come bundled with some 3rd party dependencies. To ensure you don't run into any version conflicts here is a list of the dependency versions we ship with our latest SDK version:

<table>
  <tr><th colspan="2" style="text-align: center;">Android</th></tr>
  <tr><td style="text-align: center; font-weight: bold; width: 50%;">Library</td><td style="text-align: center; font-weight: bold; width: 50%;">Version</td></tr>
  <tr><td style="width: 50%;">com.google.code.gson</td><td style="width: 50%;">2.5</td></tr>
  <tr><td style="width: 50%;">com.squareup.otto</td><td style="width: 50%;">1.3.7</td></tr>
  <tr><td style="width: 50%;">com.squareup.retrofit</td><td style="width: 50%;">1.9.0</td></tr>
  <tr><td style="width: 50%;">com.squareup.picasso</td><td style="width: 50%;">2.5.2</td></tr>
</table>

### Changing from versions older than Android SDK v1.1.0

Before version 1.1.0 of our Android SDK was released we included Google’s GCM library with our base library in a single bundle called *intercom-sdk*. From version 1.1.0 onward we separated the GCM (*intercom-sdk-gcm*) and base (*intercom-sdk-base*) libraries so that anyone who didn’t need GCM wasn't forced to include it as a dependency. The *intercom-sdk* package reference is still valid for anyone who would like to continue using it.
