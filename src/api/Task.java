package api;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Task<T> extends Remote{
	
	 public static String SERVICE_NAME = "TaskService";

	 T execute() throws RemoteException;
}
