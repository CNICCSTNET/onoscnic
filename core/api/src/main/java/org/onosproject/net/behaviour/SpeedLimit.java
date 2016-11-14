package org.onosproject.net.behaviour;

import org.onosproject.net.driver.HandlerBehaviour;

/**
 * Behaviour that sets speed limit on the device.
 *
 */

public interface SpeedLimit extends HandlerBehaviour {

    public String speedLimit(String path, String typeAndValue, String action);

    /**
     *Set the speed limit term to the device.
     */
    public String setSpeedLimit(String path, String typeAndValue, String action);

    /**
     *Delete the speed limit term to the device.
     */
    public String deleteSpeedLimit(String path, String typeAndValue, String action);

    /**
     *Activate the speed limit term on a special port.
     */
    public String activateSpeedLimit(String path, String typeAndValue, String action);

    /**
     *Deactivate the speed limit term on a special port.
     */
    public String deactivateSpeedLimit(String path, String typeAndValue, String action);

}
