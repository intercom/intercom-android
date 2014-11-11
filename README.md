# Android SDK 0.0.9 BETA

Currently in development. If you would like an invite to the Beta please contact me at gavin@intercom.io.

## Supported versions
Supports Android 2.3 (API 9) and above


## Set up
### aar
- Add the intercomsdk-0.0.9.aar to the libs directory of your project
- In the apps build.gradle add the following:
```Java
repositories {
    flatDir {
        dirs 'libs'
    }
}
dependencies {
    compile(name:'intercomsdk-0.0.9', ext:'aar')
}
```

### gradle+maven


```Java
repositories {
   maven {
       url 'http://dl.bintray.com/intercom/intercom-maven'
   }
}
dependencies {
   compile('io.intercom:intercom.intercomsdk:0.0.+@aar') {
       transitive = true;
   }
}
```

## Getting started
- Get the Intercom App Id and the SDK API key from `https://app.intercom.io/apps/<your_app_id>/sdk_apps`
- Initialize Intercom by calling `setApiKey(<your_api_key> ,<your_app_id> , <current_context>);` 
- Start a session by calling `beginSessionWithEmail(<your_email_here>, <current_context>, null);`, `beginSessionWithUserId(<your_userid_here>, <current_context>, null);` or `beginSessionForAnonymousUser(<current_context>, null);`
- Optionally you may also begin a session with an eventlister to inform you if and when a session is ready. The eventlistener may be used to kick off any user updates or event tracking that you require to do immediately after a session has started.
```Java
        intercom.beginSessionWithEmail(<your_email_here>, <current_context>, new Intercom.IntercomEventListener() {
            @Override
            public void onComplete(String error) {
                // lets check if we get an error string
                if(error != null) {
                    // handle error here
                } else {
                    // do success logic here
                    // You can also do an user updates / event tracking from here as you are sure that the session has started at this point
                }
            }
        });
```
- End a session when your user successfully logs out of your application by adding
    `intercom.endSession()`

## Updating a user

You can send any data you like to Intercom. Typically our customers see a lot of value in sending data that relates to customer development, such as price plan, value of purchases, etc. Once these have been sent to Intercom you can then apply filters based on these attributes.

You can use the following Intercom class method to update fields in the user profile.

`intercom.updateUser (HashMap<String, Object> attributes)` Where attibutes is a HashMap containing a user attributes for example email, companies, custom attributes. Note that multiple attibutes can be updated at once.

You do not have to create attributes in Intercom beforehand. If one hasn't been seen before, it will be created for you automatically. A detailed description of the user model is available here http://doc.intercom.io/api/#user-model

## Custom attributes
You can add and update custom data about your user by adding a Hashmap with the key “custom_attributes” to the attribute Hashmap. Examples of custom data below are if the user is a paid subscriber, how much do they spend per month and how many people do they have on their team. Objects and arrays are not allowed in custom data. See the following example:
```Java   
    HashMap<String, Object> attributes = new HashMap<String,Object>();
    HashMap<String, Object> customAttributes = new HashMap<String,Object>();
    customAttributes.put("paid_subscriber","Yes");
    customAttributes.put("monthly_spend",155.5);
    customAttributes.put("team_mates",3);
    attributes.put("custom_attributes", customAttributes);
    intercom.updateUser(attributes);
```

## Company data
You can add and update a user’s company data by adding a Hashmap with the key “companies” to the attribute dictionary. Each company requires an id to be present in the dictionary. See the following example:

```Java   
    HashMap<String, Object> attributes = new HashMap<String,Object>();
    HashMap<String, Object> companyData = new HashMap<String,Object>();
    companyData.put("name","Intercom");
    companyData.put("id",1234);
    attributes.put("companies", companyData);
    intercom.updateUser(attributes);
```

## Events
You can log events in Intercom based on user actions in your app. Events are different to Custom Attributes in that events are information on what Users did and when they did it, whereas Custom Attributes represent the User’s current state as seen in their profile.
```Java  
    intercom.logEvent(”sent_invitation”);
    HashMap<String, Object> eventData = new HashMap<String,Object>();
    intercom.logEvent(”sent_invitation”, eventData)]; //HashMap of additional data for the event
```

## Security
- You may also use HMAC for additional security when initializing Intercom by calling `setApiKey(<your_api_key>, <your_app_id>, String data, String hmac, this)` Where data is a string representing the data that was signed by the App Server and hmac is the HMAC digest for the data string

## License
Copyright 2014 Intercom, Inc.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
