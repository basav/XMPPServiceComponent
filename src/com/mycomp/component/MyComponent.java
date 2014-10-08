package com.mycomp.component;

import org.xmpp.component.Component;
import org.xmpp.component.ComponentManager;
import org.xmpp.component.ComponentException;
import org.xmpp.packet.JID;
import org.xmpp.packet.Packet;

public class MyComponent implements Component {

    public String getName() {
        return "MyComponent";
    }

    public String getDescription() {
        return "MyComponent - An experiment";
    }

    public void processPacket(Packet packet) {
        System.out.println("Received package:" + packet.toXML());
    }

    public void initialize(JID jid, ComponentManager componentManager) throws ComponentException {
        System.out.println("initialize");
    }

    public void shutdown() {
        System.out.println("shutdown");
    }

    public void start() {
        System.out.println("start");
    }

}
