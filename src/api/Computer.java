package api;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Computer extends Remote{
	 
	public static String SERVICE_NAME = "ComputerService";
	public static int PORT = 1000;
	
	<T> T execute(Task<T> t) throws RemoteException;
	
}
