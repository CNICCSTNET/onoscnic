package org.onosproject.cli.net;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.cli.XmlStructureParserEdit;
import org.onosproject.net.DeviceId;
import org.onosproject.net.behaviour.SpeedLimit;
import org.onosproject.net.driver.DriverHandler;
import org.onosproject.net.driver.DriverService;

/**
 * Created by zhou on 16-11-10.
 *
 * Command that set the speed limit term to a device
 *
 * This is a temporary development tool for use until yang integration is complete.
 * This uses a not properly specified behavior. DO NOT USE AS AN EXAMPLE.
 */

@Command(scope = "onos", name = "filter-interface",
        description = "Activate or deactivate filter" +
                "Example:" +
                "filter-interface netconf:159.226.101.32:830 both activate fe-0/0/0 testNewFilter" +
                "filter-interface netconf:159.226.101.32:830 deactivate fe-0/0/0 testNewFilter")
public class SetFilterToInterfaceCommand extends AbstractShellCommand {
    @Argument(index = 0, name = "uri", description = "Device ID",
            required = true, multiValued = false)
    String uri = null;
    @Argument(index = 1, name = "type", description = "activate or deactivate",
            required = true, multiValued = false)
    String type = null;
    @Argument(index = 2, name = "inout", description = "Set the input or output filter or both",
            required = true, multiValued = false)
    String inout = null;
    @Argument(index = 3, name = "interface", description = "Name of the interface",
            required = true, multiValued = false)
    String interfacename = null;
    @Argument(index = 4, name = "filter", description = "Name of the filter",
            required = true, multiValued = false)
    String filter = null;
    private DeviceId deviceId;

    @Override
    protected void execute() {
        DriverService service = get(DriverService.class);
        deviceId = DeviceId.deviceId(uri);
        DriverHandler h = service.createHandler(deviceId);
        SpeedLimit config = h.behaviour(SpeedLimit.class);
        XmlStructureParserEdit parser = new XmlStructureParserEdit();
        String path1 = null, path2 = null, typeAndValue = null, action = null;
        if (type.equals("activate")) {
            if (inout.equals("input")) {
                path1 = parser.configInterfacePath(interfacename, type, "input");
            }
            if (inout.equals("output")) {
                path1 = parser.configInterfacePath(interfacename, type, "output");
            }
            if (inout.equals("both")) {
                path1 = parser.configInterfacePath(interfacename, type, "input");
                path2 = parser.configInterfacePath(interfacename, type, "output");
            }
            typeAndValue = parser.configInterfaceTypeAndvalue(filter);
        } else if (type.equals("deactivate")) {
            path1 = parser.configInterfacePath(interfacename, type, null);
            action = parser.configAction("delete");
        }
        if (inout.equals("both")) {
            print(config.setSpeedLimit(path1, typeAndValue, action));
            print(config.setSpeedLimit(path2, typeAndValue, action));
        } else {
            print(config.setSpeedLimit(path1, typeAndValue, action));
        }

    }
}
