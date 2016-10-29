# Intercom for Android

## Install

In your app's `build.gradle` file add the following block to your repositories block:

```
repositories {
  maven {
    url 'https://dl.bintray.com/intercom/intercom-maven'
  }
}
```

Then add the following dependency to your `build.gradle` file:

```gradle
compile 'io.intercom.android:intercom-sdk:3.+'
```
That includes the base Intercom module including GCM. 
If you want to use Intercom FCM replace the line above with the following:

```gradle
compile 'io.intercom.android:intercom-sdk-base:3.+'
compile 'io.intercom.android:intercom-sdk-fcm:3.+'
```

If you are not using Intercom push notifications you can just use:

```gradle
compile 'io.intercom.android:intercom-sdk-base:3.+'
```

`.aar` files are also included in this repo if you want to use them instead. If so then you will need to include GCM or FCM dependencies in your `build.gradle` file.

GCM:
```gradle
compile 'com.google.android.gms:play-services-gcm:9.4.0'
```
FCM:
```gradle
compile 'com.google.firebase:firebase-messaging:9.4.0'
```

## Upgrading from 1.x.x
If you are upgrading from an older version of our Messenger you may need to change some of the methods you used to call. You can see any changes you may need to make [here](https://docs.intercom.io/messenger-v3/upgrade-to-the-new-messenger-android).

## Set up

A full guide to integrating Intercom for Android with your app is available [here](http://docs.intercom.io/Install-on-your-mobile-product/installing-intercom-for-android). 
We support API 15 (4.0.3) and above, and we recommend you use a `compileSdkVersion` of 24.


##How should I use Intercom for Android in my app?
Broadly speaking, there are three types of apps that Intercom for Android will work in.

1. Apps that only have registered users, like Facebook, Instagram or Slack. Your users have to log in straight away in order to use your app. [Show me how.](https://github.com/intercom/intercom-android#my-app-only-has-logged-in-users)
2. Apps that never log users in, like Angry Birds or a flashlight app. Your users never have to log in to use your app. [Show me how.](https://github.com/intercom/intercom-android#my-apps-users-never-log-in)
3. Apps that support both logged in and logged out users, like Google Maps or Youtube. [Show me how.](https://github.com/intercom/intercom-android#my-app-has-logged-in-and-logged-out-users)

### Initialize Intercom
No matter what category of app you have, you'll need your Intercom app id and the Android API key that can be found on the [Intercom App Settings](https://app.intercom.io/) page in the API keys section. Once you've found those keys, initialize Intercom by calling the following in the `oncreate()` method of your application class:

```java
Intercom.initialize(this, "your api key", "your app id");
```

###My app only has logged in users
1. Firstly, on successful completion of your authentication method in your login activity you will need to register your user.

	```java
	private void successfulLogin() {
		...
		// Registering with Intercom is easy. For best results, use a unique user_id if you have one.
		Intercom.client().registerIdentifiedUser(Registration.create().withUserId("123456"));
	}
	```

	**Note:** _If you don't have a unique `userId` to use here, or if you have a `userId` and an `email` you can use `withEmail(String email)` on the Registration object._

2. Also, in your launch activity (or wherever you _check_ your user's authenticated state when your app starts up)

	```java
	// Override point for customization after application launch.
	if (loggedIn) {
		...
		// We're logged in, we can register the user with Intercom.
		Intercom.client().registerIdentifiedUser(Registration.create().withUserId("123456"));
		// Carry on as normal.
		...
	}
	```

3. Finally, when users eventually want to log out of your app, we should clear the Intercom library's caches so that when they log back in again, everything works perfectly. In your logout code, simply call `Intercom.client().reset();` like so:

	```java
	private void logout() {
		...
		// This resets the Intercom library's cache of your user's identity and wipes the slate clean.
		Intercom.client().reset();
	}
	```		


###My apps users never log in

1. If you only have unidentified users in your app then your integration is only one line. Just register an unidentified user in the `onCreate()` method of your application class like so:

	```java
	@Override public void onCreate() {
		super.onCreate();
		Intercom.initialize(this, APP.getApiKey(), APP.getAppId());
		Intercom.client().registerUnidentifiedUser();
	}
	```


###My app has logged in and logged out users

1. Firstly, on successful completion of your authentication method in your login activity you will need to register your user.

	```java
	private void successfulLogin() {
		...
		// Registering with Intercom is easy. For best results, use a unique user_id if you have one.
		Intercom.client().registerIdentifiedUser(Registration.create().withUserId("123456"));
	}
	```
	**Note:** _If you don't have a unique `userId` to use here, or if you have a `userId` and an `email` you can use `withEmail(String email)` on the Registration object._

2. Also, in your launch activity (or wherever you _check_ your user's authenticated state when your app starts up)

	```java
	// Override point for customization after application launch.
	if (loggedIn) {
		...
		// We're logged in, we can register the user with Intercom.
		Intercom.client().registerIdentifiedUser(Registration.create().withUserId("123456"));
	} else {
		// Since we aren't logged in, we are an unidentified user. Lets register.
		Intercom.client().registerUnidentifiedUser();		
	}
	```

3. Finally, when users eventually want to log out of your app, we should clear the Intercom library's caches so that when they log back in again, everything works perfectly. In your logout code, simply call `Intercom.client().reset();` like so:

	```java
	private void logout() {
		...
		// This resets the Intercom library's cache of your user's identity and wipes the slate clean.
		Intercom.client().reset();
	
		// Now that you have logged your user out and reset, you can register a new
		// unidentified user in their place.
		Intercom.client().registerUnidentifiedUser();
	}
	```

### Tips on getting the best out of Intercom for Android

1. **Do not use an email address as a `userId` as this field is unique and cannot be changed or updated later.** If you only have an email address, you can just register a user with that.
2. **If you register users with an email address, email must be a unique field in your app.** Otherwise we won't know which user to update and the mobile integration won't work.
3. Intercom for Android knows when your app is backgrounded and comes alive again, so all you need to do is register a type of user like the examples above and we'll do the rest.

## How does the in-app messenger work?

Intercom allows you to send messages to your users while also enabling your users send messages to you. If you want to have a dedicated UI element in your app which opens the messenger, you can display it by calling `Intercom.client().displayMessenger()`. You can also pass in a string to pre-populate the message composer for example: `Intercom.client().displayMessageComposer("Write your message here: ");`

More information on messaging with Intercom for Android can be found [here](http://docs.intercom.io/Install-on-your-mobile-product/configuring-intercom-for-android#messaging).

### What about events, push notifications, company and user data?

Intercom for Android has support for all these things. For full details please read our [documentation](http://docs.intercom.io/Install-on-your-mobile-product/configuring-intercom-for-android).


## Permissions

We include the [INTERNET](http://developer.android.com/reference/android/Manifest.permission.html#INTERNET) permission by default as we need it to make network requests:

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```  

Optional permissions:

```xml
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.MANAGE_DOCUMENTS"/>
```

[READ\_EXTERNAL\_STORAGE](http://developer.android.com/reference/android/Manifest.permission.html#READ_EXTERNAL_STORAGE) and [MANAGE_DOCUMENTS](http://developer.android.com/reference/android/Manifest.permission.html#MANAGE_DOCUMENTS) are used for attachments.

The necessary GCM permissions ([WAKE_LOCK](http://developer.android.com/reference/android/Manifest.permission.html#WAKE_LOCK) and [RECEIVE](https://developer.android.com/google/gcm/client.html#manifest)) are also included by default in the main package.

```xml
<uses-permission android:name="android.permission.WAKE_LOCK" />
<uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
```

You can also include [VIBRATE](http://developer.android.com/reference/android/Manifest.permission.html#VIBRATE) to enable vibration in push notifications:

```xml
<uses-permission android:name="android.permission.VIBRATE"/>
```

## Documentation

Detailed guides for:

- Updating a user
- Working with attributes
- Company Data
- Custom Attributes
- Events
- Messaging
- Deep Linking in messages

are available in [our documentation](https://docs.intercom.io/install-on-your-product-or-site/quick-install/install-intercom-on-your-android-app). Please contact us through Intercom with any questions you may have, we're only a message away!

## Cordova/Phonegap Support
Looking for Cordova/Phonegap support? We have a [Cordova Plugin](https://github.com/intercom/intercom-cordova) for Intercom 🎉

## Changing from versions older than Android SDK v1.1.0

Before version 1.1.0 of our Android SDK was released we included Google’s GCM library with our base library in a single bundle called *intercom-sdk*. From version 1.1.0 onward we separated the GCM (*intercom-sdk-gcm*) and base (*intercom-sdk-base*) libraries so that anyone who didn’t need GCM wasn't forced to include it as a dependency. The *intercom-sdk* package reference is still valid for anyone who would like to continue using it.

## Dependency graph

Here is our complete dependency graph:

intercom-sdk-base
```
# Transitive (shared with your app)
+--- com.android.support:design:24.2.0
+--- com.android.support:appcompat-v7:24.2.0
+--- com.android.support:animated-vector-drawable:24.2.0
+--- com.android.support:support-vector-drawable:24.2.0
+--- com.android.support:support-v4:24.2.0
+--- com.android.support:support-annotations:24.2.0
+--- com.android.support:recyclerview-v7:24.2.0

# Repackaged (not shared with your app)
+--- com.facebook.rebound:rebound:0.3.8
+--- com.squareup:otto:1.3.8
+--- com.github.bumptech.glide:glide-intercom:3.7.0 # Modified version of Glide
+--- com.squareup.okio:okio:1.9.0
+--- com.squareup.okhttp3:okhttp:3.4.1
+--- com.squareup.okhttp3:okhttp-ws:3.4.1
+--- com.squareup.retrofit2:retrofit:2.1.0
+--- com.squareup.retrofit2:converter-gson:2.1.0
+--- com.google.code.gson:gson:2.7
```

If you use some of the repackaged libraries in your app, you may want to use a build that depends on them transitively. A guide to using this build can be found [here](https://docs.intercom.com/configure-intercom-for-your-product-or-site/configure-intercom-for-mobile/using-transitive-dependencies-with-intercom-for-android). Using this build involves more work as you need to make sure your app uses the correct version of each library.

intercom-sdk-gcm
```
+--- com.google.android.gms:play-services-base:9.4.0
|    +--- com.google.android.gms:play-services-basement:9.4.0
|    |    \--- com.android.support:support-v4:23.0.0 -> 24.2.0 (*)
|    \--- com.google.android.gms:play-services-tasks:9.4.0
|         \--- com.google.android.gms:play-services-basement:9.4.0 (*)
+--- com.google.android.gms:play-services-basement:9.4.0 (*)
\--- com.google.android.gms:play-services-iid:9.4.0
     +--- com.google.android.gms:play-services-base:9.4.0 (*)
     \--- com.google.android.gms:play-services-basement:9.4.0 (*)
```

intercom-sdk-fcm
```
+--- com.google.android.gms:play-services-basement:9.4.0
|    \--- com.android.support:support-v4:23.0.0 -> 24.2.0 (*)
+--- com.google.firebase:firebase-iid:9.4.0
|    +--- com.google.android.gms:play-services-basement:9.4.0 (*)
|    \--- com.google.firebase:firebase-common:9.4.0
|         +--- com.google.android.gms:play-services-basement:9.4.0 (*)
|         \--- com.google.android.gms:play-services-tasks:9.4.0
|              \--- com.google.android.gms:play-services-basement:9.4.0 (*)
\--- com.google.firebase:firebase-common:9.4.0 (*)
```
