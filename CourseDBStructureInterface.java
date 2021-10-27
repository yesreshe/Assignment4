import java.io.*;
import java.util.*;

public interface CourseDBStructureInterface {
	public void add(CourseDBElement element);
	
	public CourseDBElement get(int crn) throws IOException;
	public int getTableSize();

}