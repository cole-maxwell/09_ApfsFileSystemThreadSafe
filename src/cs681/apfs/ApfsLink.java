package cs681.apfs;

import cs681.fs.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

public class ApfsLink extends ApfsElement
{
	private static ReentrantLock lock = new ReentrantLock();

	public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target) {
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
		System.out.println("Setting lock in ApfsLink.isDirectory()...");
		lock.lock();
		try {
			return false;
		} finally {
			System.out.println("Releasing lock in ApfsLink.isDirectory()...");
			lock.unlock();
		}
	}
	public boolean isFile() {
		System.out.println("Setting lock in ApfsLink.isFile()...");
		lock.lock();
		try {
			return false;
		} finally {
			System.out.println("Releasing lock in ApfsLink.isFile()...");
			lock.unlock();
		}
	}
	public boolean isLink() {
		System.out.println("Setting lock in ApfsLink.isLink()...");
		lock.lock();
		try {
			return true;
		} finally {
			System.out.println("Releasing lock in ApfsLink.isLink()...");
			lock.unlock();
		}
	}
}



 