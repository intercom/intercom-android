# android-sdk-samples
Sample integrations of the Android SDK  
This contains sample apps of ways to integrate and test the integration of the Android SDK

## Android Studio sample app
### Setting Up
This is a sample application to help with Intercom integration in Android Studio apps
You will need to visit https://developers.google.com/cloud-messaging/android/client to download your configuration file. Use the following 'io.intercom.gcmsample' as the package name and then copy the file into gcmsample directory.
You will need to add your Api Key, App Id in the SampleApplication file
You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
If you have enabled secure mode you will need to provide hmac and data
### Usage
 1. Open the app
 2. Tap the register button
 3. Tap the intercom button on the top right to see the inbox or be brought to compose a new message
### Error checking
Make sure you have no filters on and search using Intercom-Android

## Eclipse sample app
### Setting Up
This is a sample application to help with Intercom Android Eclispe setup
You will need to add your Api Key to the SampleApplication
You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
### Usage
 1. Open the app
 2. Tap the Open Intercom button to open up the SDK

## GCM sample app
### Setting Up
This is a sample application to help with Intercom Android GCM setup  
You will need to add your Api Key, App Id, and GCM sender Id  
You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)  
If you have enabled secure mode you will need to provide hmac and data  
### Usage
 1. Open the app on a gcm enabled device (no simulators/emulators without google play services)  
 2. Tap the register button  
 3. Wait for register button to turn grey and GCM Status should say Registered  
 4. Tap the Intercom logo on the top right to open the In App Messenger  
 5. If the session is working you should see your inbox  

### Error checking
Make sure you have no filters on and search using GCM_ISSUE  
Report any issue on Intercom or on our Github repo  
