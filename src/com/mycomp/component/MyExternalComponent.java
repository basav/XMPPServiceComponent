package com.mycomp.component;
import org.jivesoftware.whack.ExternalComponentManager;
import org.xmpp.component.ComponentException;

public class MyExternalComponent {

    public static void main(String[] args) {

        // Create a manager for the external components that will connect to the server "localhost"
        // at the port 5275
        final ExternalComponentManager manager = new ExternalComponentManager("localhost", 8888);

        // Set the secret key for this component. The server must be using the same secret key
        // otherwise the component won't be able to authenticate with the server.
        manager.setSecretKey("myComponent", "secret");

        // Set the manager to tag components as being allowed to connect multiple times to the same JID.
        manager.setMultipleAllowed("myComponent", true);

        try {
            // Register that this component will be serving the given subdomain of the server
            manager.addComponent("myComponent", new MyComponent());

            // Quick trick to ensure that this application will be running for ever. To stop the
            // application you will need to kill the process

            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (ComponentException e) {
            e.printStackTrace();
        }
    }
}