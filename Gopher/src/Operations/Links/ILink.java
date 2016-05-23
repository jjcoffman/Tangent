package Operations.Links;

/**
 * Interface Class for all link objects
 * @author Jonathan Coffman
 *
 */
public interface ILink 
{
	public boolean runCommand();
	public String getUrl();
	boolean macExec();
	boolean winExec();

}
