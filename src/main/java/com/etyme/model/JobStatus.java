package com.etyme.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class JobStatus {
	
	public static int STATUS_ACTIVE = 0;
	public static int STATUS_FULL = 1;
	public static int STATUS_ONHOLD = 2;
	public static int STATUS_UPCOMING = 3;
	public static int STATUS_CANCELLED = 4;
	public static int STATUS_LEAD = 5;
	public static int STATUS_CLOSED = 6;
	
	private int id;
	private String status;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List getAllStatus() {
		List st = new ArrayList();
		JobStatus jb = new JobStatus();
		jb.setId(STATUS_ACTIVE);
		jb.setStatus("Active");
		st.add(jb);

		jb = new JobStatus();
		jb.setId(STATUS_CANCELLED);
		jb.setStatus("Cancelled");
		st.add(jb);

		jb = new JobStatus();
		jb.setId(STATUS_CLOSED);
		jb.setStatus("Closed");
		st.add(jb);
		
		jb = new JobStatus();
		jb.setId(STATUS_FULL);
		jb.setStatus("Full");
		st.add(jb);
		
		jb = new JobStatus();
		jb.setId(STATUS_LEAD);
		jb.setStatus("Lead");
		st.add(jb);
		
		jb = new JobStatus();
		jb.setId(STATUS_ONHOLD);
		jb.setStatus("OnHold");
		st.add(jb);

		jb = new JobStatus();
		jb.setId(STATUS_UPCOMING);
		jb.setStatus("Upcoming");
		st.add(jb);
		
		return st;
	}
}
