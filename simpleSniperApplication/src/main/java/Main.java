import io.ApplicationManager;

import javax.management.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {

        ApplicationManager applicationManager = new ApplicationManager();
        applicationManager.initialisation();
    }
}
