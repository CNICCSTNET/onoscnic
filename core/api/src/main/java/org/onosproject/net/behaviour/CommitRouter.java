package org.onosproject.net.behaviour;

import org.onosproject.net.driver.HandlerBehaviour;

public interface CommitRouter extends HandlerBehaviour {

    public String confirmedCommit() throws Exception;

    public String confirmedCommit(String timeout) throws Exception;

    public String rollBack() throws Exception;

    public String rollBack(String versionNum) throws Exception;
}