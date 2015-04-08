package computer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import api.Computer;
import api.Task;

@SuppressWarnings("serial")
public class ComputerImpl extends UnicastRemoteObject implements Computer{

	public ComputerImpl() throws RemoteException{
		super();
	}
	
	@Override
	public <T> T execute(Task<T> t) throws RemoteException {
		return t.execute();
	}
	
    public static void main(String[] args) throws Exception
    {
        // construct & set a security manager (unnecessary in this case)
        System.setSecurityManager( new SecurityManager() );

        // instantiate a server object
        Computer computer = new ComputerImpl(); // can throw RemoteException

        // construct an rmiregistry within this JVM using the default port
        Registry registry = LocateRegistry.createRegistry( 1099 );

        // bind server in rmiregistry. Can throw exceptions. See api.
        registry.rebind( Computer.SERVICE_NAME, computer );

        System.out.println("ComputerImpl.main: Ready.");
    	
        
    }
}