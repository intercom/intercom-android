# Android SDK Samples

## Intercom Sample

### Setting Up
This is a sample application to demonstrate how to integrate Intercom in a simple app.
You will need to add your API key and app ID to the SampleApplication
If you have enabled secure mode you will need to provide HMAC and data

If you want to enable GCM in the test app simply provide your sender_id (project number in google-services.json)
in the strings.xml file inside the tag intercom_gcm_sender_id

### Usage
1. Open the app
2. Go to your https://app.intercom.io/a/apps/[YOUR_INTERCOM_APP_ID]/users/segments/active
3. Find user 123456 and send them a message.
4. You will see the unread badge update on the custom launcher and the in app arrive
5. Tap the chat with us button to open the messenger

### Error checking
- Check logcat for any errors, make sure you have no filters turned on. It can help to switch 
  logcat to Verbose.
- Report any issue on Intercom or on our Github repo

## Intercom FCM Sample

### Setting Up
This is a sample application to demonstrate how to integrate Intercom in a simple app.
You will need to add your API key and app ID to the SampleApplication
If you have enabled secure mode you will need to provide HMAC and data

This sample is indented to be used to test FCM integrations. To set up FCM in Intercom you need to:
1. Go to https://firebase.google.com/docs/android/setup#add_firebase_to_your_app follow the steps
   and download the google-services.json file
2. Copy the google-services.json file into the directory [PATH_TO_SAMPLES]/android-sdk-samples/intercom-sample-fcm/app
3  Go to https://console.firebase.google.com/project/[YOUR_GOOGLE_APP]/settings/cloudmessaging
   and copy the Server key.
4. Go to https://app.intercom.io/a/apps/[YOUR_INTERCOM_APP_ID]/settings/android and Enable GCM by adding the
   server key from the previous step.

### Usage
1. Run the FCM sample application.
2. Background the app.
3. Go to your https://app.intercom.io/a/apps/[YOUR_INTERCOM_APP_ID]/users/segments/active
4. Find user 123456 and send them a message.
5. You should receive a push notification to your device.

### Error checking
- Check logcat for any errors, make sure you have no filters turned on. It can help to switch 
  logcat to Verbose.
- Report any issue on Intercom or on our Github repo
