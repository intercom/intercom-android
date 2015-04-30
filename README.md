# Android SDK 0.9.6 BETA

Our Android SDK is now in public beta. We are confident of its stability, however please be aware there is still some risk. As it's in beta, we may release frequent, small updates. We'll attempt to keep these updates as easy as possible, though they may require you to update the integration in your app.

## Supported versions
Supports Android 2.3 (API 9) for data only calls and 4.0.3 (API 15) and above for the messaging functionality

## Set up

A full guide to integrating the Intercom Android SDK with your app is available [here](http://docs.intercom.io/6025-Install-on-your-mobile-product/install-the-intercom-android-sdk)

### permissions

We include two permissions by default:
```
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
```
[INTERNET](http://developer.android.com/reference/android/Manifest.permission.html#INTERNET) Allows us to make network requests.  
[SYSTEM_ALERT_WINDOW](http://developer.android.com/reference/android/Manifest.permission.html#SYSTEM_ALERT_WINDOW) Used to draw the Android SDK ontop of the host application

As of 0.9.6 GCM permissions are now the responsibility of the host application.

```
    <!-- GCM REQUIRED PERMISSIONS -->
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
    <uses-permission android:name="android.permission.VIBRATE"/>
    <!-- GCM Optional PERMISSIONS -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
```
The required permissions are:  
[WAKE_LOCK](http://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK)  
[RECEIVE](https://developer.android.com/google/gcm/client.html#manifest)  
[VIBRATE](http://developer.android.com/reference/android/Manifest.permission.html#VIBRATE)  

Optional permissions are used to generate a more reliable device id. They are:  
[READ_PHONE_STATE](http://developer.android.com/reference/android/Manifest.permission.html#READ_PHONE_STATE) Allows us to generate a device id using TelephonyManager.getDeviceId();  
[ACCESS_WIFI_STATE](http://developer.android.com/reference/android/Manifest.permission.html#ACCESS_WIFI_STATE) Allows us to generate a mac id using WifiInfo.getMacAddress()  

### remote dependency

- These are the dependencies we use in the SDK

```
compile 'com.android.support:support-v4:22.0.0'
compile 'com.google.code.gson:gson:2.3'
compile 'com.squareup:otto:1.3.6'
compile 'com.squareup.okhttp:okhttp:2.3.0'
compile 'com.squareup.okhttp:okhttp-ws:2.3.0'
compile 'com.squareup.retrofit:retrofit:1.9.0'
compile 'com.squareup.picasso:picasso:2.5.2'
compile 'com.google.android.gms:play-services-gcm:7.0.0’
```

also the compileSdkVersion needs to be 22.

##How should I use the Intercom SDK in my app?
Broadly speaking, there are three types of apps that the Intercom SDK will work in.

1. Apps that only have registered users, like Facebook, Instagram or Slack. Your users have to log in straight away in order to use your app. [Show me how.](https://github.com/intercom/intercom-android#my-app-only-has-logged-in-users)
2. Apps that never log users in, like Angry Birds or a flashlight app. Your users never have to log in to use your app. [Show me how.](https://github.com/intercom/intercom-android#my-apps-users-never-log-in)
3. Apps that support both logged in and logged out users, like Google Maps or Youtube. [Show me how.](https://github.com/intercom/intercom-android#my-app-has-logged-in-and-logged-out-users)

### Initialize Intercom
No matter what category of app you have, you'll need your Intercom app id and the Android SDK API key that can be found on the [Intercom App Settings](https://app.intercom.io/) page in the API keys section. Once you've found those keys, initialize Intercom by calling the following in the `oncreate()` method of your application class:

```Java
Intercom.initialize(getApplicationContext(), "your api key", "your app id");
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
		
3. Finally, when users eventually want to log out of your app, we should clear the Intercom SDK's caches so that when they log back in again, everything works perfectly. In your logout code, simply call `Intercom.client().reset();` like so:

```
private void logout(){
	...
	// This resets the Intercom SDK's cache of your user's identity and wipes the slate clean.
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
		
3. Finally, when users eventually want to log out of your app, we should clear the Intercom SDK's caches so that when they log back in again, everything works perfectly. In your logout code, simply call `Intercom.client().reset();` like so:
```
private void logout(){
	...
	// This resets the Intercom SDK's cache of your user's identity and wipes the slate clean.
	Intercom.client().reset();

	// Now that you have logged your user out and reset, you can register a new
	// unidentified user in their place.
	Intercom.client().registerUnidentifiedUser();
}
```	

###Tips on getting the best out of the SDK

1.  **Do not use an email address as a `userId` as this field is unique and cannot be changed or updated later.** If you only have an `email` address, you can just register a user with that. 
2. The Intercom SDK knows when your app is backgrounded and comes alive again, so all you need to do is register a type of user like the examples above and we'll do the rest.
 
## How does the in-app messenger work?

Intercom allows you to send messages to your users while also enabling your users send messages to you. If you have a dedicated button in your app that you wish to hook the new message composer up to, you can control Intercom's messaging UI via the `Intercom.client().dislplayMessageComposer();` and `Intercom.client().displayConversationList();` methods. More information on messaging with the Android SDK can be found [here](http://docs.intercom.io/using-the-android-sdk#messaging).

## What about events, push notifications, company and user data?

The Android SDK has support for all these things. For full details please read our [documentation](http://docs.intercom.io/using-the-android-sdk).
 
## Documentation and getting started guides
 
Detailed documentation and getting started guides for:

- Updating a user
- Working with attributes
- Company Data
- Custom Attributes
- Events
- Messaging
- Deep Linking in messages

are available in [our documentation](http://docs.intercom.io/Install-on-your-mobile-product). Please contact us in Intercom with any questions you may have, we're only a message away!
