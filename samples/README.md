# Android SDK Samples

## Intercom Sample

### Setting Up
This is a sample application to demonstrate how to integrate Intercom in a simple app.
You will need to add your Api Key and App Id to the SampleApplication
You will also need to add either an email or user id (THIS USER WILL BE REGISTERED IN YOUR APP)
If you have enabled secure mode you will need to provide hmac and data
If you want to enable GCM in the test app simply provide your sender_id (project number in google-services.json)
in the strings.xml file inside the tag intercom_gcm_sender_id

### Usage
1. Open the app
2. Tap the register button
3. Tap the chat with us button to open the messenger
4. Send a new message to that user to see the unread badge update on the custom launcher and the in app arrive

### Error checking
- Check logcat for any errors, make sure you have no filters turned on. It can help to switch 
  logcat to Verbose.
- Report any issue on Intercom or on our Github repo