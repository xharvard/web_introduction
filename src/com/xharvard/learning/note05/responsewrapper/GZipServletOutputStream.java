package com.xharvard.learning.note05.responsewrapper;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class GZipServletOutputStream extends ServletOutputStream {

	private GZIPOutputStream gzipOutputStream;

	public GZipServletOutputStream(ServletOutputStream servletOutputStream) throws IOException {
		this.gzipOutputStream = new GZIPOutputStream(servletOutputStream);
	}

	@Override
	public void write(int b) throws IOException {
		gzipOutputStream.write(b);
	}

	@Override
	public boolean isReady() {
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
	}

	public GZIPOutputStream getGzipOutputStream() {
		return gzipOutputStream;
	}
}
