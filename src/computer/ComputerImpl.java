package computer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import api.Computer;
import api.Task;

public class ComputerImpl implements Computer{

	public ComputerImpl(){
		super();
	}
	
	@Override
	public <T> T execute(Task<T> t) throws RemoteException {
		return t.execute();
	}
	
	public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Computer";
            Computer compImpl = new ComputerImpl();
            Computer stub = (Computer) UnicastRemoteObject.exportObject(compImpl, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("ComputerImpl bound");
        } catch (Exception e) {
            System.err.println("ComputerImpl exception:");
            e.printStackTrace();
        }
    }
}
