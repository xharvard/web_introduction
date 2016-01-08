package com.xharvard.learning.note05.responsewrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CompressionWrapper extends HttpServletResponseWrapper {
	private GZipServletOutputStream gZipServletOutputStream;
	private PrintWriter printWriter;

	public CompressionWrapper(HttpServletResponse response) {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (printWriter != null) {
			throw new IllegalStateException();
		}

		if (gZipServletOutputStream == null) {
			gZipServletOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
		}

		return gZipServletOutputStream;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (gZipServletOutputStream != null) {
			throw new IllegalStateException();
		}

		if (printWriter == null) {
			gZipServletOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
			OutputStreamWriter osw = new OutputStreamWriter(gZipServletOutputStream,
					getResponse().getCharacterEncoding());
			printWriter = new PrintWriter(osw);
		}

		return printWriter;
	}

	// 不实现此方法，因为真在的输出会被压缩
	@Override
	public void setContentLength(int len) {
	}

	public GZIPOutputStream getGZipOutputStream() {
		if (this.gZipServletOutputStream == null) {
			return null;
		}

		return this.gZipServletOutputStream.getGzipOutputStream();
	}

}
