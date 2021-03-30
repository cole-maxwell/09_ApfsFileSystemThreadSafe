package cs681.apfs;

import cs681.fs.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class ApfsDirectory extends ApfsElement
{
	private LinkedList<ApfsElement> apfsChildren = new LinkedList<ApfsElement>();
	private LinkedList<ApfsDirectory> apfsSubDirectories = new LinkedList<ApfsDirectory>();
	private LinkedList<ApfsFile> apfsFiles = new LinkedList<ApfsFile>();
	private LinkedList<ApfsLink> apfsLinks = new LinkedList<ApfsLink>();
	private static ReentrantLock lock = new ReentrantLock();

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target) {
		super(parent, name, size, creationTime, target);
	}

	public boolean inDirectory(FSElement dir) {
		System.out.println("Setting lock in ApfsLink.inDirectory()...");
		lock.lock();
		try {
			return (dir == this.parent);
		} finally {
			System.out.println("Releasing lock in ApfsLink.inDirectory()...");
			lock.unlock();
		}
	}
	public boolean isDirectory() {
		System.out.println("Setting lock in ApfsDirectory.isDirectory()...");
		lock.lock();
		try {
			return true;
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.isDirectory()...");
			lock.unlock();
		}
	}
	public boolean isFile() {
		System.out.println("Setting lock in ApfsDirectory.isFile()...");
		lock.lock();
		try {
			return false;
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.isFile()...");
			lock.unlock();
		}
	}
	public boolean isLink() {
		System.out.println("Setting lock in ApfsDirectory.isLink()...");
		lock.lock();
		try {
			return false;
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.isLink()...");
			lock.unlock();
		}
	}

	public void appendChild(ApfsElement child) {

		System.out.println("Setting lock in ApfsDirectory.appendChild()...");
		lock.lock();
		try {
			if (child.isDirectory()) {
				this.apfsSubDirectories.add((ApfsDirectory)child);
				this.apfsChildren.add(child);
				child.setParent(this);			
			} else if (child.isFile()) {
				this.apfsFiles.add((ApfsFile)child);
				this.apfsChildren.add(child);
				child.setParent(this);			
			} else {
				this.apfsLinks.add((ApfsLink)child);
				this.apfsChildren.add(child);
				child.setParent(this);
			}
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.appendChild()...");
			lock.unlock();
		}
	}

	public LinkedList<ApfsElement> getChildren() {
		return apfsChildren;
	}

	public LinkedList<ApfsDirectory> getSubDirectories() {
		System.out.println("Setting lock in ApfsDirectory.getSubDirectories()...");
		lock.lock();
		try {
			return apfsSubDirectories;
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.getChildren()...");
			lock.unlock();
		}
	}

	public LinkedList<ApfsFile> getFiles() {
		System.out.println("Setting lock in ApfsDirectory.getFiles()...");
		lock.lock();
		try {
			return apfsFiles;
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.getFiles()...");
			lock.unlock();
		}		
	}

	public LinkedList<ApfsLink> getLinks() {
		System.out.println("Setting lock in ApfsDirectory.getLinks()...");
		lock.lock();
		try {
			return apfsLinks;
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.getLinks()...");
			lock.unlock();
		}		
	}

	public int countChildren() {
		System.out.println("Setting lock in ApfsDirectory.getLinks()...");
		lock.lock();
		try {
			return this.apfsChildren.size();	
		} finally {
			System.out.println("Releasing lock in ApfsDirectory.getLinks()...");
			lock.unlock();
		}	
	}

	public int getTotalSize() {
		
		int totalSize = 0;
	
		// for (ApfsFile ApfsFile: this.getFiles()) {
		// 	totalSize = totalSize + apfsFile.getSize();
		// }
		// for (ApfsDirectory dir: this.getSubDirectories())   {
		// 	dir.getTotalSize();
		// }
		return totalSize;	
	}
}

