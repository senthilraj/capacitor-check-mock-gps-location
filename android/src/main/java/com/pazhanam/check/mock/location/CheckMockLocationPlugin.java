package com.pazhanam.check.mock.location;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.content.Context;
import android.util.Log;
import android.location.Location;
import android.location.LocationManager;

@CapacitorPlugin(name = "CheckMockLocation")
public class CheckMockLocationPlugin extends Plugin {



     @PluginMethod()
    public void isMocked(PluginCall call) {
        JSObject ret = new JSObject();
        boolean isMock = false;
        try {
            isMock = isMockLocation(getContext());
        }catch (Exception e){
            Log.e("isMockLocation","isMockLocation: "+e);
        }
        ret.put("value", isMock);
        call.resolve(ret);
    }


    public static boolean isMockLocation(Context context) {
        boolean isMock = false;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 31) {
                Log.i("isMockLocation", "VERSION.SDK_INT >= 31");
                LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location!= null) {
                    isMock = location.isMock();
                    if(isMock){
                        Log.i("isMockLocation", "isMocked=true: func isMock()");
                    }
                }
            } else if (android.os.Build.VERSION.SDK_INT >= 18) {
                Log.i("isMockLocation", "VERSION.SDK_INT >= 18");
                LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location!= null) {
                    isMock = location.isFromMockProvider();
                    if(isMock){
                        Log.i("isMockLocation", "isMocked=true: func isFromMockProvider()");
                    }
                }
            }
        }catch (Exception e){
            Log.e("error","isMockLocation: "+e);
        }
        return isMock;
    }
}
