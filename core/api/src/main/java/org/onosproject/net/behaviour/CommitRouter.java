package org.onosproject.net.behaviour;

import org.onosproject.net.driver.HandlerBehaviour;

public interface CommitRouter extends HandlerBehaviour {

    public String confirmedCommit();

    public String confirmedCommit(String timeout) throws Exception;

    public String rollBack();

    public String rollBack(String versionNum) throws Exception;
}