package org.ilite.vision.api.system;

import org.ilite.vision.api.messages.RobotVisionMsg;

/**
 * Interface to connect to a single camera. This will provide users with the ability
 * to register with the camera and receive updates. Implementations of the {@link VisionListener}
 * will be notified when there is a new {@link RobotVisionMsg} available
 *
 */
public interface IVisionSystem {

    /**
     * Method to subscribe for vision updates
     * @param listener
     *  Listener to register
     */
    public void subscribe(VisionListener listener);

    /**
     * Method to unsubscribe for vision updates
     * @param listener
     *  listener to stop registering
     */
    public void unsubscribe(VisionListener listener);
    

}