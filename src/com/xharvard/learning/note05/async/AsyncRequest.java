package com.xharvard.learning.note05.async;

import java.io.PrintWriter;

import javax.servlet.AsyncContext;

public class AsyncRequest implements Runnable {
	private AsyncContext ctx;
	
	public AsyncRequest(AsyncContext ctx){
		this.ctx = ctx;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			PrintWriter pw = ctx.getResponse().getWriter();
			pw.println("久等了...");
			ctx.complete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
