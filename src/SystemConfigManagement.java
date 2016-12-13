import com.jmx.example.ISystemConfigMXBean;
import com.jmx.example.SystemConfig;

import javax.management.*;
import java.lang.management.*;

public class SystemConfigManagement {
    private static final int DEFAULT_NO_THREADS = 10;
    private static final String DEFAULT_SCHEMA = "default";
    private MBeanServer mbs = null;
    private static SystemConfig objImpl;

    public SystemConfigManagement() throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        mbs = ManagementFactory.getPlatformMBeanServer();

        objImpl = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        StandardMBean mBean = new StandardMBean(objImpl, ISystemConfigMXBean.class);
        ObjectName name = null;

        try {
            name = new ObjectName("FOO:name=SystemConfig");

           mbs.registerMBean(mBean, name);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        SystemConfigManagement scm = new SystemConfigManagement();
        scm.getThreadCount(objImpl);

    }

    public static void getThreadCount(SystemConfig mbean) throws InterruptedException{

        do {
            Thread.sleep(3000);
            System.out.println("Thread Count=" + mbean.getThreadCount() + ":::Schema Name=" + mbean.getSchemaName());
        } while (mbean.getThreadCount() != 0);

    }

}