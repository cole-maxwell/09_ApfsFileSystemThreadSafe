package cs681.apfs;

import cs681.fs.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class ApfsFile extends ApfsElement
{
	private static ReentrantLock lock = new ReentrantLock();

	public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target) {
		super(parent, name, size, creationTime, target);
	}
	public boolean inDirectory(FSElement dir) {
		System.out.println("Setting lock in ApfsFile.inDirectory()...");
		lock.lock();
		try {
			return (dir == this.parent);
		} finally {
			System.out.println("Releasing lock in ApfsFile.inDirectory()...");
			lock.unlock();
		}
	}
	public boolean isDirectory() {
		System.out.println("Setting lock in ApfsFile.isDirectory()...");
		lock.lock();
		try {
			return false;
		} finally {
			System.out.println("Releasing lock in ApfsFile.isDirectory()...");
			lock.unlock();
		}
	}
	public boolean isFile() {
		System.out.println("Setting lock in ApfsFile.isFile()...");
		lock.lock();
		try {
			return true;
		} finally {
			System.out.println("Releasing lock in ApfsFile.isFile()...");
			lock.unlock();
		}
	}
	public boolean isLink() {
		System.out.println("Setting lock in ApfsFile.isLink()...");
		lock.lock();
		try {
			return false;
		} finally {
			System.out.println("Releasing lock in ApfsFile.isLink()...");
			lock.unlock();
		}
	}	
}

