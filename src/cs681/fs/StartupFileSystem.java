package cs681.fs;
import cs681.apfs.*;
import java.time.LocalDateTime;

public class StartupFileSystem {
	public static void main(String[] args)
	{
        APFS apfs = new APFS("new apfs", 1024);
        apfs.initFileSystem("new apfs", 1024);

        System.out.println("\n" + apfs.getCapacity() + "\n");
        System.out.println("\n" + apfs.getName() + "\n");

        ApfsDirectory root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), null); 
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), null);
        ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, LocalDateTime.now(), null);
        ApfsDirectory code = new ApfsDirectory(home, "code", 0, LocalDateTime.now(), null);
        
        ApfsFile a = new ApfsFile(null, "a.txt", 8, LocalDateTime.now(), null);
        ApfsFile b = new ApfsFile(null, "b.txt", 16, LocalDateTime.now(), null);
        ApfsFile c = new ApfsFile(null, "c.txt", 32, LocalDateTime.now(), null);
        ApfsFile d = new ApfsFile(null, "d.txt", 64, LocalDateTime.now(), null);
        ApfsFile e = new ApfsFile(null, "e.txt", 128, LocalDateTime.now(), null);
        ApfsFile f = new ApfsFile(null, "f.txt", 256, LocalDateTime.now(), null);

        ApfsLink x = new ApfsLink(home, "linkToApplications", 0, LocalDateTime.now(), applications);
        ApfsLink y = new ApfsLink(code, "linkToFileB", 0, LocalDateTime.now(), b); 

        System.out.println("\n" + apfs.getRootDir().name + "\n");
        
        apfs.appendRootDir(root);
        System.out.println("\n" + apfs.getRootDir().name + "\n");
        root.appendChild(applications);
        root.appendChild(home);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(x);
        code.appendChild(e);
        code.appendChild(f);
        code.appendChild(y);

        for (FSElement apfsElement: home.getLinks())   {
            System.out.println("\nLink Name: " + apfsElement.getName() + "\n");
            System.out.println("\nLink Size: " + apfsElement.getSize() + "\n");
            System.out.println("\nLink Creation time: " + apfsElement.getCreationTime() + "\n");
            System.out.println("\nIs link: " + apfsElement.isDirectory() + "\n");
            System.out.println("\nIs directory: " + apfsElement.isDirectory() + "\n");
            System.out.println("\nIs file: " + apfsElement.isDirectory() + "\n");
            System.out.println("\nLink Parent name: " + apfsElement.getParent().getName() + "\n");
            System.out.println("\nLink Target name: " + apfsElement.getTarget().getName() + "\n");
            System.out.println("\nLink Target size: " + apfsElement.getTarget().getSize() + "\n");
            System.out.println("\nLink Target Creation Time: " + apfsElement.getTarget().getCreationTime() + "\n");
        }
	}
}




