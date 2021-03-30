package cs681.fs;
import cs681.apfs.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.locks.*;

abstract public class FSElement
{
	protected FSElement parent;
	protected String name;
	protected int size;
	protected LocalDateTime creationTime;
	protected FSElement target;
	private boolean done = false;
	private static ReentrantLock lock = new ReentrantLock();

	public FSElement(FSElement parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
		this.target = target;
	}

	public FSElement getParent() {
		System.out.println("Setting lock in FSElement.getParent()...");
		lock.lock();
		try {
			return parent;
		} finally {
			System.out.println("Releasing lock in FSElement.getParent()...");
			lock.unlock();
		}
	}
	public String getName() {
		System.out.println("Setting lock in FSElement.getName()...");
		lock.lock();
		try {
			return name;
		} finally {
			System.out.println("Releasing lock in FSElement.getName()...");
			lock.unlock();
		}
	}
	public int getSize() {
		System.out.println("Setting lock in FSElement.getSize()...");
		lock.lock();
		try {
			return size;
		} finally {
			System.out.println("Releasing lock in FSElement.getSize()...");
			lock.unlock();
		}
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public FSElement getTarget() {
		System.out.println("Setting lock in FSElement.getTarget()...");
		lock.lock();
		try {
			return target;
		} finally {
			System.out.println("Releasing lock in FSElement.getTarget()...");
			lock.unlock();
		}
	}

	public void setName(String name) {
		System.out.println("Setting lock in FSElement.setName()...");
		lock.lock();
		try {
			this.name = name;
		} finally {
			System.out.println("Releasing lock in FSElement.setName()...");
			lock.unlock();
		}
	}
	public void setSize(int size) {
		System.out.println("Setting lock in FSElement.setSize()...");
		lock.lock();
		try {
			this.size = size;
		} finally {
			System.out.println("Releasing lock in FSElement.setSize()...");
			lock.unlock();
		}
	}
	public void setParent(FSElement parent) {
		System.out.println("Setting lock in FSElement.setParent()...");
		lock.lock();
		try {
			this.parent = parent;
		} finally {
			System.out.println("Releasing lock in FSElement.setParent()...");
			lock.unlock();
		}
	}

	abstract public boolean isDirectory();
	abstract public boolean inDirectory(FSElement dir);
	abstract public boolean isFile();
	abstract public boolean isLink();

}

