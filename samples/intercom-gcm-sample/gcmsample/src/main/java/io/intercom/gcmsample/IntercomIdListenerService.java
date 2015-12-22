package io.intercom.gcmsample;

import android.content.Intent;
import com.google.android.gms.iid.InstanceIDListenerService;

public class IntercomIdListenerService extends InstanceIDListenerService {
    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}
