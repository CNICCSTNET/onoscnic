package org.onosproject.cli;


/**
 * Created by zhou on 16-11-5.
 */

public class XmlStructureParserEdit {
    static final String PRE = "edit-config;config;";
    static final String SPLIT = ":";

    public String getXmlStructure(String firstLevel) {
        XmlStructureParser config = new XmlStructureParser();
        String path = null;
        if (firstLevel.indexOf("@") != -1) {
            String[] pathSplit = firstLevel.split("@");
            path = PRE + config.getPath(pathSplit[0]) + "[@name=" + pathSplit[1] + "]";
        } else {
            path = PRE + config.getPath(firstLevel);
        }
        return path;
    }

    public String configAction(String action) {
        XmlStructureParser config = new XmlStructureParser();
        return config.configAction(action, SPLIT);
    }

    public String configPolicerPath(String policerName) {
        XmlStructureParser config = new XmlStructureParser();
        return PRE + config.getPath("policer") + "[@name=" + policerName + "]";
    }

    public String configPolicerTypeAndvalue(String speed, String burstspeed) {
        return "if-exceeding/bandwidth-limit:" + speed + "m;if-exceeding/burst-size-limit:"
                + burstspeed + "k;then/discard:";
    }

    public String configPolicerAction(String policerAction) {
        return policerAction;
    }

    public String configFilterPath(String filterName, String termName) {
        XmlStructureParser config = new XmlStructureParser();
        return PRE + config.getPath("filter") + "[@name="
                + filterName + "];" + "term[@name=" + termName + "]";
    }

    public String configFilterPath(String filterName) {
        XmlStructureParser config = new XmlStructureParser();
        return PRE + config.getPath("filter") + "[@name=" + filterName + "]";
    }

    public String configFilterTypeAndvalue(String ip, String policerName) {
        return "from/source-address/name:" + ip + ";then/policer:" + policerName;
    }

    public String configFilterAction(String filterAction) {
        return filterAction;
    }

    public String configTermPath(String filterName, String termName) {
        XmlStructureParser config = new XmlStructureParser();
        return PRE + config.getPath("filter") + "[@name=" +
                filterName + "];term[@name=" + termName + "]";
    }

    public String configTermTypeAndvalue(String ip, String policerName) {
        return "from/ip:" + ip + ";then/policer:" + policerName;
    }

    public String configTermAction(String termAction) {
        return configAction(termAction);
    }

    public String configInterfacePath(String interfacename, String action) {
        String path = null;
        XmlStructureParser config = new XmlStructureParser();
        if (action.equals("activate")) {
            path = PRE + config.getPath("interface") + "[@name="
                    + interfacename + "];unit[@name=0];family;inet;filter;input";
        } else if (action.equals("deactivate")) {
            path = PRE + config.getPath("interface") + "[@name="
                    + interfacename + "];unit[@name=0];family;inet;filter";
        }
        return path;
    }

    public String configInterfaceTypeAndvalue(String filter) {
        return "filter-name:" + filter;
    }
}
