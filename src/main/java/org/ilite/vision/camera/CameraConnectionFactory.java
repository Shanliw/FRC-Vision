package org.ilite.vision.camera;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.ilite.vision.camera.axis.AxisCameraConnection;

public class CameraConnectionFactory {

    private static Map<String, ICameraConnection>mConnections = new ConcurrentHashMap<>();

    public static synchronized ICameraConnection getCameraConnection(String pIP) {
        String key = pIP;
        if(key == null) {
            key = "LOCAL";
        }
        
        ICameraConnection returnedConnection = mConnections.get(key);
        
        if(returnedConnection == null) {
            
            if(key.equals("LOCAL")) {
                returnedConnection = new LocalCamera();
            } else {
                returnedConnection = new AxisCameraConnection(pIP);
            }
            mConnections.put(key, returnedConnection);
            
        }
        
        return returnedConnection;
    }
    
    public static void destroy() {
        for(Entry<String, ICameraConnection>anEntry : mConnections.entrySet()) {
            anEntry.getValue().destroy();
        }
        mConnections.clear();
    }
}
