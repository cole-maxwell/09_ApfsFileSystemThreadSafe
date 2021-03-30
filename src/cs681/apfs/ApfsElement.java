package cs681.apfs;

import cs681.fs.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

abstract class ApfsElement extends FSElement
{
	private static ReentrantLock lock = new ReentrantLock();

	public ApfsElement(FSElement parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, size, creationTime, target);
	}
	public FSElement getParent() {
		System.out.println("Setting lock in ApfsElement.getParent()...");
		lock.lock();
		try {
			return parent;
		} finally {
			System.out.println("Releasing lock in ApfsElement.getParent()...");
			lock.unlock();
		}
	}
	public String getName() {
		System.out.println("Setting lock in ApfsElement.getName()...");
		lock.lock();
		try {
			return name;
		} finally {
			System.out.println("Releasing lock in ApfsElement.getName()...");
			lock.unlock();
		}
	}
	public int getSize() {
		System.out.println("Setting lock in ApfsElement.getSize()...");
		lock.lock();
		try {
			return size;
		} finally {
			System.out.println("Releasing lock in ApfsElement.getSize()...");
			lock.unlock();
		}
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public FSElement getTarget() {
		System.out.println("Setting lock in ApfsElement.getTarget()...");
		lock.lock();
		try {
			return target;
		} finally {
			System.out.println("Releasing lock in ApfsElement.getTarget()...");
			lock.unlock();
		}
	}

	public void setName(String name) {
		System.out.println("Setting lock in ApfsElement.setName()...");
		lock.lock();
		try {
			this.name = name;
		} finally {
			System.out.println("Releasing lock in ApfsElement.setName()...");
			lock.unlock();
		}
	}
	public void setSize(int size) {
		System.out.println("Setting lock in ApfsElement.setSize()...");
		lock.lock();
		try {
			this.size = size;
		} finally {
			System.out.println("Releasing lock in ApfsElement.setSize()...");
			lock.unlock();
		}
	}
	public void setParent(FSElement parent) {
		System.out.println("Setting lock in ApfsElement.setParent()...");
		lock.lock();
		try {
			this.parent = parent;
		} finally {
			System.out.println("Releasing lock in ApfsElement.setParent()...");
			lock.unlock();
		}
	}
	abstract public boolean isDirectory();
	abstract public boolean inDirectory(FSElement dir);
	abstract public boolean isFile();
	abstract public boolean isLink();

}

